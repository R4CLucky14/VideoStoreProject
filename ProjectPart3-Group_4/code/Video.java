//import java.util.Scanner;

/**
 * Contains basic information of the video.  
 * @author Harold Hansen - Group 4
 *
 */

public class Video 
{
	private final int OVERDUE = 3;
	private final int RENTAL_FEE = 2;
	private final int DAMAGED_FEE = 3;
	private final int OVERDUE_FEE = 1;
	private int daysOut;
	//Format for videoID:  1st 2 chars (Category), Entire title or 1st 5 chars (smallest of two), video number
	//Ex:  Title:  Transformers 2, Category:  Action (AC), Video num:  03... videoID:  ACTrans03
	private String videoID;
	private String videoTitle;
	private String videoCategory;
	private int available;
	private int fees;
	private String customerCardID;
	/**
	 * Constructor with no params that sets all strings to empty strings and all ints to zero except for fees which 
	 * is equal to RENTAL_FEE
	 */
	public Video()
	{
		videoID ="";
		videoTitle = "";
		videoCategory = "";
		daysOut = 0;
		available = 0;
		fees = RENTAL_FEE;
		customerCardID = null;
	}
	/**
	 * Constructor for Video has all params necessary for making a new video object.
	 * @param videoTitle
	 * @param category
	 * @param daysOut
	 * @param available
	 * @param customerCardID
	 */
	public Video(String videoTitle, String category, int daysOut, int available, String customerCardID)
	{
		this.videoTitle = videoTitle;
		videoCategory = category;
		this.available = available;
		this.available = 1;
		fees = RENTAL_FEE;
		this.daysOut=daysOut;
		this.customerCardID = customerCardID; // Added by James
		setCategory(category); //Added by James
	}
	/**
	 * Method sets the title of the movie.
	 * @param title Title of the movie.
	 */
	public void setTitle(String title)
	{
		videoTitle = title;
	}
	/**
	 * Method sets the ID of the movie.
	 * @param ID ID of the movie that may be a composed of characters and/or integers.
	 * @param arrayID Index in the array which designates the movie number
	 */
	public void setID()
	{
		int max = 5;
		if (max > videoTitle.length())
			max = videoTitle.length();
		videoID = videoCategory + videoTitle.substring(0,max) + available;

	}
	
	/**
	 * Method sets the category of the movie.
	 * @param category Type of movie.
	 */
	public void setCategory(String category)
	{
		if(category.equalsIgnoreCase("Horror") || category.equals("1"))
		{
			videoCategory = "HO";
		}else if(category.equalsIgnoreCase("Action") || category.equals("2"))
		{
			videoCategory = "AC";
		}else if(category.equalsIgnoreCase("Comedy") || category.equals("3"))
		{
			videoCategory = "CO";
		}else if(category.equalsIgnoreCase("Drama") || category.equals("4"))
		{
			videoCategory = "DR";
		}else if(category.equalsIgnoreCase("Sci-Fi") || category.equals("4"))
		{
			videoCategory = "SF";
		}
	}
	
	/**
	 * Returns the title of the movie.
	 * @return Title of movie as a string.
	 */
	public String getTitle()
	{
		return videoTitle;
	}
	
	/**
	 * Returns the video ID
	 */
	public String getVideoID()
	{
		return videoID;		
	}

	/**
	 * Returns the category of the movie.
	 * @return Category of the movie as a string.
	 */
	public String getCategory()
	{
		return videoCategory;
	}
	
	
	/**
	 * Method checks the overdue status of the movie.
	 * @return Boolean of overdue status.
	 */
	//count total days overdue
	public boolean isOverdue()
	{
		if(daysOut > OVERDUE)
			return true;
		else
			return false;
	}
	/**
	 * Increments Available copy.
	 */
	public void addAvailable()
	{
		available++;
	}
	
	/**
	 * Decrements available copy.
	 */
	public void subtractAvailable()
	{
		available--;
	}
	
	/**
	 * Gets Available left.
	 * @return Available copy's on the shelf.
	 */
	public int getAvailable()
	{
		return available;
	}
	/**
	 * @return Overdue Fee for Video
	 */
	public int getOverdueFee()
	{
		return OVERDUE_FEE;
	}
	
	/**
	 * @return Damaged Fee for Video
	 */
	public int getDamagedFee()
	{
		return DAMAGED_FEE;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return 	this.getVideoID() + "," 
				+ this.getTitle() + "," 
				+ this.getCategory() + ","  
				+ this.daysOut + ","
				+ this.getAvailable() + ","
				+ this.getCustomerCardID();
	}
	/**
	 * @return Returns customerCardID
	 */
	public String getCustomerCardID()
	{
		return customerCardID;
	}

	/**
	 * Sets customerCardID
	 * 
	 * @param cardID
	 */
	public void setCustomerCardID(String cardID)
	{
		customerCardID = cardID;
	}
	/**
	 * Resets DaysOut to 0
	 */
	public void resetDaysOut()
	{
		daysOut = 0;
	}
}

