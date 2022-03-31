<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl02 page</title>
</head>
<body>

	<c:set var="cnt" value="3" />
	
	
	<!-- c:if 태크는 if문으로 사용  else문은 지원하지 않음 -->
	<!-- test에 조건문 사용 -->
	<c:if test="${cnt%2==0}">
		<p>짝수입니다</p>
	</c:if>
	<c:if test="${cnt%2!=0}">
		<p>홀수입니다</p>
	</c:if>
	

</body>
</html>