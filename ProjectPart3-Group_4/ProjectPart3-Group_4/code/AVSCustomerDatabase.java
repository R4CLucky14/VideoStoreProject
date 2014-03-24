import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author James - Group 4
 *
 */
public class AVSCustomerDatabase
{
	private static ArrayList<Customer> customers;
	
	/**
	 * Constructor for Class AVSCustomerDatabase
	 */
	public AVSCustomerDatabase()
	{
		customers = new ArrayList<Customer>();
	}
	
	/**
	 * Loads from customers.csv. Replaces everything in memory with information saved in customers.csv
	 * 
	 * @throws FileNotFoundException
	 */
	public static void loadDB() throws FileNotFoundException
	{
		customers = new ArrayList<Customer>();
		CSVReader input = new CSVReader();
		while(input.hasCustomer())
		{
			addCustomer(input.nextCustomer());
		}
	}
	
	/**
	 * Saves to customers.csv. Overwrites all content in file.
	 * 
	 * @throws IOException
	 */
	public static void saveDB() throws IOException
	{
		File file = new File("src//customers.csv");
		if(file.exists())
			file.delete();
		file.createNewFile();
		CSVWriter output;
		output = new CSVWriter(file);
		output.addDatum(toCSVString());
		output.finish();
	}
	
	/**
	 * Adds a customer to the array.
	 * 
	 * @param customer
	 */
	public static void addCustomer(Customer customer)
	{
		customer.setID();
		if(!checkID(customer.getCustomerCardID()))
			customers.add(customer);
	}
	
	
	/**
	 * Checks to see if customerID already exist in the array list.
	 * 
	 * @param customerCardID
	 * @return True if the customerID exists. False if the customerID does not exists.
	 */
	private static boolean checkID(String customerCardID)
	{
		for (int i = 0 ; i < customers.size(); i++)
		{
			if(customerCardID.equals(customers.get(i).getCustomerCardID()))
				return true;
		}
		return false;	
	}

	/**
	 * Creates a new customer and adds it to the array. 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param gender
	 * @param phoneNum
	 * @param customerFee
	 */
	public static void addNewCustomer(String firstName, String lastName, String address, String email, char gender, String phoneNum, int customerFee)
	{
		addCustomer(new Customer(firstName, lastName, address, email, gender, phoneNum, customerFee));
	}
	
	/**
	 * Gets customer from CustomerID.
	 * 
	 * @param customerCardID
	 * @return Returns customer.
	 */
	public static Customer getCustomer(String customerCardID)
	{
		for (int i = 0 ; i < customers.size(); i++)
		{
			if(customerCardID.equals(customers.get(i).getCustomerCardID()))
				return customers.get(i);
		}
		return null;
	}
	
	/**
	 * Removes customer from Database using videoID if the customer can be removed.
	 * 
	 * @param customerCardID
	 */
	public static void removeCustomer(String customerCardID)
	{
		for (int i = 0 ; i < customers.size(); i++)
		{
			if(customerCardID.equals(customers.get(i).getCustomerCardID()))
			{
				if(AVSVideoDatabase.canRemoveCustomer(customerCardID))
					customers.remove(i);
			}
		}			
	}
	
	/**
	 * Pays off the fee for a customer.
	 * 
	 * @param customerCardID
	 */
	public static void payFee(String customerCardID)
	{
		for (int i = 0 ; i < customers.size(); i++)
		{
			if(customerCardID.equals(customers.get(i).getCustomerCardID()))
				customers.get(i).payFee();

		}				
	}

	/**
	 * Returns the ArrayList as a String ready for CSV Output
	 * 
	 * @return String
	 */
	public static String toCSVString()
	{
		String output ="";
		for( int i = 0 ; i < customers.size() ; i++)
		{
			output += customers.get(i).toString() + "\n";
		}
		return output;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String output ="";
		for( int i = 0 ; i < customers.size() ; i++)
		{
			output += customers.get(i).toString() + "\n";
		}
		return output;
	}
}
