import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Reads the three CSV files and returns the associated values for each CSV file.
*
* @author James Francis Haug - Group 4
* @version 2013.03.3
*/
public class CSVReader
{
	Scanner video;
	Scanner customer;
	Scanner staff;
	Scanner buffer;
	
	/**
	 * Constructor for class CSVReader.
	 * 
	 * @param file File to be read.
	 * @throws FileNotFoundException
	 */
	public CSVReader() throws FileNotFoundException
	{
		this.video = new Scanner(new File("src//videos.csv"));
		this.customer = new Scanner(new File("src//customers.csv"));
		this.staff = new Scanner(new File("src//staff.csv"));
	}
	/**
	* Checks to see if the file has another line. When returning false, the file is closed.
	*
	* @return True if CSV file has another line. Otherwise, false.
	*/
	public boolean hasVideo()
	{
		if(video.hasNextLine())
		{
			return true;
		}
		else
		{
			video.close();
			return false;
		}
	}
	
	/**
	* Checks to see if the file has another line. When returning false, the file is closed.
	*
	* @return True if CSV file has another line. Otherwise, false.
	*/	
	public boolean hasCustomer()
	{
		if(customer.hasNextLine())
		{
			return true;
		}
		else
		{
			customer.close();
			return false;
		}
	}	
	/**
	* Reads the CSV file by line, placing the contents of the CSV line into a Video object.
	*
	* @return Returns the values in the file as a Video.
	*/
	public Video nextVideo()
	{		
		buffer = new Scanner(video.nextLine());
		buffer.useDelimiter(",");
		buffer.next(); //Skips over videoID - videoID will be generated when entered into array.
		String videoTitle = buffer.next();
		String category = buffer.next();
		int daysOut = buffer.nextInt();
		int copyID = buffer.nextInt();
		String customerCardID = null;;
		if(buffer.hasNext())
			customerCardID = buffer.next();
		return new Video(videoTitle, category, daysOut, copyID, customerCardID);
		
	}
	
	/**
	* Reads the CSV file by line, placing the contents of the CSV line into a Customer object.
	*
	* @return Returns the values in the file as a Customer.
	*/	
	public Customer nextCustomer()
	{		
		buffer = new Scanner(customer.nextLine());
		buffer.useDelimiter(", *");
		buffer.next();
		return new Customer(buffer.next(), buffer.next(), buffer.next(), buffer.next(), buffer.next().charAt(0), buffer.next(), buffer.nextInt());
	}
	
	/**
	* Checks to see if the file has another line. When returning false, the file is closed.
	*
	* @return True if CSV file has another line. Otherwise, false.
	*/
	public boolean hasStaff()
	{
		if(staff.hasNextLine())
		{
			return true;
		}
		else
		{
			staff.close();
			return false;
		}
	}
	
	/**
	 * Matches the username, then the password. If no match, null is returned.
	 * If matched, a Staff object is generated and returned using the rest of the information on the line.
	 * 
	 * @param user
	 * @param pass
	 * @return Staff matching username and password
	 */
	public Staff nextStaff(String user,String pass)
	{
		buffer = new Scanner(staff.nextLine());
		buffer.useDelimiter(",");
		if(buffer.hasNext(user)) //Matches username
		{
			buffer.next(); //Skips username
			if(buffer.hasNext(pass)) //Matches password
			{
				buffer.next(); //Skips Password
				String last = buffer.next();
				String first = buffer.next();
				String address = buffer.next();
				boolean mgr = buffer.nextBoolean();
				return new Staff(user, last, first, address, mgr);
			}
		}
		return null;
	}
}
