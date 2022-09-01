package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener{
	
	JButton signup,clear,login; //three buttons declared globally
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		//Frame setting
		setTitle("AUTOMATED TELLER MACHINE"); //set the title of frame
		setSize(1000,800); //set frame's size length=800 breadth=480
		setVisible(true); //Frame visible hoga
		setLocation(200,100); //starting frame from 350 from left side and 200 from up side
		
		//getContentPane() method is used for taking full frame
		//setBackground() method is used for setting the background color of frame
		// Color is a class
		getContentPane().setBackground(Color.WHITE);
		
		
		//JLabel class is used for writing anything in frame
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD , 38)); //text.setFont(new Font(font name,font type,size));
		text.setBounds(250,40,400,40); //left se 250,upar se 15,length 400 & width 200
		add(text); //we need to add JLabel object by add() method
		
		
		JLabel cardno = new JLabel("CARD NO:");
		cardno.setFont(new Font("Raleway",Font.BOLD , 28)); 
		cardno.setBounds(120,150,400,40); 
		add(cardno); 
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD , 28)); 
		pin.setBounds(120,250,400,40); 
		add(pin); 
		
		
		//JTextField is used for editing of a single line text
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,400,40);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,250,400,40);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		
		//JButton is used for button
		login = new JButton("SIGN IN");
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.setBounds(300,300,100,30);
		login.addActionListener(this); //adding actionListener to login button
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.setBounds(430,300,100,30);
		clear.addActionListener(this); //adding actionListener to clear button
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.setBounds(300,350,230,30);
		signup.addActionListener(this); //adding actionListener to signup button
		add(signup);
		
		
		
	}
	
	//override actionPerformed(ActionEvent ae) method from ActionListener interface
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			// cardTextField.setText("Biku"); //setText is a method which is used to set text in text field. 
			cardTextField.setText(""); //after clear button is pressed, cardTextField becomes empty
			pinTextField.setText(""); ////after clear button is pressed, pinTextField becomes empty
			
		}
		else if(ae.getSource() == login) {
			
		}
		else if(ae.getSource() == signup) {
			
		}
		
	}

	public static void main(String[] args) {
		new Login(); //creating an object

	}

}
