import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * @author Matt McClain
 * This class creates the interface to add a video to the database
 *
 */
public class RegisterVideoGUI
{


	public void runGUI()
	{
		/**
		 * Creates the frame and adds pane to add components
		 * also sets the size and the layout of the frame.
		 */
		final JFrame frame = new JFrame();//creates frame
		JPanel panel = new JPanel();
		frame.setSize(300,170);//sets size of frame
		frame.setLayout(new FlowLayout());//sets layout of components
		frame.setTitle("AVS Database");//adds title to frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes program on exit;
		
		/**
		 * creates contents for a drop box to select category
		 * Says error at array line but it works perfectly
		 */
		String[] myArray = {"<Select Category>","Action","Comedy","Drama","Horror","Sci-Fi"};
		final JComboBox box = new JComboBox(myArray);//says that there is an error at this line of code but it runs perfectly
		
		/**
		 * creates labels for GUI also uses blank ones for formatting purposes
		 */
		JLabel lable1 =new JLabel("Add a new video to the database");
		JLabel lable2 = new JLabel("Enter Video Title");		
		/**
		 * creates buttons to fill add video to database
		 */
		JButton button1 = new JButton("Add to Database");
		JButton button2 = new JButton("Cancel");
		panel.add(button1);
		panel.add(button2);
		
		/**
		 * creates text field to fill out video information
		 */
		final JTextField field1 = new JTextField(15);
		
		
		/**
		 * adds components to the frame 
		 */
		frame.add(lable1);
		frame.add(lable2);
		frame.add(field1);
	    frame.add(box);
	    frame.add(panel);
	    
	    frame.setVisible(true);//sets frame visible to users
	    
	    /**
         * adds a video to the database
         */
	button1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
			try {
			AVSVideoDatabase.addNewVideo(field1.getText(),(String) box.getSelectedItem());
       		field1.setText("");
       		AVSVideoDatabase.saveDB();
			}
       		
				
			 catch (IOException e)
			 {
				
				e.printStackTrace();
			}
		}
	});
	
	 /**
     * goes to the staff menu
     */
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
