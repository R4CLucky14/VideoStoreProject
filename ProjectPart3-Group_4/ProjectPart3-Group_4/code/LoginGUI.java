import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login GUI for the staff and managers
 * @author Harold Hansen and Matt McClain, Group 4
 *
 */
public class LoginGUI 
{
	public static Staff user;

	public void runGUI()
	{
		/**
		 * Instantiating a new frame and implementing basic methods
		 */
		final JFrame frame = new JFrame();
		frame.setSize(275,340);
		frame.setLayout(new FlowLayout());
		frame.setTitle("Login");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imageIcon = new ImageIcon("AVS.gif");
		
		/**
		 * Instantiates the JButton, JTextFields, and JLabels
		 */
		
		JButton loginButton = new JButton("Login");
		final JTextField userName = new JTextField(20);
		final JPasswordField password = new JPasswordField(20);
		JLabel name = new JLabel("User Name:  ");
		JLabel security = new JLabel("Password:  ");
		JLabel label2 = new JLabel("A Video Database");
		JLabel label = new JLabel(imageIcon);

		/**
		 * adds the components to the frame
		 */
		frame.add(name);
		frame.add(userName);
		frame.add(security);
		frame.add(password);
		frame.add(loginButton);
		frame.add(label);
		frame.add(label2);

		loginButton.addActionListener(new ActionListener()
		{
	
	public void actionPerformed(ActionEvent event)
	{
   		try {
   			if(userName.getSelectionStart()>0)
   			{
			user = AVSStaffDatabase.login(userName.getText(),password.getText());
			if(user !=null)
			{	
				AVSDatabaseMenuGUI menu = new AVSDatabaseMenuGUI();
		   		menu.runGUI();
		   		frame.dispose();
			}
			
			else
			{
				userName.setText("");
				password.setText("");
			}
   			}
   			
   			}
   		
   			
		
   			catch (FileNotFoundException e)
   			{
			e.printStackTrace();
   			}
   		
   		
	}
	});

}
}
