<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
</head>
<body>
<h1>SignUp Page</h1>

<form action="/member/signup" method="post">
	아이디 : <input type="text" name="id" placeholder="아이디 입력"><br>
	비밀번호 : <input type="password" name="pw" placeholder="비밀번호 입력"><br>
	이름 : <input type="text" name="name" placeholder="이름 입력"><br>
	메일 : <input type="text" name="email" placeholder="이메일 입력"><br>
	주소 : <input type="text" name="home" placeholder="주소 입력"><br>
	나이 : <input type="text" name="age" placeholder="나이 입력"><br>
	<button>등록</button>
</form>
</body>
</html>