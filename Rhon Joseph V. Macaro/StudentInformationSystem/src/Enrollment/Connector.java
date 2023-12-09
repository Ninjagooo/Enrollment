package Enrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connector {
	public static Connection connect() {
		Connection conn = null;
		
		try {	
			conn = DriverManager.getConnection("Jdbc:sqlite:C://hello//roxy.db");
			//JOptionPane.showMessageDialog(null, "Successfully Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
}