<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 700px;">
		<form action="/board/modify?bno=${bvo.bno }" method="post">

			<table class="table table-bordered">
				<tr>
					<th>글 번호</th>
					<td><input name="bno" value="${bvo.bno }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input name="title" value="${bvo.title }"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input name="content" value="${bvo.content }"></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${bvo.read_count }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${bvo.reg_date }</td>
				</tr>
			</table>
			<button type="submit">수정완료</button>
			</form>
	</div>
</body>
</html>