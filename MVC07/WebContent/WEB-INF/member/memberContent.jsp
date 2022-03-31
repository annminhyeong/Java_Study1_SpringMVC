<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberContent page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">

	function update() {
		if($("#file").val() != ''){
			//formData는 브라우저에서 지원하는 클래스다
			var formData = new FormData();
			//append함수는 formData에 append("이름" , 값 )으로 추가해준다
			//input 타입의 name이 file인것을 찾고 파일선택 버튼 file[0]번째 파일을 찾고 files[0]번째 파일을 가져온다. 
			formData.append("file", $("input[name=file]")[0].files[0]);
			
			$.ajax({
				url : "<c:url value='/fileAdd.do' />",
				type : "post",
				data : formData,
				//file 업로드의 경우 processData, contentType을 false로 해야함
				//processData는 ture면 QueryString 형태로 서버한테 전달되는데
				//파일 전송의 경우는 QueryString 형태로 보내면 안되므로 false
				processData : false,
				//리턴 받을 타입
				contentType : false,
				
				//성공하면 업로드한 실제 파일 이름을 파라미터로 받음
				success : function (data) {
					//alert(data);
					$("#filename").val(data);
					//form name이 form1의 actin을 지정
					document.form1.action="<c:url value='/memberUpdate.do'/>?mode=fupdate"; //파일이 있는 경우
					//form name이 form1것을 제출
					document.form1.submit();
				},
				error : function() { alert("error");}
			});
			
			
		}else{
			//form name이 form1의 actin을 지정
			document.form1.action="<c:url value='/memberUpdate.do' />mode=update"; //파일이 없는 경우
			//form name이 form1것을 제출
			document.form1.submit;
		}
	}
	function goList() {
		location.href="${ctx}/memberList.do";
	}
	
	function getFile(filename) {
		location.href="<c:url value='/fileGet.do'/>?filename="+ filename;
	}
	
	function delFile(num, filename) {
		location.href="<c:url value='/fileDel.do'/>?num="+num+"&filename="+ filename;
	}
</script>
</head>
<body>
<p>MVC07</p>
<c:choose>
	<c:when test="${sessionScope.id == requestScope.vo.id}">
		<img src="<c:url value='/file_repo/${vo.filename}'/>" width="60px" height="60px">
		${sessionScope.name}님의 상세화면
	</c:when>
	<c:otherwise>
		<p>안녕하세요</p>
	</c:otherwise>
</c:choose>
<form action='${ctx}/memberUpdate.do' name='form1' method='post'>
<input type='hidden' name='num' value='${vo.num}'>
<table border="1">
	<tr>
		<td>번호</td>
		<td>${vo.num}</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>${vo.id}</td>
	</tr>
		<tr>
		<td>비밀번호</td>
		<td>${vo.pass}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${vo.name}</td>
	</tr>
	<tr>
		<td>나이</td>
		<td><input type='text' name='age' value='${vo.age}'></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type='text' name='email' value='${vo.email}'></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type='text' name='phone' value='${vo.phone}'></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td>
			<input type="file" id="file" name="file" >
			<input type="hidden" id="filename" name="filename" value="">
			<c:if test="${vo.filename != null && vo.filename != ''}">
				<br><a href="javascript:getFile('${vo.filename}')"><c:out value="${vo.filename}"/></a>
			</c:if>
			<c:if test="${sessionScope.id == requestScope.vo.id && vo.filename != null}">
				<input type="button" value="x" onclick="delFile('${vo.num}','${vo.filename}')">
			</c:if>
		</td>
		
	</tr>
	<tr>
		<td>
			<c:choose>
				<c:when test="${sessionScope.id == requestScope.vo.id}">
					<input type="button" value='수정' onclick="update()">
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<input type='reset' value='취소'>
			<input type="button" value="뒤로" onclick="goList()">		
		</td>
	</tr>

</table>
</form>
</body>
</html>