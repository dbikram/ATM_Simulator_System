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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FastCash extends JFrame {

	private JPanel contentPane;
	String pinnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FastCash frame = new FastCash("");
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
	public FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		setUndecorated(true); //for removing the above bar of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 508);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Please select your withdrawl");
		text.setFont(new Font("Tahoma", Font.BOLD, 17));
		text.setBounds(180, 68, 264, 27);
		contentPane.add(text);
		
		JButton deposite = new JButton("Rs 100");
		deposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					int balance = 0;
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
					if(balance < 100) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','100')";
					try {
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Rs 100 debitad successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}catch(Exception e5) {
						System.out.println(e5);
					}
					
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
			}
		});
		deposite.setForeground(Color.WHITE);
		deposite.setBackground(Color.DARK_GRAY);
		deposite.setFont(new Font("Tahoma", Font.BOLD, 16));
		deposite.setBounds(106, 185, 175, 35);
		contentPane.add(deposite);
		
		JButton withdrawl = new JButton("Rs 200");
		withdrawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					int balance = 0;
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
					if(balance < 200) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','200')";
					try {
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Rs 200 debitad successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}catch(Exception e5) {
						System.out.println(e5);
					}
					
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
			}
		});
		withdrawl.setForeground(Color.WHITE);
		withdrawl.setBackground(Color.DARK_GRAY);
		withdrawl.setFont(new Font("Tahoma", Font.BOLD, 16));
		withdrawl.setBounds(352, 185, 175, 35);
		contentPane.add(withdrawl);
		
		JButton fastcash = new JButton("Rs 500");
		fastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					int balance = 0;
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
					if(balance < 500) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','500')";
					try {
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Rs 500 debitad successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}catch(Exception e5) {
						System.out.println(e5);
					}
					
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
			}
		});
		fastcash.setForeground(Color.WHITE);
		fastcash.setBackground(Color.DARK_GRAY);
		fastcash.setFont(new Font("Tahoma", Font.BOLD, 16));
		fastcash.setBounds(106, 248, 175, 37);
		contentPane.add(fastcash);
		
		JButton ministatement = new JButton("Rs 1000");
		ministatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					int balance = 0;
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
					if(balance < 1000) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','1000')";
					try {
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Rs 1000 debitad successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}catch(Exception e5) {
						System.out.println(e5);
					}
					
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
			}
		});
		ministatement.setForeground(Color.WHITE);
		ministatement.setBackground(Color.DARK_GRAY);
		ministatement.setFont(new Font("Tahoma", Font.BOLD, 16));
		ministatement.setBounds(352, 250, 175, 35);
		contentPane.add(ministatement);
		
		JButton pinchange = new JButton("Rs 2000");
		pinchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					int balance = 0;
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
					if(balance < 2000) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','2000')";
					try {
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Rs 2000 debitad successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}catch(Exception e5) {
						System.out.println(e5);
					}
					
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
			}
		});
		pinchange.setForeground(Color.WHITE);
		pinchange.setBackground(Color.DARK_GRAY);
		pinchange.setFont(new Font("Tahoma", Font.BOLD, 16));
		pinchange.setBounds(106, 324, 175, 35);
		contentPane.add(pinchange);
		
		JButton balanceenquery = new JButton("Rs 5000");
		balanceenquery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					int balance = 0;
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
					if(balance < 5000) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query2 = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','5000')";
					try {
						c.s.executeUpdate(query2);
						JOptionPane.showMessageDialog(null, "Rs 5000 debitad successfully");
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}catch(Exception e5) {
						System.out.println(e5);
					}
					
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
			}
		});
		balanceenquery.setForeground(Color.WHITE);
		balanceenquery.setBackground(Color.DARK_GRAY);
		balanceenquery.setFont(new Font("Tahoma", Font.BOLD, 16));
		balanceenquery.setBounds(352, 324, 175, 35);
		contentPane.add(balanceenquery);
		
		JButton exit = new JButton("BACK");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
		});
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.DARK_GRAY);
		exit.setFont(new Font("Tahoma", Font.BOLD, 17));
		exit.setBounds(392, 402, 135, 47);
		contentPane.add(exit);
	}
}
