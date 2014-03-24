import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


/**
 * This class creates the user interface to register a new customer
 * 
 * @author Matt McClain
 * 
 * @Group4
 *
 */

public class CustomerRegisterGUI
{
	public void runGUI()
	{
		
	/**
	 * Creates the frame and pane, and sets the format for the frame
	*/
	final JFrame frame = new JFrame();//creates frame
	frame.setSize(550,250);//sets size of frame
	Container pane= frame.getContentPane();//adds pane to insert components
	pane.setLayout(new GridLayout(7,2));//sets layout of components
	frame.setTitle("Customer Registration");//adds title to frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes program on exit
	frame.setVisible(true);
	
	/**
	 * creates labels for each category of information
	 */
	JLabel label1 = new JLabel("First Name:");
	JLabel label2 = new JLabel("Last Name:");
	JLabel label3 = new JLabel("Address:");
	JLabel label4 = new JLabel("Email:");
	JLabel label5 = new JLabel("Phone Number:");
	
	/**
	 * creates text field to fill out for registration
	 */
	final JTextField field1 = new JTextField();
	final JTextField field2 = new JTextField();
	final JTextField field3 = new JTextField();
	final JTextField field4 = new JTextField();
	final JTextField field5 = new JTextField();
	
	/**
	 * creates "radio" buttons to select sex of customer
	 */
	final JRadioButton r1 = new JRadioButton("Male");
	final JRadioButton r2 = new JRadioButton("Female");
	ButtonGroup group = new ButtonGroup();//groups buttons together so you can only select one
	group.add(r1);
	group.add(r2);
	
	/**
	 * creates button to complete registration
	 */
	JButton button1 = new JButton("Register");
	JButton button2 = new JButton("Go Back");
	
	/**
	 * adds all components to the pane 
	 */
	pane.add(r1);
	pane.add(r2);
	pane.add(label1);
	pane.add(field1);
	pane.add(label2);
	pane.add(field2);
	pane.add(label3);
	pane.add(field3);
	pane.add(label4);
	pane.add(field4);
	pane.add(label5);
	pane.add(field5);
	
	pane.add(button1);
	pane.add(button2);
	
	
	   button1.addActionListener(new ActionListener()
       {
       	public void actionPerformed(ActionEvent event)
       	{
       		try
       		{
       		char gender;
       		
       		if(r1.isSelected())
       		{
       			gender = 'm';
       		}
       		else
       		{
       		gender = 'f';
       		}
       		
       		AVSCustomerDatabase.addNewCustomer(field1.getText(),field2.getText(),field3.getText(),field4.getText(),gender,field5.getText(),0);
       		
       		field1.setText("");
       		field2.setText("");
       		field3.setText("");
       		field4.setText("");
       		field5.setText("");
       		
       		AVSCustomerDatabase.saveDB();
       		}
       		catch (IOException e)
   			{
			e.printStackTrace();
   			}
       	}
       });
	
	   button2.addActionListener(new ActionListener()
       {
       	public void actionPerformed(ActionEvent event)
       	{
       		StaffMenuGUI menu = new StaffMenuGUI();
       		menu.runGUI();
       		frame.dispose();
       	}
       });
	
	
	}
	
}
