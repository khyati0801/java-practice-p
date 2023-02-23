package java2sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WithDraw {
	static Scanner sc = new Scanner(System.in);

	public static void WithDraw(int id) {
		try {

			Statement st = ContectionTodb.con.createStatement();
			System.out.println("Enter Amount to WithDraw");
			double Amt = sc.nextInt();

			String getBalance = "Select Ubalance FROM UserD where Uid=" + id;
			ResultSet rsb = st.executeQuery(getBalance);
			while (rsb.next()) {

				if (Amt > rsb.getDouble("Ubalance"))

				{
					System.out.println("can't withdraw insufficient balance in your Account");
					WithDraw(id);

				}
				if (Amt <= 0) {
					System.out.println("You Enter Wroung Amount");
					WithDraw(id);
				} else {
					String sql = "UPDATE UserD SET Ubalance=Ubalance-" + Amt + "where Uid=" + id;

					st.executeUpdate(sql);
					System.out.println("Data Updated with user_id" + id);

					rsb = st.executeQuery("Select Ubalance FROM UserD where Uid=" + id);
					while (rsb.next()) {
						Double CurrentBalance = rsb.getDouble("Ubalance");
						System.out.println("Updated Balance" + CurrentBalance);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
