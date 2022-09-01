package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PinChange extends JFrame {

	private JPanel contentPane;
	String pinnumber;
	private JPasswordField pinTextField;
	private JPasswordField repinTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PinChange(String pinnumber) {
		//pin//(302, 165, 186, 33
		//repin//302, 245, 186, 33
		this.pinnumber = pinnumber;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Change your PIN");
		text.setBounds(159, 53, 193, 34);
		text.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
		contentPane.add(text);
		
		JLabel pinText = new JLabel("New PIN:");
		pinText.setFont(new Font("Tahoma", Font.BOLD, 17));
		pinText.setBounds(58, 165, 90, 34);
		contentPane.add(pinText);
		
		JLabel repinText = new JLabel("Re-enter your new PIN:");
		repinText.setFont(new Font("Tahoma", Font.BOLD, 17));
		repinText.setBounds(58, 245, 211, 30);
		contentPane.add(repinText);
		
		JButton change = new JButton("CHANGE");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pinTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your new PIN");
					return;
				}
				else if(repinTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter your new PIN");
					return;
				}
				else if(!pinTextField.getText().equals(repinTextField.getText())) {
					JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
					return;
				}
				else {
					try {
						String newpin = pinTextField.getText();
						String repin = repinTextField.getText();
						String query1 = "update bank set pinnumber = '"+newpin+"' where pinnumber = '"+pinnumber+"'";
						String query2 = "update login set pinnumber = '"+newpin+"' where pinnumber = '"+pinnumber+"'";
						String query3 = "update signupthree set pinnumber = '"+newpin+"' where pinnumber = '"+pinnumber+"'";
						Conn c = new Conn();
						c.s.executeUpdate(query1);
						c.s.executeUpdate(query2);
						c.s.executeUpdate(query3);
						
						JOptionPane.showMessageDialog(null, "PIN changed successfully");
						setVisible(false);
						new Transaction(newpin).setVisible(true);
						
					}catch(Exception e6) {
						System.out.println(e6);
					}
				}
			}
		});
		change.setFont(new Font("Tahoma", Font.BOLD, 18));
		change.setForeground(Color.WHITE);
		change.setBackground(Color.BLACK);
		change.setBounds(288, 332, 117, 34);
		contentPane.add(change);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
		});
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setFont(new Font("Tahoma", Font.BOLD, 18));
		back.setBounds(129, 332, 117, 34);
		contentPane.add(back);
		
		pinTextField = new JPasswordField();
		pinTextField.setFont(new Font("Tahoma", Font.BOLD, 15));
		pinTextField.setColumns(50);
		pinTextField.setBackground(Color.WHITE);
		pinTextField.setBounds(302, 165, 186, 33);
		contentPane.add(pinTextField);
		
		repinTextField = new JPasswordField();
		repinTextField.setFont(new Font("Tahoma", Font.BOLD, 15));
		repinTextField.setColumns(50);
		repinTextField.setBounds(302, 245, 186, 33);
		contentPane.add(repinTextField);
	}
}
