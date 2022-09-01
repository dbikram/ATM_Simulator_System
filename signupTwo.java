package BMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class signupTwo extends JFrame {

	private JPanel contentPane;
	private JTextField qualificationTextField;
	private JTextField occupationTextField;
	private JTextField panNumberTextField;
	private JTextField adharNumberTextField;
	private String formno;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupTwo frame = new signupTwo("");
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
	public signupTwo(String formno) {
		this.formno = formno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 676);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		additionalDetails.setBounds(240, 24, 240, 30);
		contentPane.add(additionalDetails);
		
		JLabel religionLabel = new JLabel("Religion:");
		religionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		religionLabel.setBounds(81, 100, 77, 20);
		contentPane.add(religionLabel);
		
		String option[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		JComboBox religionComboBox = new JComboBox(option);
		religionComboBox.setSelectedIndex(-1);
		religionComboBox.setBackground(Color.WHITE);
		religionComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		religionComboBox.setBounds(294, 100, 274, 23);
		contentPane.add(religionComboBox);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		categoryLabel.setBounds(81, 150, 88, 20);
		contentPane.add(categoryLabel);
		
		String option1[] = {"General", "SC", "ST", "Other"};
		JComboBox categoryComboBox = new JComboBox(option1);
		categoryComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		categoryComboBox.setBounds(294, 150, 274, 23);
		contentPane.add(categoryComboBox);
		
		JLabel qualificationLabel = new JLabel("Qualification:");
		qualificationLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		qualificationLabel.setBounds(81, 207, 119, 20);
		contentPane.add(qualificationLabel);
		
		qualificationTextField = new JTextField();
		qualificationTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		qualificationTextField.setBounds(294, 207, 271, 22);
		contentPane.add(qualificationTextField);
		qualificationTextField.setColumns(255);
		
		JLabel occupationLabel = new JLabel("Occupation:");
		occupationLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		occupationLabel.setBounds(81, 266, 102, 20);
		contentPane.add(occupationLabel);
		
		occupationTextField = new JTextField();
		occupationTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		occupationTextField.setBounds(294, 266, 274, 22);
		contentPane.add(occupationTextField);
		occupationTextField.setColumns(255);
		
		JLabel panNumberLabel = new JLabel("PAN Number:");
		panNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panNumberLabel.setBounds(81, 326, 119, 20);
		contentPane.add(panNumberLabel);
		
		panNumberTextField = new JTextField();
		panNumberTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		panNumberTextField.setBounds(294, 326, 274, 22);
		contentPane.add(panNumberTextField);
		panNumberTextField.setColumns(255);
		
		JLabel adharNumberLabel = new JLabel("Aadhar Number:");
		adharNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		adharNumberLabel.setBounds(81, 389, 138, 20);
		contentPane.add(adharNumberLabel);
		
		adharNumberTextField = new JTextField();
		adharNumberTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		adharNumberTextField.setBounds(294, 389, 274, 22);
		contentPane.add(adharNumberTextField);
		adharNumberTextField.setColumns(25);
		
		JLabel existingAcLabel = new JLabel("Existing Account:");
		existingAcLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		existingAcLabel.setBounds(81, 456, 154, 20);
		contentPane.add(existingAcLabel);
		
		JRadioButton existYesRadioButton = new JRadioButton("Yes");
		existYesRadioButton.setBackground(Color.WHITE);
		existYesRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		existYesRadioButton.setBounds(294, 457, 62, 21);
		contentPane.add(existYesRadioButton);
		
		JRadioButton existNoRadioButton = new JRadioButton("No");
		existNoRadioButton.setBackground(Color.WHITE);
		existNoRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		existNoRadioButton.setBounds(506, 457, 62, 21);
		contentPane.add(existNoRadioButton);
		
		ButtonGroup existingAC = new ButtonGroup();
		existingAC.add(existNoRadioButton);
		existingAC.add(existYesRadioButton);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			

			

			public void actionPerformed(ActionEvent e) {
				
				String religion = (String)religionComboBox.getSelectedItem();
				String category =(String)categoryComboBox.getSelectedItem();
				String qualification = qualificationTextField.getText();
				String occupation = occupationTextField.getText();
				String pan = panNumberTextField.getText();
				String aadhar = adharNumberTextField.getText();
				String exist = null;
				if(existYesRadioButton.isSelected()) {
					exist = "Yes";
				}
				else if(existNoRadioButton.isSelected()) {
					exist = "No";
				}
				
				try {
					
					if(religion.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null,"Religion is required" );
	    			}
	    			else if(category.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Category is required");
	    			}
	    			else if(qualification.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Qualification is required");
	    			}
	    			else if(occupation.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Occupation is required");
	    			}
	    			else if(pan.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Pan Numberis required");
	    			}
	    			else if(aadhar.equals("")) //if name is empty
	    			{
	    				JOptionPane.showMessageDialog(null, "Aadhar Number is required");
	    			}
	    			else {
					Conn c = new Conn();
					String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+exist+"')";
					c.s.executeUpdate(query);
					//JOptionPane.showMessageDialog(null, "Details have been successfully added.");
					setVisible(false);
					new signupThree(formno).setVisible(true);
	    			}
					
				}
				catch(Exception ee) {
					System.out.println(ee);
				}
				
				
				
			}
		});
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		nextButton.setForeground(Color.WHITE);
		nextButton.setBackground(Color.BLACK);
		nextButton.setBounds(474, 536, 94, 36);
		contentPane.add(nextButton);
	}
}
