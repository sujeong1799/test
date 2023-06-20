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
<title>JOIN</title>
</head>
<body style="color: white;">

	<div class="joinAll" align="center">
	<hr>
		<form action="/mem/signup" method="post">
			<table style="border: none;">
				<tr>
					<th style="width: 100px;" >아이디</th>
					<td><input type="text" name="id" placeholder="아이디를 입력해주세요." class="singtd"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" placeholder="비밀번호를 입력해주세요." class="singtd"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" placeholder="이름을 입력해주세요." class="singtd"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birth" placeholder="예: 20230616" class="singtd"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" placeholder="예: spring@gmail.com" class="singtd"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="home" placeholder="주소를 입력해주세요." class="singtd"></td>
				</tr>
			</table>
			<hr>
			<div align="center">
			<button type="submit" class="btn btn-outline-light">등록</button>
			</div>
		</form>
	</div>
	<div class="joinbox">
	</div>
	<div class="joinpic">
	<img alt="없음" src="/resources/그림스파이더.jpg" style="width: 100%; height: 80%; border-radius: 50px;">
	</div>
	
</body>
</html>