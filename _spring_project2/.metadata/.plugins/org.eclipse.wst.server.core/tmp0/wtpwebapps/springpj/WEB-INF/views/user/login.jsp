<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../resources/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body style="color: rgb(51, 51, 51);">

	<div style="width: 350px; height:300px; margin: 100px auto; border: 1px solid;">
		<div style="margin-top: 100px">
		<form action="/mem/login" method="post">
			<table style="border: none; ">
				<tr>
					<th style="width: 100px;" >아이디</th>
					<td><input type="text" name="id" placeholder="아이디를 입력해주세요." class="singtd"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" placeholder="비밀번호를 입력해주세요." class="singtd"></td>
				</tr>
			</table>
			<div align="center">
			<button type="submit" class="btn btn-outline-secondary">LOGIN</button>
			</div>
		</form>
		</div>
	</div>
	
		<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>