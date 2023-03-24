package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet ("/ViewServlet")
public class ViewServlet extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		
		PrintWriter pout=res.getWriter();
		
		pout.println("Employee List");
		
		try {
			List<Emp> l1=EmpDao.ViewAllEmp();
			
			pout.print("<table border=1><tr><td>ID</td><td>NAME</td><td>EMAIL</td><td>PASSWORD</td></tr>");
			for(Emp e:l1) {
				
				pout.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmailid()+"</td><td>"+e.getPassword()+"</td></tr>");
			}
			pout.print("</table>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pout.close();
		
		
	}

}
