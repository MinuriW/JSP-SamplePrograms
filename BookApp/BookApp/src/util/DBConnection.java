package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;
		
		ResourceBundle rb = ResourceBundle.getBundle("oracle");
		String url = rb.getString("db.url");
		String username = rb.getString("db.username");
		String password = rb.getString("db.password");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, username, password);
		
		return con;
	}

}
