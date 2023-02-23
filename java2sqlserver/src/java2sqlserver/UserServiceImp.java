package java2sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserServiceImp implements UserServices {

	Scanner sc = new Scanner(System.in);
	
	String query = "SELECT * FROM UserD";
	
	@Override
	public void createUser(User user) {
		
		PreparedStatement st1;
		try {
			ContectionTodb.con.setAutoCommit(false);
			st1 = ContectionTodb.con.prepareStatement("INSERT INTO UserD values(?,?,?,?,?,?)");
			
			System.out.println("Enter User ID");
			st1.setInt(1, sc.nextInt());

			System.out.println("Enter  Name");
			st1.setString(2, sc.next());

			System.out.println("Enter  Password");
			st1.setString(3, sc.next());

			System.out.println("Enter Address");
			st1.setString(4, sc.next());

			System.out.println("Enter mobile No");
			st1.setLong(5, sc.nextLong());

			System.out.println("Enter Balance");
			st1.setDouble(6, sc.nextDouble());
			
			System.out.println("dou want to save the Data Y/N");
			String s=sc.next();
			if(s.equalsIgnoreCase("Y")) {
			st1.executeUpdate();
			ContectionTodb.con.commit();
			System.out.println("User Created Successfully");
			getAllUser();
			}
			else {
				ContectionTodb.con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getUserbyID(int id) {

		try {
			String query1 = "SELECT * FROM UserD where uid=" + id;
			Statement st = ContectionTodb.con.createStatement();;

			ResultSet rs = st.executeQuery(query);
			
			System.out.println("Id  Accountno  Name  Address  Mobile  Balance");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
						+ rs.getString(5) + " " + rs.getInt(6) + "  " + rs.getDouble(7));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getAllUser() {

		try {

			Statement st = ContectionTodb.con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println("Id   AccountNo   Name   Address   Mobile   Balance");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(5)
						+ " " + rs.getInt(6) + "  " + rs.getDouble(7));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser() {

		try {
			String Uid = "SELECT Uid FROM UserD";
			Statement st = ContectionTodb.con.createStatement();

			ResultSet rs = st.executeQuery(Uid);

			while (rs.next()) {

				System.out.println("Enter UserID");
				int UserId = sc.nextInt();
				if (UserId == rs.getInt("uid")) {
					System.out.println("Enter New Name");
					String S = sc.next();
					String sql = "UPDATE UserD SET uname='" + S + "' where uid=" + UserId + "";
					System.out.println("Data Updated with user_id" + UserId);
					st.executeUpdate(sql);
					rs = st.executeQuery("SELECT * FROM UserD where Uid=" + UserId);
					
					System.out.println("Id  AccountNo   Name   Address   Mobile   Balance");
					while (rs.next())
						System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + " " + "\t" + rs.getString(3) + "  "
								+ rs.getString(4) + "  " + rs.getString(5) + " " + rs.getDouble(6));

				} else {
					System.out.println("Wroung User id");
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteById() {
		try {
			String Uid = "SELECT uid FROM UserD";
			Statement st = ContectionTodb.con.createStatement();

			ResultSet rs = st.executeQuery(Uid);

			while (rs.next()) {

				System.out.println("Enter UserID");
				int UserId = sc.nextInt();
				if (UserId == rs.getInt("uid")) {
					String sql = "DELETE FROM UserD where uid=" + UserId;
					st.executeUpdate(sql);
					rs = st.executeQuery(query);
					
					System.out.println("Id  Name  Address  Mobile  Balance");
					while (rs.next()) {

						System.out.println(rs.getInt(1) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  "
								+ rs.getString(5) + " " + rs.getDouble(6));
					}
				} else {
					System.out.println("Wroung User id");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Login(int id) {
		try {
			boolean Flag;
			Flag = UserExits(id);

			if (Flag == false) {
				System.out.println("Wroung User id");
			} else {
				Statement st;
				st = ContectionTodb.con.createStatement();

				System.out.println("Enter password");
				String Pwd = sc.next();
				String Uid = "SELECT upwd FROM UserD where uid=" + id;
				ResultSet rs = st.executeQuery(Uid);
				
				while (rs.next()) {
					if (Pwd.equals(rs.getString("upwd"))) {

						System.out.println("login success");
						AccountOp.AfterLogin(id);
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static boolean UserExits(int id) {
		boolean f;
		try {
			String sql = "SELECT * FROM UserD";
			Statement st = ContectionTodb.con.createStatement();

			// check user is available ??

			ResultSet rs = st.executeQuery(sql);
			
			ArrayList<Integer> Uid = new ArrayList<Integer>();

			while (rs.next()) {

				Uid.add(rs.getInt("uid"));
			}
//			Iterator i=Uid.iterator();
//			while(i.hasNext()) {
//				System.out.println(i.next());
//			}
			ContectionTodb.con.commit();
			f = Uid.contains(id);
		} catch (SQLException e) {
			f = false;
		}
		
		return f;

	}

}
