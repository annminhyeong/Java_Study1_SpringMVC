<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl04 page</title>
</head>
<body>
	<!-- c:forEach문은 for문으로 사용 -->
	<!-- var에는 증가시킬 변수명 정의 -->
	<!-- begin는 시작값 -->
	<!-- end는 끝값 -->
	<!-- step은 증가값 -->
	<c:forEach var="i" begin="1" end="5" step="1">
		<font size="${i}">jstl for문 테스트</font><br>
	</c:forEach>
	
	
</body>
</html>