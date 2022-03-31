<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList page</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	function deleteFunc(num) {
		location.href="${ctx}/memberDelete.do?num="+num;
	}
</script>
</head>
<p>SpringMVC01</p>
<body>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.num}</td>
				<td><a href="${ctx}/memberContent.do?num=${vo.num}">${vo.id}</a></td>
				<td>${vo.pass}</td>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
				<td>${vo.email}</td>
				<td>${vo.phone}</td>
				<td><input type="button" value="삭제" onclick="deleteFunc(${vo.num})"></td>
			</tr>
		</c:forEach>
		</tbody>
		<tr>
			<td colspan='8' align='right'>
				<a href='${ctx}/memberRegister.do'>회원가입</a>
			</td>
		</tr>
	</table>
</body>
</html>