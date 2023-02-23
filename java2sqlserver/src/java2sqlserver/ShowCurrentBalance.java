package java2sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowCurrentBalance {
public static void ShowBalance(int id) {
		
		
		try {
			String query = "SELECT Ubalance FROM UserD where Uid="+id;
			Statement st=ContectionTodb.con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())  
			System.out.println("Current Balance in your Account "+rs.getDouble("Ubalance")); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}