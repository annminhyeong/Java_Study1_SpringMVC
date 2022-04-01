<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</head>
<body>
<p>SpringMVC04</p>


	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성자</td>
			<td>등록일</td>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.idx}</td>
				<td><a href="<c:url value='/read.do?idx=${vo.idx}'/>">${vo.title}</a></td>
				<td>${vo.count}</td>
				<td>${vo.writer}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.indate}"/></td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="<c:url value='/register.do'/>">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>