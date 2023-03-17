<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Student</title>
</head>
<body>
<form action="create?action=save" method="post">
	<table>
	<tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" required></td></tr>
	<tr><td>Password:</td><td><input type="text" name="password" required></td></tr>
	<tr><td><input type="Submit" name="SubmitBtn"></td></tr>
	</table>
	</form>
</body>
</html>