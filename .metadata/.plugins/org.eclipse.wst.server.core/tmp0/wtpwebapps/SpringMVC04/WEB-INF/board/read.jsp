<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</head>
<body>
<p>SpringMVC04</p>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td><input type="text" name="title" value="${vo.idx}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><input type="text" name="title" value="${vo.title}" readonly="readonly"></td>
		</tr>
		
		<tr>
			<td>글내용</td>
			<td><textarea rows="3" name="contents" readonly="readonly">${vo.contents}</textarea></td>
		</tr>
		
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="${vo.writer}" readonly="readonly"></td>
		</tr>
		
		<tr>
			<td><a href="<c:url value='/modify.do'/>?idx=${vo.idx}">수정하기</a></td>
			<td><a href="<c:url value='/list.do'/>">뒤로가기</a></td>
		</tr>
	</table>
</body>
</html>