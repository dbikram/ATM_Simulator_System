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
import java.sql.*;

public class Deposite extends JFrame {

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
					Deposite frame = new Deposite("");
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
	public Deposite(String pinnumber) {
		this.pinnumber = pinnumber;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Please enter the amount you want to deposite");
		text.setFont(new Font("Verdana", Font.BOLD, 20));
		text.setBounds(50, 54, 528, 32);
		contentPane.add(text);
		
		amountTextField = new JTextField();
		amountTextField.setBackground(Color.WHITE);
		amountTextField.setFont(new Font("Tahoma", Font.BOLD, 17));
		amountTextField.setBounds(160, 143, 311, 46);
		contentPane.add(amountTextField);
		amountTextField.setColumns(25);
		
		JButton depositeButton = new JButton("DEPOSITE");
		depositeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = amountTextField.getText();
				Date date = new Date();
				if(amount.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter some amount you want to deposite");
				}
				else {
					try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+amount+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+amount+" deposited successfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					} catch (Exception e2) {
						
						System.out.println(e2);
					}
				}
			}
		});
		depositeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		depositeButton.setForeground(Color.WHITE);
		depositeButton.setBackground(Color.BLACK);
		depositeButton.setBounds(251, 242, 126, 40);
		contentPane.add(depositeButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
		});
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.BLACK);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		backButton.setBounds(251, 313, 126, 40);
		contentPane.add(backButton);
	}
}
