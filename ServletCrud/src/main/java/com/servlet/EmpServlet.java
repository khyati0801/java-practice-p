package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet{
	
		protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
			
			res.setContentType("text/html");
			
			PrintWriter pout=res.getWriter();
			
			String name=req.getParameter("name");
			String Email=req.getParameter("emailid");
			String password=req.getParameter("pwd");
			
			
		Emp e1=new Emp();	
		
		e1.setName(name);
		e1.setEmailid(Email);
		e1.setPassword(password);
		
		int status=0;
	
			try {
				status = EmpDao.saveEmp(e1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(status>0){  
	            pout.print("<p>Record saved successfully!</p>");  
	             
	        }else{  
	            pout.println("Sorry! unable to save record");  
	        }  
	          
			
			
			
		}

}
