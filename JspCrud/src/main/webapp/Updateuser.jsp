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

int Status=0;
int id=Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
String email=request.getParameter("email");
String Pwd=request.getParameter("password");
User u=new User();
u.setId(id);
u.setName(name);
u.setEmailid(email);
u.setPassword(Pwd);

Status=JspDao.UpdateUserByid(u);
out.print(Status);
if(Status>0){  
    out.print("Record saved successfully!");  
     
     
}else{  
    out.println("Sorry! unable to save record");  
}  

%>
</body>
</html>