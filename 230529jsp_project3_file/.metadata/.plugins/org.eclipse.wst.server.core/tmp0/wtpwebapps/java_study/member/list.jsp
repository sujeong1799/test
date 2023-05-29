<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<table  class="table table-hover">
		<thead class="table-light">
			<tr>
				<td>아이디</td>
				<td>이메일</td>
				<td>생년월일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.id }</td>
				<td>${list.email }</td>
				<td>${list.birth }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center">
	<a href="/"><button>메인가기</button></a>
	</div>
</body>
</html>