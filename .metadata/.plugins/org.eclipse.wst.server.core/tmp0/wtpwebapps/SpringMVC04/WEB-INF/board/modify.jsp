<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</head>
<body>
<p>SpringMVC04</p>
<form action="<c:url value='/modify.do'/>" method="post">
	<table border="1">
		<tr>
			<td>글번호</td>
			<td><input type="text" name="idx" value="${vo.idx}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><input type="text" name="title" value="${vo.title}"></td>
		</tr>
		
		<tr>
			<td>글내용</td>
			<td><textarea rows="3" name="contents">${vo.contents}</textarea></td>
		</tr>
		
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="${vo.writer}" readonly="readonly"></td>
		</tr>
		
		<tr>
			<td><input type="submit"></td>
			<td><input type="reset"><a href="<c:url value='/remove.do'/>?idx=${vo.idx}">삭제하기</a></td>	
		</tr>
	</table>
</form>
</body>
</html>