<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rivet.Student" %>
      <%@ page import="com.rivet.dao.StudentDao" %>
      <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jstl</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
hi

<%
//request.getAttribute("student");
//List<Student> l1=new ArrayList<>();
//l1 = StudentDao.ViewAllStudents();

%>
<div class=container>
<table  class="table table-striped table-hover"><thead>
<tr><th>id</th><th>Name</th><th>Email</th><th>Password</th></tr></thead><tbody class="table-group-divider">
<c:forEach   var="student1" items="${student}" >

<tr><td><c:out value="${student1.id}"></c:out></td>
<td><c:out value="${student1.name}"></c:out></td>
<td><c:out value="${student1.email}"></c:out></td>
<td><c:out value="${student1.password}"></c:out></td></tr>
</c:forEach></tbody>
</table>
</div>
</body>
</html>