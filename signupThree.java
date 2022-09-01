package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class signupThree extends JFrame {
	String formno;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupThree frame = new signupThree("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public signupThree(String formno) {
		this.formno = formno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 702);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Page 3 : Account Details");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setBounds(273, 25, 276, 32);
		contentPane.add(label1);
		
		JLabel type = new JLabel("Account type:");
		type.setFont(new Font("Tahoma", Font.BOLD, 18));
		type.setBounds(55, 120, 137, 32);
		contentPane.add(type);
		
		JRadioButton r1 = new JRadioButton("Saving Account");
		r1.setBackground(Color.WHITE);
		r1.setFont(new Font("Tahoma", Font.BOLD, 15));
		r1.setBounds(323, 108, 143, 21);
		contentPane.add(r1);
		
		JRadioButton r2 = new JRadioButton("Fixed Deposite Account");
		r2.setBackground(Color.WHITE);
		r2.setFont(new Font("Tahoma", Font.BOLD, 15));
		r2.setBounds(479, 108, 205, 21);
		contentPane.add(r2);
		
		JRadioButton r3 = new JRadioButton("Current Account");
		r3.setBackground(Color.WHITE);
		r3.setFont(new Font("Tahoma", Font.BOLD, 15));
		r3.setBounds(323, 149, 154, 21);
		contentPane.add(r3);
		
		JRadioButton r4 = new JRadioButton("Recurring Deposite Account");
		r4.setBackground(Color.WHITE);
		r4.setFont(new Font("Tahoma", Font.BOLD, 15));
		r4.setBounds(479, 149, 241, 21);
		contentPane.add(r4);
		
		ButtonGroup ac = new ButtonGroup();
		ac.add(r1);
		ac.add(r2);
		ac.add(r3);
		ac.add(r4);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Tahoma", Font.BOLD, 18));
		card.setBounds(55, 244, 137, 21);
		contentPane.add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4138");
		number.setFont(new Font("Tahoma", Font.BOLD, 18));
		number.setBounds(323, 254, 226, 21);
		contentPane.add(number);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Tahoma", Font.BOLD, 18));
		pin.setBounds(55, 323, 57, 21);
		contentPane.add(pin);
		
		JLabel pinNumber = new JLabel("XXXX");
		pinNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		pinNumber.setBounds(326, 336, 57, 20);
		contentPane.add(pinNumber);
		
		JLabel cardDetails = new JLabel("Your 16 digits card number");
		cardDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardDetails.setBounds(55, 277, 174, 13);
		contentPane.add(cardDetails);
		
		JLabel pinDetails = new JLabel("Your 4 digits pin number");
		pinDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		pinDetails.setBounds(55, 354, 163, 13);
		contentPane.add(pinDetails);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login1().setVisible(true);
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cancel.setBounds(210, 494, 120, 46);
		contentPane.add(cancel);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acType = null;
				if(r1.isSelected()) {
					acType = "Saving Account";
				}
				else if(r2.isSelected()) {
					acType = "Fixed Deposite Account";
				}
				else if(r3.isSelected()) {
					acType = "Current Account";
				}
				else if(r4.isSelected()) {
					acType = "Recurring Deposite Account";
				}
				
				Random random = new Random();
				String cardnumber = ""+ Math.abs((random.nextLong() % 90000000L)+ 5430289000000000L);
				String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
				
				try {
					if(acType.equals("")) {
						JOptionPane.showMessageDialog(null,"Account type is required");
					}
					else {
					Conn c = new Conn();
					String query1 = "insert into signupthree values('"+formno+"','"+acType+"','"+cardnumber+"','"+pinnumber+"')";
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber + "\n PIN Number: "+pinnumber);
					
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					}
				}catch(Exception ae) {
					System.out.println(ae);
				}
				
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.BLACK);
		submit.setFont(new Font("Tahoma", Font.BOLD, 18));
		submit.setBounds(449, 494, 126, 45);
		contentPane.add(submit);
	}
}
