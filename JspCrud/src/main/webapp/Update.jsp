<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jspcrud.User"%>
    <%@ page import="com.jspcrud.JspDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
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
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  width: 30%;}
</style>
</head>
<body>
 

<%
int i=Integer.parseInt(request.getParameter("id"));
User u = JspDao.ViewUserByid(i);

%>
<form action="Updateuser.jsp" method="post">  
<tr><td>User id:</td><td>  
<input type="text" name="id" value="<%=u.getId()%>" readonly>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%=u.getName() %>"/></td></tr>
<tr><td>Email:</td><td>  
<input type="email" name="email" value="<%=u.getEmailid()  %>"/></td></tr>   
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%=u.getPassword()  %>"/></td></tr>  
<tr><td colspan="2"><input type="submit" class="button" value="Edit User"/></td></tr>  
</table>
</form>
</body>
</html>