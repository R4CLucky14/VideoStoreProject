import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* * 
 * @group 4
 * 
 *This class creates a small staff menu in order to check out videos and sign customers up for 
 *a membership to rent videos.
 */


public class StaffMenuGUI
{
public void runGUI()
{
	/**
	 * Creates the frame and pane, and specifies the layout
	 */
		final JFrame frame = new JFrame();
		frame.setSize(550,125);
		Container pane= frame.getContentPane();
		pane.setLayout(new GridLayout(3,2));
		frame.setTitle("Staff Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		/**
		 * creates labels for each category of information
		 */
		JLabel label1 = new JLabel("Add new videos to the database");
		JLabel label2 = new JLabel("Sign up a new customer");
		JLabel label3 = new JLabel("Go back to the menu");
	
		
		/**
		 * creates button to complete registration
		 */
		JButton button1 = new JButton("Register Customer");
		JButton button2 = new JButton("Register Video");
		JButton button3 = new JButton("Cancel");
		
		/**
         * adds actions to the buttons in the frame
         */
		
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				CustomerRegisterGUI crGUI = new CustomerRegisterGUI();
				crGUI.runGUI();
				frame.dispose();
			}
		
		});
		
		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				RegisterVideoGUI rvGUI = new RegisterVideoGUI();
				rvGUI.runGUI();
				frame.dispose();
			}
		});
		
		   button3.addActionListener(new ActionListener()
           {
           	public void actionPerformed(ActionEvent event)
           	{
           		AVSDatabaseMenuGUI menu = new AVSDatabaseMenuGUI();
           		menu.runGUI();
           		frame.dispose();
           	}
           });
		
		/**
		 * adds all components to the pane 
		 */
		pane.add(button2);
		pane.add(label1);
		pane.add(button1);
		pane.add(label2);
		pane.add(button3);
		pane.add(label3);
		
		

}
}
