import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * Class prints out list of overdue videos and customer phone numbers and names
 * 
 * @author Matt McClain
 * @version
 */

public class OverDueListGUI
{
public void runGUI()
{
	/**
	 * Instantiates a new JFrame and performs basic methods on the JFrame.
	 */
	final JFrame frame = new JFrame();
	frame.setSize(300,300);
	frame.setLayout(new BorderLayout());
	frame.setTitle("Overdue List");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	/**
	 * Instantiates a new JButton
	 */
	JButton button1 = new JButton("Go Back");
	/**
	 * Instantiates a new JPanel and adds the JButton to it 
	 */
	JPanel panel = new JPanel(new BorderLayout());
	panel.add(button1,BorderLayout.SOUTH);
	/**
	 * Instantiates a JTextArea
	 */
	
	final JTextArea area1 = new JTextArea();
	/**
	 * Instantiates a new JScrollPane
	 */

	final JScrollPane scroll1 = new JScrollPane(area1);
	/**
	 * Adds the JScrollPane to the JPanel
	 */
	
	panel.add(scroll1,BorderLayout.CENTER);
	/**
	 * Add panel to JFrame
	 */
	frame.add(panel);
	/**
	 * Checks to to see if the user is a manager
	 */
	if(LoginGUI.user.isManager())
	{
		/**
		 * Adds users to the overdue list and prints to the list to the JTextArea
		 */
		ArrayList<Video> list = AVSVideoDatabase.getOverdueList(LoginGUI.user);
		String output ="";
		for( int i = 0 ; i < list.size() ; i++)
		{
			output += list.get(i).toString() + "\n";
		}
		area1.setText(output);
	}
	
	/**
	 * Adds a new ActionListener to the JButton
	 */
	button1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
               		ManagerMenuGUI menu = new ManagerMenuGUI();
               		menu.runGUI();
               		frame.dispose();
      	}
               });

}


}
