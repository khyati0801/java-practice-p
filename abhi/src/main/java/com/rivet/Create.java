package com.rivet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.rivet.dao.DAOService;

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
		
		DAOService.create(e1);
		out.print("Data Save");
		response.sendRedirect("Homepage.jsp");
		break;
		
		
		
		case "viewAll":
			
			List<Student> l1 = null;
			try {
				l1 = DAOService.ViewAllStudents();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.print("<table border=1><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>PASSWORD</th></tr>");
			for(Student u:l1){
				

				out.print("<tr><td><a  style=text-decoration:none href=UserById.jsp?id="+u.getId()+">"+u.getId()+"</td><td><a  style=text-decoration:none href=UserById.jsp?id="+u.getId()+">"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td></tr>");
				
			}
			out.print("</table>");
			break;
		
		
		case "viewByid":
			out.print("view by id");
			out.print("<table border=1><tr><td>ID</td><td>NAME</td><td>EMAIL</td><td>PASSWORD</td></tr>");
			int id1 = Integer.parseInt(request.getParameter("id"));

			Student u = null;
			try {
				u = DAOService.ViewStudentByid(id1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.print("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td></tr>");

			out.print("</table>");
			
			break;
		case "DeleteByid":
			
			int Deleteid = Integer.parseInt(request.getParameter("id"));
			Student DeleteStudent = null;
			try {
				DeleteStudent = DAOService.ViewStudentByid(Deleteid);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				DAOService.DeleteByid(DeleteStudent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "UpdateByid":
			
			out.print("Update by id");
			
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
				
				DAOService.UpdateByid(Stud1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	

}
