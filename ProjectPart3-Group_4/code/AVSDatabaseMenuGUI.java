import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This is the AVSDatabase menu GUI.  It contains three buttons 
 * that are linked to customer, staff, and manager menus.
 * @author Harold Hansen, Group 4
 *
 */
public class AVSDatabaseMenuGUI 

{
	public void runGUI()
		{
		/**
		 * Instantiating a new frame and implementing basic methods
		 */
		final JFrame frame = new JFrame();
		//JFrame inceptionFrame = new JFrame();
		frame.setSize(700,175);
		frame.setLayout(new GridLayout(4,7));
		//inceptionFrame.setLayout(new FlowLayout());
		frame.setTitle("AVS Database Menu");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Initializes the JButtons.
		 * b1 - Customer button, pops up a new GUI for customer-oriented/staff-run,manager-run GUI
		 * b2 - Staff button, pops up a new GUI for staff-oriented/staff-run,manager-run GUI
		 * b3 - Manager button, pops up a new GUI for manager-oriented/manager-run GUI
		 */
		JButton b1 = new JButton("Customer Menu");
		JButton b2 = new JButton("Staff Menu");
		JButton b3 = new JButton("Manager Menu");
		JButton b4 = new JButton("Sign Out");
		/**
		 * Initializes the JLabels for the JButtons.
		 * b1Description - Customer label
		 * b2Description - Staff label
		 * b3Description - Manager label
		 */
		JLabel b1Description = new JLabel("Customer Menu");
		JLabel b2Description = new JLabel("Staff Menu");
		JLabel b3Description = new JLabel("Manager Menu");
		JLabel b4Description = new JLabel("Sign Out");
		
		/**
		 * Sets the text to display in all the JLabels
		 */
		b1Description.setText("Customer-oriented menu for interaction by staff only");
		b2Description.setText("Staff-oriented menu for staff and managers only");
		b3Description.setText("Manager-oriented menu for managers only");
		b4Description.setText("Go back to login screen");
		/**
		 * Sets the size of the buttons
		 * Only works with the flow layout
		 */
		b1.setSize(200,50);
		b2.setSize(200,50);
		b3.setSize(200,50);
		/**
		 * Adds the components to the frame
		 */
		frame.add(b1);
		frame.add(b1Description);
		frame.add(b2);
		frame.add(b2Description);
		frame.add(b3);
		frame.add(b3Description);
		frame.add(b4);
		frame.add(b4Description);
		
		/**
         * adds actions to the buttons in the frame
         */
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				CustomerMenuGUI cmGUI = new CustomerMenuGUI();
				cmGUI.runGUI();
				frame.dispose();
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				StaffMenuGUI smGUI = new StaffMenuGUI();
				smGUI.runGUI();
				frame.dispose();
			}
	});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				ManagerMenuGUI mmGUI = new ManagerMenuGUI();
				mmGUI.runGUI();
				frame.dispose();
			}
		});
		
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				LoginGUI lGUI = new LoginGUI();
				lGUI.runGUI();
				frame.dispose();
			}
		});
		
		
}
}

