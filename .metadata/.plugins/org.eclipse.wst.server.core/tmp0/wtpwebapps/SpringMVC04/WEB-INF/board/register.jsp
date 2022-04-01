<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value=''/>" method="post">
	<table border="1">
		<tr>
			<td>글제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		
		<tr>
			<td>글내용</td>
			<td><textarea rows="3" name="contents"></textarea></td>
		</tr>
		
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer"></td>
		</tr>
		
		<tr>
			<td><input type="submit"></td>
			<td><input type="reset"></td>
		</tr>
	</table>
</form>
</body>
</html>