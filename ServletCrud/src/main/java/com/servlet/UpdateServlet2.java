package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		{
			doPost(req, res);
		}
		}
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	// req.getRequestDispatcher("Update.html").forward(req, res); 
				res.setContentType("text/html");

				PrintWriter pout = res.getWriter();
				
				int id=Integer.parseInt(req.getParameter("id"));
				String name = req.getParameter("name");
				String Email = req.getParameter("emailid");
				String password = req.getParameter("pwd");

				Emp e2 = new Emp();
				e2.setId(id);
				e2.setName(name);
				e2.setEmailid(Email);
				e2.setPassword(password);
				
				int status1=0;
				
				try {
					status1 = EmpDao.UpdateByid(e2);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  if(status1>0){  
		            pout.print("<p>data saved successfully!</p>"); 
		            req.getRequestDispatcher("HomePage.html").include(req, res);
		             
		        }else{  
		            pout.println("Sorry! unable to save record");  
		        }  

				}	
		
	
}
