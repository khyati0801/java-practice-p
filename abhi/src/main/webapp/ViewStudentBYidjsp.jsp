<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student by ID</title>
<link href="Style.css" rel="stylesheet"></link>
</head>
<body>
<form action="create?action=viewByid" method="post">
	<table class=table>
	<tr><td>Enter ID:</td><td><input type="text" name="id" required></td></tr>
	<tr><td><input type="Submit" name="SubmitBtn"></td></tr>
	</table>
	</form>

</body>
</html>