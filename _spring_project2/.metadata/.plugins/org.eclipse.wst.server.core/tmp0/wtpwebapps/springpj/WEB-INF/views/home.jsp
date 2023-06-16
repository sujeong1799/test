<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<html>
<head>
<title>Home</title>
</head>
<body style="color: black;">


	<div style="width: 900px; margin: 0 auto;">
		<img alt="없음" src="/resources/고양이.gif" style="width: 900px;">
		<div align="center">
			<br>
			<a href="/mem/login"><button type="button" class="btn btn-outline-secondary">LOGIN</button></a>
			<a href="/mem/signup"><button type="button" class="btn btn-outline-secondary">JOIN</button></a>
		</div>
	</div>

	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}"/>`;
		const msg_logout = `<c:out value="${msg_logout}"/>`;

		console.log(msg_login);
		console.log(msg_logout);

		if (msg_login == '0') {
			alert("로그인에 실패했습니다.");
		}
		if (msg_logout == '1') {
			alert("로그아웃되었습니다.")
		}
	</script>

	<jsp:include page="./layout/footer.jsp"></jsp:include>

</body>
</html>
