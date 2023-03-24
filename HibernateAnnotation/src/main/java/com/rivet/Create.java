package com.rivet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ObjectNotFoundException;

import com.rivet.dao.StudentDao;



@WebServlet("/create")
public class Create extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		
		
		switch(action) {
		case "save":
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Student e1 = new Student();
		e1.setName(name);
		e1.setEmail(email);
		e1.setPassword(password);
		
		StudentDao.create(e1);
		out.print("Data Save");
		response.sendRedirect("Homepage.jsp");
		break;
		
		
		
		case "viewAll":
			
			List<Student> l1 = null;
			try {
				
				l1 = StudentDao.ViewAllStudents();
				request.setAttribute("student", l1);
				Student s=new Student();
				RequestDispatcher dr=request.getRequestDispatcher("GetAA.jsp");
				dr.forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.print("<table border=1><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>PASSWORD</th></tr>");
			for(Student u:l1){
				

				out.print("<tr><td><a  style=text-decoration:none href=ViewStudentBYid.jsp?id="+u.getId()+">"+u.getId()+"</td><td><a  style=text-decoration:none href=ViewStudentBYid.jsp?id="+u.getId()+">"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td></tr>");
				
			}
			out.print("</table>");
			break;
		
		
		case "viewByid":
			out.print("view by id");
			out.print("<table border=1><tr><td>ID</td><td>NAME</td><td>EMAIL</td><td>PASSWORD</td></tr>");
			int id1 = Integer.parseInt(request.getParameter("id"));

		
			try {
				Student u  = StudentDao.ViewStudentByid(id1);
		
				out.print("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td></tr>");

				out.print("</table>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(ObjectNotFoundException e) {
				request.setAttribute("error", "No user availble");
				request.getRequestDispatcher("Error.jsp").forward(request, response);
				
			}

			
			
			break;
		case "DeleteByid":
			
			int Deleteid = Integer.parseInt(request.getParameter("id"));
			Student DeleteStudent = null;
			try {
				DeleteStudent = StudentDao.ViewStudentByid(Deleteid);
				StudentDao.DeleteByid(DeleteStudent);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(ObjectNotFoundException e) {
				request.setAttribute("error", "No user availble");
				request.getRequestDispatcher("Error.jsp").forward(request, response);
				
			}
			
			break;
		case "UpdateByid":
			
	
			int UpdateId=Integer.parseInt(request.getParameter("id"));
			
			String sname = request.getParameter("name");
			String semail = request.getParameter("email");
			String spassword = request.getParameter("password");

			Student Stud1 = new Student();
			Stud1.setId(UpdateId);
			Stud1.setName(sname);
			Stud1.setEmail(semail);
			Stud1.setPassword(spassword);
			
			try {
				
				StudentDao.UpdateByid(Stud1);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(ObjectNotFoundException e) {
				request.setAttribute("error", "No user availble");
				request.getRequestDispatcher("Error.jsp").forward(request, response);
				
			}
			break;
			default:
				System.exit(0);
		}	
	}
	

}
