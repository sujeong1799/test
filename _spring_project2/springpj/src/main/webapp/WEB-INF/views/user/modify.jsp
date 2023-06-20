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
<title>Insert title here</title>
</head>
<body>


	<div class="editAll">
	<br>
		<form action="/mem/modify" method="post">

			<table style="border: none; color: white;">
				<tr>
					<th style="width: 100px;">아이디</th>
					<td><input type="text" name="id" value="${ses.id }" readonly="readonly"
						class="singtd"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw"
						placeholder="비밀번호를 입력해주세요." class="singtd"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${uvo.name }" readonly="readonly"
						class="singtd"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birth" value="${uvo.birth }" readonly="readonly"
						class="singtd"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${uvo.email }"
						class="singtd"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="home" value="${uvo.home }"
						class="singtd"></td>
				</tr>
			</table>
			<br>
			<div style="margin-left: 130px;">
			<button type="submit" class="btn text-white" style="background-color: DarkRed">회원정보수정</button>
			</div>
		</form>
	</div>
	<div class="editbox"></div>
	<div class="editpic">
		<img alt="없음" src="/resources/그림스파이더.jpg"
			style="width: 100%; height: 80%; border-radius: 50px;">
	</div>
</body>
</html>