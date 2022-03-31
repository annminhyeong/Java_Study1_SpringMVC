<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<String> list = new ArrayList<String>();
	list.add("python");
	list.add("java");
	list.add("node.js");
	list.add("c++");
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl06 page</title>
</head>
<body>
	
	<c:forEach var="sw" items="${list}">
		<p>프로그래밍언어:${sw}</p>
	</c:forEach>
</body>
</html>