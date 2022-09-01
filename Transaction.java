package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transaction extends JFrame {

	private JPanel contentPane;
	String pinnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction("");
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
	public Transaction(String pinnumber) {
		this.pinnumber = pinnumber;
		setUndecorated(true); //for removing the above bar of frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 508);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Please select your transaction");
		text.setFont(new Font("Tahoma", Font.BOLD, 18));
		text.setBounds(170, 67, 288, 35);
		contentPane.add(text);
		
		JButton deposite = new JButton("DEPOSITE");
		deposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Deposite(pinnumber).setVisible(true);
			}
		});
		deposite.setForeground(Color.WHITE);
		deposite.setBackground(Color.BLACK);
		deposite.setFont(new Font("Tahoma", Font.BOLD, 16));
		deposite.setBounds(106, 185, 190, 35);
		contentPane.add(deposite);
		
		JButton withdrawl = new JButton("CASH WITHDRAW");
		withdrawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new withdraw(pinnumber).setVisible(true);
			}
		});
		withdrawl.setForeground(Color.WHITE);
		withdrawl.setBackground(Color.BLACK);
		withdrawl.setFont(new Font("Tahoma", Font.BOLD, 16));
		withdrawl.setBounds(352, 185, 200, 35);
		contentPane.add(withdrawl);
		
		JButton fastcash = new JButton("FAST CASH");
		fastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FastCash(pinnumber).setVisible(true);
			}
		});
		fastcash.setForeground(Color.WHITE);
		fastcash.setBackground(Color.BLACK);
		fastcash.setFont(new Font("Tahoma", Font.BOLD, 16));
		fastcash.setBounds(106, 248, 190, 37);
		contentPane.add(fastcash);
		
		JButton pinchange = new JButton("PIN CHANGE");
		pinchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PinChange(pinnumber).setVisible(true);
			}
		});
		pinchange.setForeground(Color.WHITE);
		pinchange.setBackground(Color.BLACK);
		pinchange.setFont(new Font("Tahoma", Font.BOLD, 16));
		pinchange.setBounds(352, 249, 200, 35);
		contentPane.add(pinchange);
		
		JButton balanceenquery = new JButton("BALANCE   ENQUERY");
		balanceenquery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BalanceEnquery(pinnumber).setVisible(true);
			}
		});
		balanceenquery.setForeground(Color.WHITE);
		balanceenquery.setBackground(Color.BLACK);
		balanceenquery.setFont(new Font("Tahoma", Font.BOLD, 18));
		balanceenquery.setBounds(106, 316, 446, 35);
		contentPane.add(balanceenquery);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.BLACK);
		exit.setFont(new Font("Tahoma", Font.BOLD, 17));
		exit.setBounds(272, 394, 106, 45);
		contentPane.add(exit);
	}
}
