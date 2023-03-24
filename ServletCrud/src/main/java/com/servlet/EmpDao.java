package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	static Connection con;

	public static Connection Getconnection() throws ClassNotFoundException {
		// to get connection to sql server

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=dbEmpServlet;encrypt=false";
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

	public static int saveEmp(Emp e) throws SQLException, ClassNotFoundException {

		int status = 0;

		Connection c = EmpDao.Getconnection();
		PreparedStatement st;
		// insert data into table
		String Sql = "insert into empuser values(?,?,?)";
		st = c.prepareStatement(Sql);

		st.setString(1, e.getName());

		st.setString(2, e.getEmailid());

		st.setString(3, e.getPassword());

		status = st.executeUpdate();
		return status;

	}

	public static List<Emp> ViewAllEmp() throws ClassNotFoundException, SQLException {

		List<Emp> l = new ArrayList<Emp>();

		int status = 0;

		con = EmpDao.Getconnection();
		// to get all Employee details

		String sql = "Select * from empuser";

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet s = st.executeQuery();

		while (s.next()) {
			Emp e1 = new Emp();
			System.out.println(s);
			e1.setId(s.getInt(1));
			e1.setName(s.getString(2));
			e1.setEmailid(s.getString(3));
			e1.setPassword(s.getString(4));

			l.add(e1);
			// System.out.println(l);

		}

		return l;

	}

	public static Emp ViewEmpByid(int id) throws ClassNotFoundException, SQLException {

		Emp e1 = new Emp();
		int status = 0;
		con = EmpDao.Getconnection();

		boolean Flag;
		Flag = UserExits(id);

		if (Flag == false) {
			System.out.println("Wroung User id");
		} else {
			// to get Employee by i'd detail
			String sql = "Select * from empuser where id=" + id;

			PreparedStatement st = con.prepareStatement(sql);
			ResultSet s = st.executeQuery();

			while (s.next()) {

				System.out.println(s);
				e1.setId(s.getInt(1));
				e1.setName(s.getString(2));
				e1.setEmailid(s.getString(3));
				e1.setPassword(s.getString(4));

			}

		}
		return e1;
	}

	public static int Login(int id, String pwd) throws ClassNotFoundException, SQLException {
		int status = 0;
		con = EmpDao.Getconnection();

		try {
			boolean Flag;
			Flag = UserExits(id);

			if (Flag == false) {
				System.out.println("Wroung User id");
			} else {

				String Uid = "SELECT id,pwd FROM empuser where id=" + id;

				PreparedStatement st = con.prepareStatement(Uid);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					if (pwd.equals(rs.getString("pwd"))) {

						// System.out.println("login success");
						status = 1;

					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
	}

	public static boolean UserExits(int id) throws ClassNotFoundException {
		boolean f;
		try {
			con = EmpDao.Getconnection();
			String sql = "SELECT * FROM empuser";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			// check user is available ??

			ArrayList<Integer> Uid = new ArrayList<Integer>();

			while (rs.next()) {

				Uid.add(rs.getInt("id"));
			}
			f = Uid.contains(id);
		} catch (SQLException e) {
			f = false;
		}
		return f;

	}

	public static int DeleteByid(int i) throws SQLException, ClassNotFoundException {
		int status = 0;
		Emp e1 = new Emp();

		con = EmpDao.Getconnection();

		boolean Flag;
		Flag = UserExits(i);

		if (Flag == false) {
			System.out.println("Wroung User id");
		} else {
			// to get Employee by i'd detail
			String sql = "Delete from empuser where id=" + i;

			PreparedStatement st = con.prepareStatement(sql);
			status = st.executeUpdate();

		}
		return status;
	}

	public static int UpdateByid(Emp emp ) throws SQLException, ClassNotFoundException {
	
	
		int status = 0;
		
		
		Connection c = EmpDao.Getconnection();
		PreparedStatement st;
		// Update data into table
		String Sql = "update empuser set ename=?, email=? , pwd=? where id=?";
		st = c.prepareStatement(Sql);
		st.setInt(4, emp.getId());
		st.setString(1, emp.getName());
		st.setString(2, emp.getEmailid());
		st.setString(3, emp.getPassword());
		status = st.executeUpdate();
		
		System.out.println(status);
		return status;

	}
}
