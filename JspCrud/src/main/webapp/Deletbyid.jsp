<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspcrud.User"%>
<%@ page import="com.jspcrud.JspDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int id1 = Integer.parseInt(request.getParameter("id"));

	int Status = JspDao.DeleteByid(id1);

	if (Status > 0) {
		out.print("Data Deleted");
	} else {
		
		out.print("Data Not Deleted");
	}
	%>
</body>


</html>