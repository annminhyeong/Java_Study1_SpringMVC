<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberContent page</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	function goList() {
		location.href="${ctx}/memberList.do";
	}
</script>
</head>
<body>
<p>MVC06</p>
<c:choose>
	<c:when test="${sessionScope.id == requestScope.vo.id}">
		<p>${sessionScope.name}님의 상세화면</p>
	</c:when>
	<c:otherwise>
		<p>안녕하세요</p>
	</c:otherwise>
</c:choose>
<form action='${ctx}/memberUpdate.do' name='form1' method='post'>
<input type='hidden' name='num' value='${vo.num}'>
<table border="1">
	<tr>
		<td>번호</td>
		<td>${vo.num}</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${vo.id}</td>
	</tr>
		<tr>
		<td>비밀번호</td>
		<td>${vo.pass}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${vo.name}</td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type='text' name='age' value='${vo.age}'></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type='text' name='email' value='${vo.email}'></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type='text' name='phone' value='${vo.phone}'></td>
	</tr>
	<tr>
		<td>
			<c:choose>
				<c:when test="${sessionScope.id == requestScope.vo.id}">
					<input type='submit' value='수정'>
				</c:when>
				<c:otherwise>
					<input type='submit' value='수정' disabled="disabled">
				</c:otherwise>
			</c:choose>
			<input type='reset' value='취소'>
			<input type="button" value="뒤로" onclick="goList()">		
		</td>
	</tr>

</table>
</form>
</body>
</html>