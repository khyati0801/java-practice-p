package java2sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection1 {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=TRY1;encrypt=false;trustServerCertificate=true;";

		String username = "sa";
		String password = "Admin@123";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connect to sql server");

		// String sql="INSERT INTO dbo.TABLE1(Eid,Ename)" + "values(03,'jatin')";

		Statement st = con.createStatement();
		// st.executeUpdate("INSERT INTO TABLE1(Eid,Ename)" + "values(?,?)");

		PreparedStatement st1 = con.prepareStatement("INSERT INTO TABLE1(Eid,Ename)" + "values(04,'sagar')");
		st1.setInt(1, 3);
		st1.setString(2, "jatin");

		st1.executeUpdate();

		ResultSet rs = st.executeQuery("select * from TABLE1");
		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2));

		con.close();

	}

}
