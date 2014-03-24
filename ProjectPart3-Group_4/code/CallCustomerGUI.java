/**
 * This GUI is called from within the OverdueListGUI.  It calls one customer at a time.
 * 
 * Has list of all overdue video's customer's phone numbers
 * @author Harold Hansen
 * @version 4/17/13
 *
 */

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CallCustomerGUI 
{
	public void runGUI()
	{
		/**
		 * This instantiates all JFrames, JButtons, JLabels, and JPanels.
		 * Sets the layout for the JPanel to FlowLayout.
		 */
		JPanel phoneButtons = new JPanel();
		phoneButtons.setLayout(new FlowLayout());
		JButton b1 = new JButton("Call");
		final JButton b2 = new JButton("Go Back");
		final JFrame phone = new JFrame();
		phone.setTitle("Call Customer");
		final JFrame calling = new JFrame();
		final JLabel callingCustomer = new JLabel();
		JLabel whoCalls = new JLabel();
		/**
		 * Sets the text for the JLabel
		 */
		whoCalls.setText("Enter phone #:");
		/**
		 * Sets the visibility for the JFrame and JPanel to true.
		 */
		phone.setVisible(true);
		phoneButtons.setVisible(true);
		/**
		 * Sets the size of the JFrame.
		 * Ensures the JFrame will fully close when closed.
		 */
		phone.setSize(300,125);
		phone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Sets the JFrame's layout to GridLayout with 3 rows and 4 columns.
		 * Instantiates a final JTextField.
		 */
		phone.setLayout(new GridLayout(3,4));
		final JTextField phoneNumberField = new JTextField();
		/**
		 * Adds a new ActionListener to the JButton.
		 */
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/**				 
				 * 
				 * Sets the visiblity of the frame to true.
				 * Sets the layout of the JFrame to FlowLayout.
				 */
				calling.setVisible(true);
				calling.setLayout(new FlowLayout());
				calling.setSize(100,100);
				callingCustomer.setText("Calling..." + phoneNumberField.getText());
				calling.add(callingCustomer);
				calling.add(b2);
				calling.pack();
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
	               		ManagerMenuGUI menu = new ManagerMenuGUI();
	               		menu.runGUI();
	               		phone.dispose();
	      	}
	               });
		
		/**
		 * Add button to JPanel
		 */
		phoneButtons.add(b1);
		/**
		 * Adds components to JFrame
		 */
		phone.add(whoCalls);
		phone.add(phoneNumberField);
		phone.add(phoneButtons);
	}
}
