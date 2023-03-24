<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rivet.Student" %>
      <%@ page import="com.rivet.dao.StudentDao" %>
      <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="Style.css" rel="stylesheet"></link>
</head>
<body align=center>
<form action="" method="post" align="center">
	<h2>Welcome</h2>
	<button class="button"><a href="index.jsp">Add New Students</a></button><br> <br>
	<button class="button"><a href="GetAllUser.jsp">View All Students</a></button><br><br>
	
	<button class="button"><a href="create?action=viewAll">View Student by jstl</a></button><br><br>
	</form>
	
<%
	List<Student> l1=new ArrayList<>();
	l1 = StudentDao.ViewAllStudents();

	out.print("<table Border=1><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>PASSWORD</th><th>EDIT</th><th>DELETE</th></tr>");
	for(Student u:l1){
		

		out.print("<tr><td><a  style=text-decoration:none href=create?action=viewByid&id="+u.getId()+">"+u.getId()+"</td><td><a  style=text-decoration:none href=create?action=viewByid&id="+u.getId()+">"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td><td><a  style=text-decoration:none href=UpdateStudent.jsp?id="+u.getId()+">"+"EDIT"+"</td><td><a href=create?action=DeleteByid&id="+u.getId()+">Delete</a></td></tr>");
		
	}
	out.print("</table>");
	%>

</body>

</html>