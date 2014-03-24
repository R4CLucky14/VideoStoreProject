/**
 * Holds an Array List of Videos. This is the primary database class, providing the primary functions the GUI calls. This class works closely with AVSCustomerDatabase due to Video - Customer relationships.
 * This class is designed to not be initialized, but it can be initialized if there is a need to do so. 
 *
 * @author James Haug - Group 4
 * @version 2013.03.30
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author James
 *
 */

public class AVSVideoDatabase
{
	private static ArrayList<Video> videos;
	
	/**
	 * Constructor for class AVSVideoDatabase
	 */
	public AVSVideoDatabase()
	{
		videos = new ArrayList<Video>();
	}
		
	/**
	 * Generates and returns an ArrayList of all Overdue Videos.
	 * 
	 * @return Overdue List
	 */
	public static ArrayList<Video> getOverdueList(Staff staff)
	{
		if(staff.isManager())
		{
			ArrayList<Video> overdue = new ArrayList<Video>();
			for (int i = 0 ; i < videos.size(); i++)
			{
				if(videos.get(i).isOverdue())
					overdue.add(videos.get(i));
			}		
			
			return overdue;
		}
		return null;
	}
	
	/**
	 * Loads from videos.csv. Replaces everything in memory with information saved in file.
	 * 
	 * @throws FileNotFoundException
	 */	
	public static void loadDB() throws FileNotFoundException
	{
		videos = new ArrayList<Video>();
		CSVReader input = new CSVReader();
		while(input.hasVideo())
		{
			addVideo(input.nextVideo());
		}
	}
	
	/**
	 * Saves to videos.csv. Overwrites all content in file.
	 * @return 
	 * 
	 * @throws IOException
	 */
	public static void saveDB() throws IOException
	{
		File file = new File("src//videos.csv");
		if(file.exists())
			file.delete();
		file.createNewFile();
		CSVWriter output = new CSVWriter(file);
		output.addDatum(toCSVString());
		output.finish();

	}
	
	/**
	 * Adds an existing video to the array. 
	 * If the videoID is already used, the copyID is incremented, the ID is reset, and the method is attempted again.
	 * 
	 * @param video
	 */
	public static void addVideo(Video video)
	{
		video.setID();
		if(!checkID(video.getVideoID()))
			videos.add(video);
		else
			retryAddVideo(video);
	}
	
	/**
	 * Removes Video from Database using videoID
	 * 
	 * @param videoID
	 */
	public static void removeVideo(String videoID)
	{
		for (int i = 0 ; i < videos.size(); i++)
		{
			if(videoID.equals(videos.get(i).getVideoID()))
				videos.remove(i);
		}			
	}
	
	/**
	 * Helper Method for addVideo. Increments Available and then recalls addVideo().
	 * 
	 * @param video
	 */
	private static void retryAddVideo(Video video)
	{
		video.addAvailable();
		addVideo(video);
	}
	
	/**
	 * Creates a new video and adds it the array.
	 * 
	 * @param videoTitle
	 * @param category
	 * @param daysOut
	 * @param copyID
	 * @param customerCardID
	 */
	public static void addNewVideo(String videoTitle, String category, int daysOut, int copyID, String customerCardID)
	{
			addVideo(new Video(videoTitle, category, daysOut, copyID, customerCardID));
	}
	
	/**
	 * Creates a new video and adds it the array.
	 * 
	 * @param videoTitle
	 * @param category
	 */
	public static void addNewVideo(String videoTitle, String category)
	{
			addVideo(new Video(videoTitle, category, 0, 1, null));
	}	
	
	/**
	 * Returns video using VideoID
	 * 
	 * @param videoID
	 * @return Returns the video using the VideoID.
	 */
	public static Video getVideo(String videoID)
	{
		for (int i = 0 ; i < videos.size(); i++)
		{
			if(videoID.equals(videos.get(i).getVideoID()))
				return videos.get(i);
		}
		return null;
	}
	
	/**
	 * Helper Method. Checks to see if videoID is unique or not.
	 * If not unique (that videoID already exist), true is returned.
	 * If unique (that videoID does not exist), false is returned.
	 * 
	 * @param videoID
	 * @return boolean False if there is no match. True if there a match
	 */
	private static boolean checkID(String videoID)
	{
		for (int i = 0 ; i < videos.size(); i++)
		{
			if(videoID.equals(videos.get(i).getVideoID()))
				return true;
		}
		return false;		
	}
	
	/**
	 * This tests to see if the video can be checked out. It will check:
	 * If the customer has fees (If yes, return false).
	 * If the videoID is in the database (If no, return false).
	 * If the videoID is available for rent (If no, return false).
	 * If the customer has at least 3 videos already checked out (If yes, return false).
	 * 
	 * Thus, if the result is false, the video can not be checked out for one of those four reasons. If true, the video is ready to be checked out.
	 * 
	 * @param videoID
	 * @param customerCardID
	 * @return False if video can not be checked out. True if video can be checked out.
	 */
	public static boolean canCheckoutVideo(String videoID, String customerCardID)
	{
		for (int i = 0 ; i < videos.size(); i++)
			if(!AVSCustomerDatabase.getCustomer(customerCardID).hasFee())
				if(videoID.equals(videos.get(i).getVideoID()))
					if(getVideo(videoID).getCustomerCardID() != null)
						if(getCheckedOutList(customerCardID).size() < 3)
							return true;
		return false;
	}
	
	/**
	 * Checks out video (attaches the customerID to the video). This should be called after a successful test of canCheckoutVideo.
	 * 
	 * @param videoID
	 * @param customerCardID
	 */
	public static void checkoutVideo(String videoID, String customerCardID)
	{
		for (int i = 0 ; i < videos.size(); i++)
			if(videoID.equals(videos.get(i).getVideoID()))
				videos.get(i).setCustomerCardID(customerCardID);
	}
	
	/**
	 * This checks in a video. This method will find the checked out copy in the array, match the Video and Customer ID's, check to see if there needs to be an overdue and/or damaged fee, and charges any fees to the customer. 
	 * If video is damaged, the video is removed from the database.
	 * 
	 * After charging fees, the customer is removed from the video and the daysOut is reset.
	 * 
	 * @param videoID
	 * @param customerCardID
	 * @param damaged
	 */
	public static void checkinVideo(String videoID, String customerCardID, boolean damaged)
	{
		for (int i = 0 ; i < videos.size(); i++)
		{
			if(videoID.equals(videos.get(i).getVideoID()) && customerCardID.equals(videos.get(i).getCustomerCardID()))
			{
				if(videos.get(i).isOverdue())
				{
					AVSCustomerDatabase.getCustomer(customerCardID).chargeFee(getVideo(videoID).getOverdueFee());
				}
				if(damaged)
				{
					AVSCustomerDatabase.getCustomer(customerCardID).chargeFee(getVideo(videoID).getDamagedFee());
					removeVideo(videoID);
				}
				videos.get(i).setCustomerCardID(null);
				videos.get(i).resetDaysOut();
				break;
			}
		}
	}
	
	/**
	 * Checks to see if the customer entry can be removed.
	 * 
	 * @param customerCardID
	 * @return Returns true if the customer has no videos checked out. Returns false if the customer has videos checked out.
	 */
	public static boolean canRemoveCustomer(String customerCardID)
	{
		for (int i = 0 ; i < videos.size(); i++)
		{
			if(customerCardID.equals(videos.get(i).getCustomerCardID()))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Searches for and returns an ArrayList of Videos that are currently checked out by that customer.
	 * 
	 * @param customerCardID
	 * @return ArrayList<Video> that holds the Checked Out Videos for that Customer ID.
	 */
	public static ArrayList<Video> getCheckedOutList(String customerCardID)
	{
		ArrayList<Video> overdue = new ArrayList<Video>();
		for (int i = 0 ; i < videos.size(); i++)
		{
			if(customerCardID.equals(videos.get(i).getCustomerCardID()))
			{
				overdue.add(videos.get(i));
			}
		}
		return overdue;
	}
	
	/**
	 * Prepares a String for printing by the CSVWriter.
	 * 
	 * @return String for the CSVWriter
	 */
	public static String toCSVString()
	{
		String output ="";
		for( int i = 0 ; i < videos.size() ; i++)
		{
			output += videos.get(i).toString() + "\n";
		}
		return output;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String output ="";
		for( int i = 0 ; i < videos.size() ; i++)
		{
			output += videos.get(i).toString() + "\n";
		}
		return output;
	}
}

