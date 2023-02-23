package java2sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deposit {
	static Scanner sc = new Scanner(System.in);

	public static void Deposit1(int id) {

		try {
			Statement st = ContectionTodb.con.createStatement();
			System.out.println("Enter Amount to Deposit");
			double Amt = sc.nextInt();
			if (Amt <= 0) {
				System.out.println("You Enter wroung Amount");
				Deposit1(id);

			} else {
				String sql = "UPDATE UserD SET Ubalance=Ubalance+" + Amt + "where Uid=" + id;

				st.executeUpdate(sql);
				System.out.println("Data Updated with user_id   " + id);
				ResultSet rs = st.executeQuery("SELECT * FROM UserD where Uid=" + id);

				while (rs.next()) {
					Double CurrentBalance = rs.getDouble("Ubalance");
					System.out.println("Updated Balance" + CurrentBalance);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
