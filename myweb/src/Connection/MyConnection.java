package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConnection() { 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver loaded");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb","root","p@ssword");
	} 
		catch(ClassNotFoundException cnfe) { System.out.println("Could not load driver"); 
		}
		catch(SQLException se) {
			System.out.println("connect failed");
		}
	return null;
	}

}
