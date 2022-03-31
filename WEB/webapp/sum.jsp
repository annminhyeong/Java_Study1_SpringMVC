<%@page import="kr.web.util.MyUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MyUtil myutil = new MyUtil();
	int sum= myutil.hap();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sum page</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>1~100까지의 총합</td>
			<td><%=sum %></td>
		</tr>
	</table>
</body>
</html>