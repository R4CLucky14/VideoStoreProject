import java.io.FileNotFoundException;

/**
 *  AVSDatabase Staff Class
 * @author James Haug - Group 4
 * @version 2013.03.30
 */

public class AVSStaffDatabase
{
	/**
	 * Uses a user name and password combination, and asks the CSVReader for a match. If no match, null is returned.
	 * 
	 * @param username
	 * @param password
	 * @return Staff user
	 * @throws FileNotFoundException
	 */
	public static Staff login(String username, String password) throws FileNotFoundException
	{
		CSVReader input = new CSVReader();
		while(input.hasStaff())
		{
			// James - 03/23/2014 - If putting in username and password for 2nd login, the first input.nextStaff would return null. This would simply pass null. 
			return input.nextStaff(username, password);
		}
		return null;
	}
	
	/**
	 * Sets user to null.
	 * 
	 * @param user
	 */
	public static void logout(Staff user)
	{
		user = null;
	}
}
