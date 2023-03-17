<%@ page import="com.jspcrud.JspDao" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.jspcrud.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="ViewUser.jsp"></jsp:include> 
</body>
<%

int Status=0;
String name=request.getParameter("name");
String email=request.getParameter("email");
String Pwd=request.getParameter("pwd");
User u=new User();
u.setName(name);
u.setEmailid(email);
u.setPassword(Pwd);

Status=JspDao.saveUSer(u);

if(Status>0){  
    out.print("Record saved successfully!");  
     
     
}else{  
    out.println("Sorry! unable to save record");  
}  

%>

</html>