package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signupOne extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField fnameTextField;
	private JTextField emailTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField pinTextField;
	private JTextField dateChooser;
	Long random;
	JButton next;
	JRadioButton male ,female,married,unmarried,other;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupOne frame = new signupOne();
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
	public signupOne() {
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 709);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
		formno.setFont(new Font("Tahoma", Font.BOLD, 18));
		formno.setBounds(219, 10, 306, 43);
		contentPane.add(formno);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		personDetails.setBounds(261, 49, 224, 36);
		contentPane.add(personDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 17));
		name.setBounds(71, 128, 117, 25);
		contentPane.add(name);
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Tahoma", Font.BOLD, 17));
		fname.setBounds(71, 173, 131, 25);
		contentPane.add(fname);
		
		JLabel dob = new JLabel("Date Of Birth:");
		dob.setFont(new Font("Tahoma", Font.BOLD, 17));
		dob.setBounds(71, 220, 125, 25);
		contentPane.add(dob);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Tahoma", Font.BOLD, 17));
		gender.setBounds(71, 274, 117, 20);
		contentPane.add(gender);
		
		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Tahoma", Font.BOLD, 17));
		email.setBounds(71, 322, 131, 25);
		contentPane.add(email);
		
		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Tahoma", Font.BOLD, 17));
		marital.setBounds(71, 374, 131, 20);
		contentPane.add(marital);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Tahoma", Font.BOLD, 17));
		address.setBounds(71, 421, 117, 20);
		contentPane.add(address);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Tahoma", Font.BOLD, 17));
		city.setBounds(71, 462, 117, 20);
		contentPane.add(city);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Tahoma", Font.BOLD, 17));
		state.setBounds(71, 506, 112, 20);
		contentPane.add(state);
		
		JLabel pin = new JLabel("PIN CODE:");
		pin.setFont(new Font("Tahoma", Font.BOLD, 17));
		pin.setBounds(71, 557, 131, 20);
		contentPane.add(pin);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameTextField.setBounds(310, 128, 306, 27);
		contentPane.add(nameTextField);
		nameTextField.setColumns(255);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		fnameTextField.setBounds(310, 173, 306, 25);
		contentPane.add(fnameTextField);
		fnameTextField.setColumns(255);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		emailTextField.setBounds(310, 322, 306, 25);
		contentPane.add(emailTextField);
		emailTextField.setColumns(255);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		addressTextField.setBounds(310, 418, 306, 25);
		contentPane.add(addressTextField);
		addressTextField.setColumns(255);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		cityTextField.setBounds(310, 459, 306, 26);
		contentPane.add(cityTextField);
		cityTextField.setColumns(255);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		stateTextField.setBounds(310, 506, 306, 25);
		contentPane.add(stateTextField);
		stateTextField.setColumns(255);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		pinTextField.setBounds(310, 554, 306, 25);
		contentPane.add(pinTextField);
		pinTextField.setColumns(255);
		
		dateChooser = new JTextField();
		dateChooser.setFont(new Font("Tahoma", Font.BOLD, 16));
		dateChooser.setBounds(310, 220, 306, 26);
		contentPane.add(dateChooser);
		dateChooser.setColumns(10);
		
		 male = new JRadioButton("Male");
		male.setBackground(Color.WHITE);
		male.setFont(new Font("Tahoma", Font.BOLD, 16));
		male.setBounds(310, 276, 72, 21);
		contentPane.add(male);
		
		 female = new JRadioButton("Female");
		female.setBackground(Color.WHITE);
		female.setFont(new Font("Tahoma", Font.BOLD, 16));
		female.setBounds(418, 276, 83, 21);
		contentPane.add(female);
		
		//buttongroup is used for selecting one radio button at a time
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(female);
		gendergroup.add(male);
		
		 married = new JRadioButton("Married");
		married.setBackground(Color.WHITE);
		married.setFont(new Font("Tahoma", Font.BOLD, 16));
		married.setBounds(310, 376, 89, 21);
		contentPane.add(married);
		
		 unmarried = new JRadioButton("Unmarried");
		unmarried.setFont(new Font("Tahoma", Font.BOLD, 16));
		unmarried.setBackground(Color.WHITE);
		unmarried.setBounds(418, 374, 120, 21);
		contentPane.add(unmarried);
		
		 other = new JRadioButton("Other");
		other.setBackground(Color.WHITE);
		other.setFont(new Font("Tahoma", Font.BOLD, 16));
		other.setBounds(556, 374, 72, 21);
		contentPane.add(other);
		
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
	    next = new JButton("NEXT");
	    next.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String formno = ""+random;
	    		String name = nameTextField.getText(); //getText() method is used to retrive the value from textfield
	    		String fname = fnameTextField.getText();
	    		String dob = dateChooser.getText();
	    		String gender = null;
	    		if(male.isSelected()) {
	    			gender = "Male";
	    		}
	    		else if(female.isSelected()) {
	    			gender = "Female";
	    		}
	    		
	    		String email = emailTextField.getText();
	    		
	    		String marital = null;
	    		if(married.isSelected()) {
	    			marital = "Married";
	    		}
	    		else if(unmarried.isSelected()) {
	    			marital = "Unmarried";
	    		}
	    		else if(other.isSelected()) {
	    			marital = "Other";
	    		}
	    		
	    		String address = addressTextField.getText();
	    		String city = cityTextField.getText();
	    		String state = stateTextField.getText();
	    		String pin = pinTextField.getText();
	    		
	    		try {
	    			if(name.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Name is required");
	    			}
	    			else if(fname.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Father's Name is required");
	    			}
	    			else if(dob.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Date of birth is required");
	    			}
	    			else if(gender.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Gender is required");
	    			}
	    			else if(email.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Email is required");
	    			}
	    			else if(address.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Address is required");
	    			}
	    			else if(city.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "City is required");
	    			}
	    			else if(state.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "State is required");
	    			}
	    			else {
	    				Conn c = new Conn(); //hitting the database
	    				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
	    				c.s.executeUpdate(query); //conn class object then statement object then updatequery method
	    				//JOptionPane.showMessageDialog(null, "Details have been successfully added.");
	    				
	    				//after succesfully added data, this signupone form gets closed and signup two form opens.
	    				setVisible(false);
	    				new signupTwo(formno).setVisible(true); //we pass the value of formno
	    			}
	    			
	    		}catch(Exception ae) {
	    			System.out.println(ae);
	    			
	    		}
	    		
	    		
	    	}
	    });
		next.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
		next.setFont(new Font("Tahoma", Font.BOLD, 20));
		next.setBounds(519, 606, 97, 36);
		contentPane.add(next);
		
		
	}
}
