package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField cardTextField;
	private JPasswordField pinTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 504);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Stencil", Font.BOLD, 21));
		text.setBounds(188, 36, 230, 44);
		contentPane.add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Tahoma", Font.BOLD, 16));
		cardno.setBounds(73, 122, 74, 25);
		contentPane.add(cardno);
		
		cardTextField = new JTextField(); //216, 120, 263, 33
		cardTextField.setForeground(Color.BLACK);
		cardTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		cardTextField.setBounds(216, 120, 263, 33);
		contentPane.add(cardTextField);
		cardTextField.setColumns(255);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Tahoma", Font.BOLD, 16));
		pin.setBounds(73, 197, 74, 20);
		contentPane.add(pin);
		
		JButton clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cardTextField.setText("Biku"); //setText is a method which is used to set text in text field. 
				cardTextField.setText(""); //after clear button is pressed, cardTextField becomes empty
				pinTextField.setText(""); ////after clear button is pressed, pinTextField becomes empty
			}
		});
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clear.setBounds(302, 283, 102, 33);
		contentPane.add(clear);
		
		JButton login = new JButton("SIGN IN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardnumber = cardTextField.getText();
				String pinnumber = pinTextField.getText();
				
				try {
					Conn c = new Conn();
					String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
					ResultSet rs = c.s.executeQuery(query); //select query is DML command
					if(rs.next()) //if rs has value
					{
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}
					else { //if rs has no value
						JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.setBounds(188, 283, 102, 33);
		contentPane.add(login);
		
		JButton signup = new JButton("SIGN UP");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new signupOne().setVisible(true);
			}
		});
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.setBounds(185, 326, 219, 33);
		contentPane.add(signup);
		
		pinTextField = new JPasswordField(); 
		pinTextField.setColumns(255);
		pinTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		pinTextField.setBounds(216, 193, 263, 33);
		contentPane.add(pinTextField);
	}
}
