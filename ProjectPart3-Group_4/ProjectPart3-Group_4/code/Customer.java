/**
 * Rents videos from AVS Database, pays AVS fees, interacts with AVS Staff,
 * interacts with AVS Managers.
 * @author Harold Hansen - Group 4
 *
 */

public class Customer
{
	
	private String customerCardID;
	private String customerFirstName;
	private String customerLastName;
	private String customerAddress;
	private String customerEmailAddress;
	private String customerPhoneNum;
	private char customerGender;
	private int customerFees;
	
	public Customer()
	{
		customerCardID = ""; //LASTNAME (3 FIRST NAME) (last 4 PHONE NUMBER)
		customerFirstName = "";
		customerLastName = "";
		customerAddress = "";
		customerEmailAddress = "";
		customerGender = 'm';
		customerPhoneNum = "";
		customerFees = 0;
	}
	/**
	 * Constructor for adding a new customer or completely changing a customer.
	 * @param number
	 * @param name
	 * @param address
	 */
	public Customer(String firstName, String lastName, String address, String email, char gender, String phoneNum, int fees)
	{
		customerFirstName = firstName;
		customerLastName = lastName;
		customerCardID = customerLastName.concat(firstName.substring(0, 2));
		customerAddress = address;
		customerEmailAddress = email;
		customerGender = gender;
		customerPhoneNum = phoneNum;
		customerFees = fees;
	}
	/**
	 * Method sets the customer's AVS customer card ID.
	 * @param card Customer ID
	 */
	public void setID()
	{
		customerCardID = customerLastName.concat(customerFirstName.substring(0, 3)).concat(customerPhoneNum.substring(6, 10));
	}
	/**
	 * Method sets the customer's name.
	 * @param name Customer name
	 */
	public void setName(String firstName, String lastName)
	{
		customerFirstName = firstName;
		customerLastName = lastName;
	}
	/**
	 * Method sets the gender.
	 */
	public void setGender(char g)
	{
		customerGender = g;
	}
	/**
	 * Method sets the customer's phone number
	 */
	public void setPhoneNumber(String pNum)
	{
		customerPhoneNum = pNum;
	}
	/**
	 * Method sets the customer's address.
	 * @param address Customer's address
	 */
	public void setAddress(String address)
	{
		customerAddress = address;
	}
	/**
	 * Method sets the customer's email address
	 */
	public void setEmailAddress(String eAddress)
	{
		customerEmailAddress = eAddress;
	}
	/**
	 * Method returns the customer's last name
	 */
	public String getLastName() 
	{
		return customerLastName;
	}
	/**
	 * Method returns the customer's first name
	 */
	public String getFirstName() 
	{
		return customerFirstName;
	}
	/**
	 * Method returns the customer's gender
	 */
	public char getGender()
	{
		return customerGender;
	}
	/**
	 * Method returns the customer's phone number
	 */
	public String getPhoneNum()
	{
		return customerPhoneNum;
	}
	/**
	 * Method returns the customer's full name (First name + Last name)
	 */
	public String getName() 
	{
		return customerFirstName + " " + customerLastName;
	}
	/**
	 * Methods returns customerCardID
	 */
	public String getCustomerCardID() 
	{
		return customerCardID;
	}	
	/**
	 * Methods returns customer's address
	 */
	public String getAddress() 
	{
		return customerAddress;
	}
	/**
	 * Method gets the cusomter's email address.
	 */
	public String getEmailAddress()
	{
		return customerEmailAddress;
	}	
	/**
	 * Charges a fee on the customer's tab.
	 * @param fee Amount to charge customer. 
	 */
	public void chargeFee(int fee)
	{
		customerFees += fee;
	}
	/**
	 * Pay's Off Customer Fee.
	 */
	public void payFee()
	{
		customerFees = 0;
	}
	/**
	 * Checks to see if customer has a fee on account.
	 * 
	 * @return True if customer has fee. False if customer has no fee.
	 */
	public boolean hasFee()
	{
		if(customerFees > 0)
			return true;
		else
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return		  customerCardID + ", " 
					+ customerLastName + ", "
					+ customerFirstName + ", "
					+ customerAddress + ", "
					+ customerEmailAddress + ","
					+ customerGender + ", "	
					+ customerPhoneNum + ", "
					+ customerFees;
	}
}
