package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// method that gets the connection to the database given
	public static Connection getConnection() {
		
		// path to the database
		String url = "jdbc:mysql://localhost/queuevisitor?useSSL=false";
		
		// user name
		String user = "root";
		
		// password of the database
		String password = "root";
		
		try {
			// getting the connection through the getConnection static method from the DriverManager class
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// if connection failed, throw a new RunTimeException
			throw new RuntimeException(e);
		}
	}

}
