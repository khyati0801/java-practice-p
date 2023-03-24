package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServletBYId")
public class UpdateServletBYId extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter pout = res.getWriter();
		// pout.print("hi");
		pout.print("<form action=UpdateServletBYId method=post align=center>");
		pout.print("<h2>Update your Details</h2>");
		pout.print("<Table border=1  align=center>");
		pout.print("<tr>Enter Id:<input type=text name=id required><tr><br>");
		pout.print("<input type=submit>");

		pout.print("</Table>");
		pout.print("</form>");

	}

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
	Emp e1=new Emp();
	res.setContentType("text/html");
int i=Integer.parseInt(req.getParameter("id"));

	PrintWriter pout = res.getWriter();
	
		int status = 0;

		
			
			try {
				e1 = EmpDao.ViewEmpByid(i);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
if(!(e1.getId()==0)) {
			pout.print("Employee by ID");

			pout.print("<form action=UpdateServlet2 method=post>");
			//
			pout.print("<table border=1>");
			pout.print("<tr><td>Id : <input type=text name=id value='"+e1.getId()+"' readonly></td></tr>");
			pout.println("<tr><td>Name:<input type=text name=name value='"+e1.getName()+"'></td></tr>");
			pout.println("<tr><td>Email:<input type=text name=emailid value='"+e1.getEmailid()+"'></td></tr>");
			pout.println("<tr><td>Password:<input type=text name=pwd value='"+e1.getPassword()+"'></td></tr>");
			pout.print("</table>");
			pout.print("<input type=submit>");
			pout.print("</form>");
		
		}
		// req.getRequestDispatcher("Update.html").forward(req, res); 
	}
}
