<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
<h1>login Page</h1>

<form action="/member/login" method="post">
id : <input type="text" name="id" placeholder="아이디를 입력해주세요"><br>
password : <input type="password" name="pw" placeholder="비밀번호를 입력해주세요"><br>
<button type="submit">login</button>
</form>

</body>
</html>