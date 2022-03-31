<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberRegister page</title>
</head>
<body>
<p>회원가입 화면</p>
<form action='memberInsert.jsp' method='post'>
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
			<td colspan='2' align='center'>
				<input type='submit' value='제출'>
				<input type='reset' value='취소'>
			</td>
		</tr>
	</table>
</form>
</body>
</html>