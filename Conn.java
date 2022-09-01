package BMS;

import java.sql.*;

public class Conn {
	
	//1)Register the driver
	//2)Create connection
	//3)Create statement
	//4)Execute query
	//5)Close connection
	
	Connection c;
	Statement s;
	
	public Conn() { //creating a constructor
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Register the driver
			
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Bikram@123"); //create connection
			
			s = c.createStatement(); //create a statemenet
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
