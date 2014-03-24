import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This is the manager menu GUI.
 * @author Harold Hansen, Group 4
 *
 */
public class ManagerMenuGUI 
{
	public void runGUI()
	{
		/**
		 * Instantiating a new frame and implementing basic methods
		 */
		final JFrame frame = new JFrame();
		frame.setSize(700,150);
		frame.setLayout(new GridLayout(4,7));
		//frame.setLayout(new FlowLayout());
		frame.setTitle("Manager Menu");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack(); //makes it acts weird
		/**
		 * JButton removeVideo will remove the video from the AVSDatabase
		 * based on the videoID.
		 * JButton overdueList will print out the titles and names of videos
		 * and the names of the customers associated with the videos.
		 * JButton callCustomer will print the customers' phone numbers.
		 */
		
		JButton removeVideo = new JButton("Remove video");
		JButton overdueList = new JButton("Overdue list");
		JButton callCustomer = new JButton("Call customer");
		JButton back = new JButton("cancel");
		
		/**
		 * Creating the JButton descriptions by creating JLabels
		 */
		
		JLabel removeVideoDescription = new JLabel();
		JLabel overdueListDescription = new JLabel();
		JLabel callCustomerDescription = new JLabel();
		JLabel backDescription = new JLabel();

		/**
		 * Sets the text for the JLabels
		 */
		
		removeVideoDescription.setText("Removes the video from AVSDatabase");
		overdueListDescription.setText("Prints titles/IDs of videos and names of customers");
		callCustomerDescription.setText("Call customer to return video");
		backDescription.setText("Go back to the previous menu");
		
		removeVideo.setSize(200,50);
		overdueList.setSize(200,50);
		callCustomer.setSize(200,50);
		
		
		/**
		 * Add the buttons and labels to the JFrame
		 */
		frame.add(removeVideo);
		frame.add(removeVideoDescription);
		frame.add(overdueList);
		frame.add(overdueListDescription);
		frame.add(callCustomer);
		frame.add(callCustomerDescription);
		frame.add(back);
		frame.add(backDescription);
		
		/**
         * Pulls up the menu to remove a video from the database
         */
		removeVideo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				RemoveVideoGUI rvGUI = new RemoveVideoGUI();
				rvGUI.runGUI();
				frame.dispose();
			}
		});
		

		/**
         * pulls up the menu to call a customer
         */
		callCustomer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				 CallCustomerGUI c = new  CallCustomerGUI();
				 c.runGUI();
			}
		});
		

		/**
         * pulls up the overdue list
         */
		overdueList.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				OverDueListGUI list = new OverDueListGUI();
				list.runGUI();
			}
		});
		
		/**
         * goes to the main menu
         */
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
           		AVSDatabaseMenuGUI menu = new AVSDatabaseMenuGUI();
           		menu.runGUI();
           		frame.dispose();
			}
		});
		
		
	}
	
}