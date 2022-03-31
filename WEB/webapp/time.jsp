<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타임 홈페이지</title>
</head>
<body>
	웹 디렉터리 구조 연습(동적인 페이지)<br>
	지금 시각은? <%=date%><br>
	정보를 실시간으로 변경 할수 있음
	
	
</body>
</html>