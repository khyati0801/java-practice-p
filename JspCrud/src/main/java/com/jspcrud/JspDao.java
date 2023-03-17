package com.jspcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JspDao {
	static Connection con;

	public static Connection Getconnection() throws ClassNotFoundException {
		// to get connection to sql server

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=dbUserJsp;encrypt=false";
		String username = "sa";
		String password = "Admin@123";
		try {
			con = DriverManager.getConnection(url, username, password);

			// System.out.println("Conection Success");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public static int saveUSer(User u) throws SQLException, ClassNotFoundException {

		int status = 0;

		Connection c = JspDao.Getconnection();
		PreparedStatement st;
		// insert data into table
		String Sql = "insert into userj values(?,?,?)";
		st = c.prepareStatement(Sql);

		st.setString(1, u.getName());

		st.setString(2, u.getEmailid());

		st.setString(3, u.getPassword());

		status = st.executeUpdate();
		return status;

	}

	public static List<User> ViewAllUser() throws ClassNotFoundException, SQLException {

		List<User> l = new ArrayList<User>();

		int status = 0;

		con = JspDao.Getconnection();
		// to get all Employee details

		String sql = "Select * from userj";

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet s = st.executeQuery();

		while (s.next()) {
			User e1 = new User();

			e1.setId(s.getInt(1));
			e1.setName(s.getString(2));
			e1.setEmailid(s.getString(3));
			e1.setPassword(s.getString(4));

			l.add(e1);
			// System.out.println(l);

		}

		return l;

	}

	public static int DeleteByid(int i) throws SQLException, ClassNotFoundException {
		int status = 0;
		User e1 = new User();

		con = JspDao.Getconnection();

		String sql = "Delete from userj where id=" + i;

		PreparedStatement st = con.prepareStatement(sql);
		status = st.executeUpdate();

		return status;
	}

	public static User ViewUserByid(int id) throws ClassNotFoundException, SQLException {

		User User1 = new User();

		con = JspDao.Getconnection();
		String sql = "Select * from userj where id=" + id;

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet s = st.executeQuery();

		while (s.next()) {

			User1.setId(s.getInt(1));
			User1.setName(s.getString(2));
			User1.setEmailid(s.getString(3));
			User1.setPassword(s.getString(4));

		}

		return User1;
	}

	public static int UpdateUserByid(User u) throws SQLException, ClassNotFoundException {

		int status = 0;

		Connection c = JspDao.Getconnection();
		PreparedStatement st;
		// Update data into table
		String Sql = "update userj set uname=?, email=? , pwd=? where id=?";
		st = c.prepareStatement(Sql);
		st.setInt(4, u.getId());
		st.setString(1, u.getName());
		st.setString(2, u.getEmailid());
		st.setString(3, u.getPassword());
		status = st.executeUpdate();

		return status;

	}
}
