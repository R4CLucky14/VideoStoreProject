import java.io.FileNotFoundException;

/**
 * 
 * @author Matt McClain group 4
 * 
 * This is the main class to run the entire code
 * the login gui is the main screen and the saveDB methods save the CSV files
 *
 */
public class tester

{
public static void main(String[] args) throws Exception
{
	AVSVideoDatabase.loadDB();
	AVSCustomerDatabase.loadDB();
	
	LoginGUI login = new LoginGUI();
	login.runGUI();
	
	AVSVideoDatabase.saveDB();
	AVSCustomerDatabase.saveDB();
	
}
}
