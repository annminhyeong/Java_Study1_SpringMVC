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
	function deleteFunc(num) {
		location.href="${ctx}/memberDelete.do?num="+num;
	}
	
	function memberList() {
		if($('#memberList').css('display') == 'none'){
			$.ajax({
				url : "<c:url value='/memberAjaxList.do'/>",
				type : "get",
				dataType : "json",
				success : resultHtml,
				error : function () { alert("에러"); }
			});
			
			$('#memberList').show();
		}else{
			$('#memberList').hide();
		}
	}
	
	function resultHtml(data) {
		console.log(JSON.stringify(data));
		var html = "<table border='1'>";
		html +="<thead>";
		html +="<tr>";
		html +="<th>번호</th>";
		html +="<th>아이디</th>";
		html +="<th>비밀번호</th>";
		html +="<th>이름</th>";
		html +="<th>나이</th>";
		html +="<th>이메일</th>";
		html +="<th>전화번호</th>";
		html +="<th>삭제</th>";
		html +="</tr>";
		html +="</thead>";
		html +="<tbody>";
		//반복문 처리 $.each문 반목문이 동작될따 
		//data에서 데이터를 하나 꺼내서 파라미터 순서대로 전달
		$.each(data, function(index, obj) {	
			html +="<tr>";
			html +="<td>"+obj.num+"</td>";
			html +="<td>"+obj.id+"</td>";
			html +="<td>"+obj.pass+"</td>";
			html +="<td>"+obj.name+"</td>";
			html +="<td>"+obj.age+"</td>";
			html +="<td>"+obj.email+"</td>";
			html +="<td>"+obj.phone+"</td>";
			html +="<td><input type='button' value='삭제' onclick='delFn("+obj.num+")'></td>";
			html +="</tr>";
		});
		html +="</tbody>";
		html +="</table>";
		$("#memberList").html(html);
	}
</script>
</head>
<p>SpringMVC03</p>
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
	<a onclick="memberList()">회원리스트 보기</a>
	<div id="memberList"></div>
</body>
</html>