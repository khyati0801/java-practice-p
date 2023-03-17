<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jspcrud.User"%>
    <%@ page import="com.jspcrud.JspDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  width: 50%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: coral;}
</style>
</head>
<body>
<form action="" method="">

</form>

<%
out.print("<table border=1><tr><td>ID</td><td>NAME</td><td>EMAIL</td><td>PASSWORD</td></tr>");
	int id1 = Integer.parseInt(request.getParameter("id"));

	User u = JspDao.ViewUserByid(id1);

	out.print("<tr><td>"+u.getId()+"</td><td>"+u.getName()+"</td><td>"+u.getEmailid()+"</td><td>"+u.getPassword()+"</td></tr>");

	out.print("</table>");
%>

</body>
</html>