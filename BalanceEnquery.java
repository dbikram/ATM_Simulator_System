package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BalanceEnquery extends JFrame {

	private JPanel contentPane;
	
	private String pinnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceEnquery frame = new BalanceEnquery("");
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
	public BalanceEnquery(String pinnumber) {
		this.pinnumber = pinnumber;
		setUndecorated(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 371);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int balance = 0;
		Conn c = new Conn();
		try {
			
			String query1 = "select * from bank where pinnumber = '"+pinnumber+"'";
			ResultSet rs = c.s.executeQuery(query1);
			while(rs.next()) {
				if(rs.getString("transactiontype").equals("Deposite")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e7) {
			System.out.println(e7);
		}
		
		
		JLabel text = new JLabel("Your current account balance is Rs. "+balance);
		text.setFont(new Font("Tahoma", Font.BOLD, 17));
		text.setBounds(87, 59, 363, 34);
		contentPane.add(text);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 17));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(324, 249, 85, 29);
		contentPane.add(back);
	}
}
