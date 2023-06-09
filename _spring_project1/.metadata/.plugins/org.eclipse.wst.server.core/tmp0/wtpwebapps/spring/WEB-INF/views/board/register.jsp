<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
<h1>Register Page</h1>
<form action="/board/register" method="post">
제목 : <input type="text" name="title" placeholder="제목을 입력해주세요"><br>
작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
내용 : <br>
<textarea rows="30" cols="50" name="content"></textarea><br>
<button type="submit">등록</button>
</form>
</body>
</html>