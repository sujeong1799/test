<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
</head>
<body style="color: black;">

	<jsp:include page="./layout/header.jsp"></jsp:include>
	<div style="width: 700px; height: 100px; margin: 0 auto;"
		align="center">
		<h1>WITH ME</h1>
		<span>뭐 타구 여행갈거여?</span>
	</div>

	<div style="width: 700px; height: 700px; margin: 0 auto;">
		<div style="width: 350px; height: 350px; float: left; padding: 5px;">
			<img alt="없음" src="/resources/배.gif"
				style="width: 340px; height: 340px">
		</div>
		<div style="width: 350px; height: 350px; float: right; padding: 5px;">
			<a href="#"><img alt="없음" src="/resources/비행기.gif"
				style="width: 340px; height: 340px;"></a>
		</div>
		<div style="width: 350px; height: 350px; float: right; padding: 5px;">
			<img alt="없음" src="/resources/차.gif"
				style="width: 340px; height: 340px;">
		</div>
		<div style="width: 350px; height: 350px; float: left;">
			<img alt="없음" src="/resources/기차.gif"
				style="width: 350px; height: 350px">
		</div>
	</div>






	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}"/>`;
		console.log(msg_login);		
		if (msg_login == '1') {
			alert("${ses.id}님 반가워요!");
		}
	</script>

	<jsp:include page="./layout/footer.jsp"></jsp:include>

</body>
</html>