/**
 * Creates and manages active user
 * @author John Stricklin
 *
 */
public class Staff
{
	private String lastName;
	private String firstName;
	private String userName;
	private String empAddress;
	private boolean manager = false;
	/**
	**  Constructor
	** @param 
	**/
	public Staff(String usrname, String last, String first, String address, boolean mgr)
	{
		lastName = last;
		firstName = first;
		userName = usrname;
		empAddress = address;
		manager = mgr;
		empAddress = "";
	}
	
	public boolean isManager()
	{
		if(manager == true)
		{
			return true;
		}
		return false;
	}
	
	public String getUserName()
		{
			return userName;
		}	
}
