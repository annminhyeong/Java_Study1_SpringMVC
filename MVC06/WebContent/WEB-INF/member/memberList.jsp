<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(document).ready(function name() {
		<c:if test="${!empty msg}">
			alert("${msg}");
			<c:remove var="msg" scope="session" />
		</c:if>
	})
		
	function check() {
		
		if($('#id').val()==''){
			alert("아이디를 입력하세요");
			return false;
		}
		
		if($('#pass').val()==''){
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		return true;
	}
	
	function deleteFunc(num) {
		location.href="${ctx}/memberDelete.do?num="+num;
	}
	
	function logout() {
		location.href="<c:url value='memberLogout.do'></c:url>"; //jstl를 사용하면 ${ctx}를 안써도 됨
	}
</script>
</head>
<p>MVC06</p>
<body>
	<c:choose>
		<c:when test="${sessionScope.id == null || sessionScope.id == ''}">
		<p>로그인</p>
		<form action="${ctx}/memberLogin.do" method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="pass" id="pass"></td>
			</tr>
			<tr>
				<td><input type="submit" onclick="return check()"></td>
			</tr>
		</table>
		</form>
		</c:when>
		<c:otherwise>
			<p>${sessionScope.name}님 환영합니다</p><input type="button" value="로그아웃" onclick="logout()">
		</c:otherwise>
	</c:choose>
	
	<p>회원관리</p>
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
		<c:forEach var="vo" items="${requestScope.list}">
			<tr>
				<td>${vo.num}</td>
				<td><a href="${ctx}/memberContent.do?num=${vo.num}">${vo.id}</a></td>
				<td>${vo.pass}</td>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
				<td>${vo.email}</td>
				<td>${vo.phone}</td>
				<c:choose>
					<c:when test="${sessionScope.id == vo.id}">
						<td><input type="button" value="삭제" onclick="deleteFunc(${vo.num})"></td>
					</c:when>
					<c:otherwise>
						<td><input type="button" value="삭제" disabled="disabled" onclick="deleteFunc(${vo.num})"></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
		<tr>
		<c:choose>
			<c:when test="${sessionScope.id != null}">
			</c:when>
			<c:otherwise>
				<td colspan='8' align='right'>
					<a href='${ctx}/memberRegister.do'>회원가입</a>
				</td>
			</c:otherwise>
		</c:choose>

		</tr>
	</table>
</body>
</html>