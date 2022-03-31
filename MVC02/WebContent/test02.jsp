<%@page import="kr.bit.model.MyCalc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--두수차이의 총합 --%>
<%
	MyCalc c = new MyCalc();
	int su1 =1;
	int su2 =1000;
	int sum =c.hap(su1, su2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test02 page</title>
</head>
<body>
	<table border="1">
		<tr>
			<td><%=su1%>부터<%=su2%>까지 합</td>
			<td><%=sum%></td>
		</tr>
	</table>
</body>
</html>