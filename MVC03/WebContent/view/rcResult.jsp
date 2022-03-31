<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	String name = request.getParameter("name");
	String age = request.getParameter("age");
 	String pass = request.getParameter("pass");
 	
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rcResult page</title>
</head>
<body>
	Controller에서 redirect기법으로 받은 값:<br>
	이름:<%=name %><br>
	이름:<%=age %><br>
	이름:<%=pass %><br>
</body>
</html>