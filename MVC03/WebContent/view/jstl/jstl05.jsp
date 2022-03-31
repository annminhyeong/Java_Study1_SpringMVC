<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//controller --> jsp로 넘겼다 가정
String[] str = { "사과", "배", "포드", "바나나", "자두" };
request.setAttribute("str", str);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl05 page</title>
</head>
<body>

	<!-- items은 여러개의 값을 받을때 사용  -->
	<c:forEach var="i"  items="${str}">
		<p>${i}</p>
	</c:forEach>
</body>
</html>