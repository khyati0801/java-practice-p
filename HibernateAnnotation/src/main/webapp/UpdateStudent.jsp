
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rivet.Student" %>
      <%@ page import="com.rivet.dao.StudentDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="Style.css" rel="stylesheet"></link>
</head>
<body>
 <h1>Update page</h1>
<%
int i=Integer.parseInt(request.getParameter("id"));
Student s=StudentDao.ViewStudentByid(i);
%>
<form action="create?action=UpdateByid" method="post">  

<tr><td>User id:</td><td>  
<input type="text" name="id" value="<%=s.getId()%>" readonly>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%=s.getName() %>"/></td></tr>
<tr><td>Email:</td><td>  
<input type="email" name="email" value="<%=s.getEmail()%>"/></td></tr>   
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%=s.getPassword()  %>"/></td></tr>  
<tr><td colspan="2"><input type="submit" class="button" value="Edit User"/></td></tr>  
</table>
</form>

</body>
</html>