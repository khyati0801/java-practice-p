<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.jspcrud.User" %>
      <%@ page import="com.jspcrud.JspDao" %>
      <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  margin: 0 auto;
  width: 50%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover{background-color: coral;}

.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 10px;
  margin: 0;
  cursor: pointer;
  width: 10%;}
  h1{text-align: center;
  background-color: coral;
  }
</style>
</head>
<body>
	<h1 >All Users</h1>
	<form action="" >
	<table border=1>
	
	
	
	
	</table>
	</form>

</body>
<%

List<User> l1=JspDao.ViewAllUser();
out.print("<table><tr><th>ID</th><th>NAME</th><th>EMAIL</th><th>PASSWORD</th><th>EDIT</th><th>DELETE</th></tr>");
for(User u:l1){
	

	out.print("<tr><td><a  style=text-decoration:none href=UserById.jsp?id="+u.getId()+">"+u.getId()+"</td><td><a  style=text-decoration:none href=UserById.jsp?id="+u.getId()+">"+u.getName()+"</td><td>"+u.getEmailid()+"</td><td>"+u.getPassword()+"</td><td><a  style=text-decoration:none href=Update.jsp?id="+u.getId()+">"+"EDIT"+"</td><td><a href=Deletbyid.jsp?id="+u.getId()+">Delete</a></td></tr>");
	
}
out.print("</table>");

%>

<tr><td><a href="AddUser.html"><input type=button class="button" name="New User" value="Add New User"></a></tr></td>

</html>