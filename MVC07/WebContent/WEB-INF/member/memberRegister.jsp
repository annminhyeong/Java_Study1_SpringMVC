<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberRegister page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
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
	
	function add2() {
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
					document.form1.action="<c:url value='/memberInsert.do'/>?mode=fadd"; //파일이 있는 경우
					//form name이 form1것을 제출
					document.form1.submit();
				},
				error : function() { alert("error");}
			});
			
			
		}else{
			//form name이 form1의 actin을 지정
			document.form1.action="<c:url value='/memberInsert.do' />mode=add"; //파일이 없는 경우
			//form name이 form1것을 제출
			document.form1.submit;
		}
	}
	
	function doubleCheck() {
		var id = $('#id').val();
		if(id == ''){
			alert("아이디를 입력하세요");
			('#id').focus();
			return;
		}
		
		//서버랑 통신할때 사용하는 함수는 $.ajax({})
		$.ajax({
			//controller에 보낼 요청 url
			url : "<c:url value='/memberDbCheck.do' />",
			
			//type은 get인지 post인지 지정
			type : "POST",
			
			//서버로 넘기는 데이터 값 
			//data : {"이름1" : 값1},{이름2 : 값2})
			data : {"id" : id},
			
			//요청이 성공하면 success
			//성공한다음 처리할려면 콜백함수명 지정
			success : dbCheck,
			
			//요청 실패 실패시
			error : function(){ alert("error"); }
			
		});
		
		//요청성공후 처리후 서버에서 오는 데이터는 파라미터로 받음
		function dbCheck(data) {
			if(data !="NO"){
				alert("중복된 아이디입니다.");
				('#id').focus();
			}else{
				alert("사용가능한 아이디입니다.");
				('#id').focus();
			}
		}
		
	}
</script>
</head>
<body>
<p>MVC07</p>
<p>회원가입 화면</p>
<form name="form1" method='post'>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type='text' name='id' id="id">
				<input type="button" value="중복체크" onclick="doubleCheck()">
			</td>
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
			<td>첨부파일</td>
			<td>
				<input type="file" id="file" name="file">
				<input type="hidden" id="filename" name="filename" value="">
			</td>
		</tr>
		
		<tr>
			<td>
				<c:choose>
					<c:when test="${sessionScope.id != null}">
					</c:when>
					<c:otherwise>
						<input type="button" value='제출' onclick='add2()'>
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