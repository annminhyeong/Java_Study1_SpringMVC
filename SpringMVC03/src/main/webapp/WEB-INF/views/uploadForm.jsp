<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
	var cnt =1;
	function file_add() {
		$('#d_file').append("<br>"+"<input type='file' name='file"+cnt+"'/>");
		cnt++;
		
		
	}
</script>
</head>
<body>
	<form action='<c:url value="/upload.do"/>' enctype="multipart/form-data" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		
		<tr>
			<td>파일추가</td>
			<td>
				<input type="button" value="파일 추가" onclick="file_add()"><br>
				<div id="d_file"></div>
			</td>
		</tr>
		
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
	</form>
</body>
</html>