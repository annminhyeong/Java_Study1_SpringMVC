<%@page import="kr.bit.model.MemberVO"%>
<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
int num =Integer.parseInt(request.getParameter("num"));
MemberDAO dao = new MemberDAO();

MemberVO vo = dao.memberContent(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberContent page</title>

<script type="text/javascript">
	function goList() {
		location.href="memberList.jsp";
	}
</script>
</head>
<body>
<p>MVC02</p>
<form action='memberUpdate.jsp' name='form1' method='post'>
	<input type='hidden' name='num' value='<%=vo.getNum() %>'>
<table border="1">
	<tr>
		<td>번호</td>
		<td><%=vo.getNum() %></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=vo.getId() %></td>
	</tr>
		<tr>
		<td>비밀번호</td>
		<td><%=vo.getPass() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=vo.getName() %></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type='text' name='age' value='<%=vo.getAge()%>'></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type='text' name='email' value='<%=vo.getEmail()%>'></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type='text' name='phone' value='<%=vo.getPhone()%>'></td>
	</tr>
	<tr>
		<td>
			<input type='submit' value='수정'>
			<input type='reset' value='취소'>
			<input type="button" value="뒤로" onclick='goList()'>		
		</td>
	</tr>
</table>
</form>
</body>
</html>