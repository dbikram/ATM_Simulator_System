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
import java.util.Date;
import java.awt.event.ActionEvent;

public class withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField amountTextField;
	String pinnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw("");
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
	public withdraw(String pinnumber) {
		this.pinnumber = pinnumber;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textLabel = new JLabel("Please enter the amount you want to withdraw");
		textLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		textLabel.setBounds(76, 49, 442, 37);
		contentPane.add(textLabel);
		
		amountTextField = new JTextField();
		amountTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		amountTextField.setBounds(135, 151, 297, 46);
		contentPane.add(amountTextField);
		amountTextField.setColumns(50);
		
		JButton withdrawButton = new JButton("WITHDRAW");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				String amount = amountTextField.getText();
				if(amount.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some amount to withdraw");
				}
				else {
					try {
				Conn c = new Conn();
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawn successfully");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
				}
				
				catch(Exception e3) {
					System.out.println(e3);
				}
				}
			
			}
			
		});
		withdrawButton.setForeground(Color.WHITE);
		withdrawButton.setBackground(Color.BLACK);
		withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		withdrawButton.setBounds(202, 262, 156, 37);
		contentPane.add(withdrawButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setBounds(202, 349, 156, 37);
		contentPane.add(backButton);
	}

}
