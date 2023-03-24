package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet ("/DeleteServletById")
public class DeleteServletById extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pout = res.getWriter();
		
        pout.print("Employee Delete by ID");
		
		pout.print("<form action=DeleteServletById><input type=text name=id>");
		pout.print("<input type=submit>");
		int i=Integer.parseInt(req.getParameter("id"));
		int e1=0;
		
			try {
			e1=EmpDao.DeleteByid(i);
			if(e1>0) {
				
				pout.print("User Deleted");
				req.getRequestDispatcher("HomePage.html").forward(req, res);
			}
			else {
				
				pout.print("User not Exits Try again");
			}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
				
			
			pout.print("</form>");
}
	}

