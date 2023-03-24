<!--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rivet.Student" %>
      <%@ page import="com.rivet.dao.StudentDao" %>
      <%@ page import="java.util.*" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link href="Style.css" rel="stylesheet"></link>
</head>
<body>

<%


List<Student> l1=new ArrayList<>();
l1 = StudentDao.ViewAllStudents();

out.print("<table border=1><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>PASSWORD</th><th>EDIT</th><th>DELETE</th></tr>");
for(Student u:l1){
	

	out.print("<tr><td><a  style=text-decoration:none href=create?action=viewByid&id="+u.getId()+">"+u.getId()+"</td><td><a  style=text-decoration:none href=create?action=viewByid&id="+u.getId()+">"+u.getName()+"</td><td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td><td><a  style=text-decoration:none href=UpdateStudent.jsp?id="+u.getId()+">"+"EDIT"+"</td><td><a href=create?action=DeleteByid&id="+u.getId()+">Delete</a></td></tr>");
	
}
out.print("</table>");
%>



</body>
</html>