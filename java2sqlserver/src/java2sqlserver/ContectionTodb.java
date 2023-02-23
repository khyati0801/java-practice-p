package java2sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContectionTodb {
	static Connection con;

	public static Connection Getconnection() {
		// to get connection to sql server
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Bankdb;encrypt=false;trustServerCertificate=true;";

		String username = "sa";
		String password = "Admin@123";
		try {
			con = DriverManager.getConnection(url, username, password);
			
			//System.out.println("Conection Success");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}
}
