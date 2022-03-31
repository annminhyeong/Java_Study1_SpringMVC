<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberRegister page</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	function goList() {
		location.href="${ctx}/memberList.do"; 
	}
	
	function formReset() {
		document.form1.reset();
	}
	
	function add() {
		document.form1.action="<c:url value='/memberInsert.do'/>"; //jstl 태그 사용시 contextPath 안적어도 됨
		document.form1.submit();
	}
</script>
</head>
<body>
<p>MVC06</p>
<p>회원가입 화면</p>
<form name="form1" method='post'>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type='text' name='id'></td>
		</tr>

		<tr>
			<td>비밀번호</td>
			<td><input type='text' name='pass'></td>
		</tr>

		<tr>
			<td>이름</td>
			<td><input type='text' name='name'></td>
		</tr>

		<tr>
			<td>나이</td>
			<td><input type='text' name='age'></td>
		</tr>

		<tr>
			<td>이메일</td>
			<td><input type='text' name='email'></td>
		</tr>

		<tr>
			<td>전화번호</td>
			<td><input type='text' name='phone'></td>
		</tr>

		<tr>
			<td>
				<c:choose>
					<c:when test="${sessionScope.id != null}">
					</c:when>
					<c:otherwise>
						<input type="button" value='제출' onclick='add()'>
					</c:otherwise>
				</c:choose>				
				<input type="button" value='취소' onclick='formReset()'>
				<input type="button" value='뒤로' onclick='goList()'>
			</td>
		</tr>
	</table>
</form>
</body>
</html>