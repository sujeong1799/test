<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<html>
<head>
<title>Home</title>
</head>
<body style="background-image: url('/resources/치히로.jpg'); background-size: cover; background-repeat: no-repeat;">
	<jsp:include page="./layout/header.jsp"></jsp:include>

	<h1 align="center" style="margin-top: 180px; margin-left: 150px; color: white">Hello world!</h1>

	<div align="center">
		<c:if test="${ses.id != null}">
			<a href="/member/logout"><button type="button">로그아웃</button></a><br>
		<br>
		<a href="/board/register"><button type="button">글 등록</button></a>
		<a href="/board/list"><button type="button">글 목록</button></a>
		</c:if>
	</div>
	<div style="width: 300px; margin-top: 30px; margin-left: 900px;" >
		<c:if test="${ses.id == null}">
		
			<a href="/member/signup"><button type="button" class="btn btn-dark">회원가입</button></a>
			<a href="/member/login"><button type="button" class="btn btn-dark">로그인</button></a><br>
			<!-- a태그는 무조건 get방식이라서 컨트롤러에서 getMappter만들어줘야한다. -->
		</c:if>
	</div>



	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}"/>`;
		const msg_logout = `<c:out value="${msg_logout}"/>`;
		console.log(msg_login);
		console.log(msg_logout);
		if (msg_login == '1') {
			alert("어서오세영")
		}

		if (msg_logout == '1') {
			alert("로그아웃되었습니다.")
		}
	</script>


	<jsp:include page="./layout/footer.jsp"></jsp:include>
</body>
</html>
