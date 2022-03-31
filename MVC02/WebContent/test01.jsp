<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--함수 선언할때는 '<%!' 로 선언해야함 --%>
<%!
	public int hap(int s, int e) {
		
		int sum = 0;
	
		for(int i=s; i<=e; i++) {
			sum += i;
		}
		return sum;
	}
%>
<%
	int sumTest =0;
	for(int i=0; i<100; i++){
		sumTest +=i;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01 page</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>5~55까지 총합</td>
			<td><%=hap(5, 55)%></td>
		</tr>
		
		<tr>
			<td>1~100까지 총합</td>
			<td><%=hap(1, 100)%></td>
		</tr>
	</table>
</body>
</html>