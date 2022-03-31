<%@page import="java.io.PrintWriter"%>
<%@page import="kr.bit.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 1.클라이언트 요청 받음

// 2. 회원 전체리스트 가져오기(Model연동)
MemberDAO dao = new MemberDAO();
ArrayList<MemberVO> list = dao.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList page</title>

<script type="text/javascript">
	function deleteFunc(num) {
		location.href="memberDelete.jsp?num="+num;
	}
</script>
</head>
<body>
<p>MVC02</p>
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
		<%for(MemberVO vo : list){ %>
			<tr>
				<td><%=vo.getNum() %></td>
				<td><a href="memberContent.jsp?num=<%=vo.getNum()%>"><%=vo.getId() %></a></td>
				<td><%=vo.getPass() %></td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getAge() %></td>
				<td><%=vo.getEmail() %></td>
				<td><%=vo.getPhone() %></td>
				<td><input type="button" value="삭제" onclick="deleteFunc(<%=vo.getNum()%>)"></td>
			</tr>
		<%} %>
		</tbody>
		<tr>
			<td colspan='8' align='right'>
				<a href='memberRegister.jsp'>회원가입</a>
			</td>
		</tr>
	</table>
</body>
</html>