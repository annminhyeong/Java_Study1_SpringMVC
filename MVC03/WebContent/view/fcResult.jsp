<%@page import="kr.bit.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fcResult page</title>
</head>
<body>
	Controller에서 forward기법으로 받은 값: <br>
	이름:<%=vo.getName()%><br>
	나이:<%=vo.getAge()%><br>
	비밀번호:<%=vo.getPass()%><br>
</body>
</html>