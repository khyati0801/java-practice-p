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

@WebServlet ("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter pout = res.getWriter();

		
		
		pout.print("<form action=LoginServlet method=get align=center>");
		pout.print("<h2>Login Page</h2>");
		pout.print("<Table border=1>");
		pout.print("<tr>Enter Id:<input type=text name=id required><tr><br>");
		
		pout.print("Enter Password:<input type=text name=pwd required><br>");
		
		pout.print("<input type=submit>");
		pout.print("</Table>");
		pout.print("</form>");
		
		if(!(req.getParameter("id")==null)) {
			int i=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("pwd");
			//enter id and password
			
			try {
				int l1=EmpDao.Login(i,name);
				
				if(l1>0){  
		            pout.print("<p>Login successfully!</p>");  
		           req.getRequestDispatcher("HomePage.html").forward(req, res);  
		        }else{  
		            pout.println("Sorry! Try Again");  
		            
		  
		        }  
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		 
		
		
	}
}
