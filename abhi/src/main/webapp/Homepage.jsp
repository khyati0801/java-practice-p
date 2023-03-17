<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="Style.css" rel="stylesheet"></link>
</head>
<body>
<form action="" method="post" align="center">
	<h2>Welcome</h2>
	<button class="button"><a href="index.jsp">Add New Students</a></button><br> <br>
	<button class="button"><a href="create?action=viewAll">View All Students</a></button><br><br>
	<button class="button"><a href="ViewStudentBYidjsp.jsp">View Student by ID</a></button><br><br>
	<button class="button"><a href="DeleteByid.jsp">Delete Student by ID</a></button><br><br>
	<button class="button"><a href="Update.jsp">Update  Student by ID</a></button>
	</form>

</body>
</html>