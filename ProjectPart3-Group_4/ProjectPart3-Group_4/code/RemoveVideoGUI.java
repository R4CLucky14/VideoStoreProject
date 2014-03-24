import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * This is the GUI for removing a video from the AVSDatabase.
 * @author Harold Hansen, Group 4
 *
 */
public class RemoveVideoGUI 
{
	public void runGUI()
	{
		/**
		 * Instantiating a new frame and implementing basic methods
		 */
		final JFrame frame = new JFrame();
		frame.setSize(200,300);
		frame.setLayout(new GridLayout(10,3));
		frame.setTitle("Remove Video");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * creates the 
		 */
		JButton remove = new JButton("Remove");
		final JTextField text = new JTextField();
		JLabel textLabel = new JLabel();
		JButton button2 = new JButton("Go Back");
		/**
		 * 
		 */
		textLabel.setText("Video ID:  ");
		/**
		 * 
		 */
		frame.add(textLabel);
		frame.add(text);
		frame.add(remove);
		frame.add(button2);
		
		
		/**
         * adds actions to the buttons in the frame
         */
	
	button2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
               		ManagerMenuGUI menu = new ManagerMenuGUI();
               		menu.runGUI();
               		frame.dispose();
      	}
               });
	
	remove.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
			AVSVideoDatabase.removeVideo(text.getText());
			AVSVideoDatabase.saveDB();
			text.setText("");
			}
			
			
			 catch (IOException e)
			 {
				
				e.printStackTrace();
			}
		}
		
	});
}
}
