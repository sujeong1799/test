<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CSS only -->
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
<title>NewSpider</title>
</head>
<body style="color: white; background-color: black;">
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="reginput">
		<form action="/board/register" method="post"
			enctype="multipart/form-data">

			<table style="border: none;">
				<tr style="margin-top: 30px;">
					<th style="width: 100px;">제목</th>
					<td><input class="singtd2" type="text" name="title"
						placeholder="제목을 입력해주세요."></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input class="singtd2" type="text" name="writer"
						value="${ses.id }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="noresize" rows="10" cols="49"
							name="content" placeholder="내용을 입력해주세요."></textarea></td>
				</tr>
				<tr>
					<!-- 파일 등록 라인 -->
					<th>첨부파일</th>
					<td><input type="file" id="file" name="files" multiple
						style="display: none;"> <a><button type="button"
								id="trigger" class="btn btn-light">FileUpload</button></a><br>
						<div id="fileZone"></div></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button id="regBtn" type="submit" class="btn text-white"
					style="background-color: DarkRed">등록</button>
			</div>
		</form>
	</div>
	<div class="regbox"></div>
	<div class="regback">
		<img alt="없음" src="/resources/스파이더단체.jpg"
			style="width: 1400px; height: 800px; border-radius: 50px;">
	</div>
	
	<script type="text/javascript">
		const bnoVal = '<c:out value="${boardDTO.bvo.bno}" />';
		console.log("bno > " + bnoVal);
	</script>
	<script type="text/javascript" src="/resources/js/boardRegister.js"></script>
	<script type="text/javascript" src="/resources/js/boardModify.js"></script>
	
</body>
</html>