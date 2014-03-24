import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RentVideoGUI
{
		public void runGUI()
		{
			/**
			 * Instantiating a new frame and implementing basic methods
			 */
			
			final JFrame frame = new JFrame();
			frame.setSize(450,250);
			frame.setLayout(new GridLayout(7,3));
			frame.setTitle("Rent/Return Video Menu");
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			/**
			 * creates buttons and other components to add to the frame
			 */
			
			JButton button1 = new JButton("Rent Video");
			JButton button2 = new JButton("Return Video");
			JButton button3 = new JButton("Go Back");
			JButton button4 = new JButton("Pay Fee");
			
			final JCheckBox box = new JCheckBox("Damaged");

			final JTextField text1 = new JTextField();
			final JTextField text2 = new JTextField();
			JLabel label1 = new JLabel("VideoID");
			JLabel label2 = new JLabel("Customer ID");
			JLabel label3 = new JLabel("");
			JPanel buttonPane = new JPanel();
			buttonPane.add(button1);
			buttonPane.add(button2);
			buttonPane.add(button3);
			buttonPane.add(button4);
			
			/**
			 * adds components to the frame
			 */
			frame.add(label2);
			frame.add(text1);
			frame.add(label1);
			frame.add(text2);
			frame.add(box);
			frame.add(label3);
			frame.add(buttonPane);

			
			
			/**
	         * adds actions to the buttons in the frame
	         */
			

			button1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					try{
					if(AVSVideoDatabase.canCheckoutVideo(text2.getText(), text1.getText()))
						AVSVideoDatabase.checkoutVideo(text2.getText(), text1.getText());
						AVSVideoDatabase.saveDB();
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
				{	try{	
					boolean flag;
					if(box.isSelected())
					flag = true;
					
					else
					flag = false;
					
					AVSVideoDatabase.checkinVideo(text2.getText(), text1.getText(), flag);
					AVSVideoDatabase.saveDB();
					AVSCustomerDatabase.saveDB();
					}
					catch (IOException e)
		   			{
						e.printStackTrace();
			   			}
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
		
		
		button4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
			try
			{
				AVSCustomerDatabase.payFee(text1.getText());
				AVSCustomerDatabase.saveDB();
			}
				catch (IOException e)
	   			{
					e.printStackTrace();
		   		}
			
			}
			});
		}

		}



