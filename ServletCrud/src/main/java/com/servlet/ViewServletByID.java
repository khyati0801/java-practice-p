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
@WebServlet ("/ViewServletByID")
public class ViewServletByID extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		
		PrintWriter pout=res.getWriter();
		pout.print("Employee by ID");
		
		pout.print("<form action=ViewServletByID><input type=text name=id>");
		pout.print("<input type=submit>");

		if(!(req.getParameter("id") == null)) {
			int i=Integer.parseInt(req.getParameter("id"));
			
			Emp e1=new Emp();
				
					try {
						e1=EmpDao.ViewEmpByid(i);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					pout.print("<table border=1><tr><td>ID</td><td>NAME</td><td>EMAIL</td><td>PASSWORD</td></tr>");
					
					pout.print("<tr><td>"+e1.getId()+"</td><td>"+e1.getName()+"</td><td>"+e1.getEmailid()+"</td><td>"+e1.getPassword()+"</td></tr>");
				
					pout.print("</table>");
					
				
				pout.print("</form>");
		}
		
}}
