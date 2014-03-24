
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


/**
 * 
 * @author Matt McClain and John Stricklin
 * This main class creates the Graphic interface for the Customer Menu
 *
 */
public class CustomerMenuGUI
{


	public void runGUI()
	{
		final JFrame frame = new JFrame();//creates frame
		frame.setSize(350,150);//sets size of frame
		Container pane= frame.getContentPane();//adds pane to insert components
        pane.setLayout(new GridLayout(2,2));
        frame.setTitle("Customer Menu");//adds title to frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes program on exit;
		

				/**
                 * creates buttons to fill add video to database
                 **/
				JButton button1 = new JButton("Rent/Return");
                JButton button2 = new JButton("Cancel");
                JLabel blank1 = new JLabel("Rent/Return Menu");
                JLabel blank2 = new JLabel("Go back");
		
                /**
                 * adds components to the frame
                 */
                pane.add(button1);
                pane.add(blank1);
                pane.add(button2);
                pane.add(blank2);

                frame.setVisible(true);//sets frame visible to users
                
                /**
                 * adds actions to the buttons in the frame
                 */
                
                button1.addActionListener(new ActionListener()
                {
                	public void actionPerformed(ActionEvent event)
                	{
                		RentVideoGUI rvGUI = new RentVideoGUI();
                		rvGUI.runGUI();
                		frame.dispose();
                	}
                });
                
                button2.addActionListener(new ActionListener()
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
