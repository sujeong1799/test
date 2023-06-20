<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body class="detailpic">

	<jsp:include page="../layout/header.jsp"></jsp:include>


	<div class="modifyAll">
		<c:set var="bvo" value="${boardDTO.bvo }"></c:set>
		<form action="/board/modify?bno=${bvo.bno }" method="post"
			enctype="multipart/form-data">
			<table class="table" style="border-color: gray; color: white;">
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
					<th>작성일</th>
					<td>${bvo.reg_date }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${bvo.read_count }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input name="content" value="${bvo.content }"></td>
				</tr>
				<tr>
					<!-- 파일 등록 라인 -->
					<th>첨부파일</th>
					<td><input type="file" id="file" name="files" multiple
						style="display: none;"> <a><button type="button"
								id="trigger" class="btn btn-light">FileUpload</button></a><br>
						<div id="fileZone"></div></td>
				</tr>
			</table >
			<!-- 파일 표시 라인 -->
			<c:set var="flist" value="${boardDTO.flist }"></c:set>
			<div>

				<ul>
					<c:forEach items="${flist }" var="fvo">
						<li><c:choose>
								<c:when test="${fvo.file_type > 0}">
									<div>
										<img alt="없음"
											src="/upload/${fn: replace(fvo.save_dir,'\\','/')}/${fvo.uuid }_th_${fvo.file_name}">
											
									</div>
								</c:when>
							</c:choose>
							<div style="color: white;">
							${fvo.file_name }
							<button type="button" class="file-x btn btn-outline-light" data-uuid="${fvo.uuid }">파일삭제</button></div>
						</li>
						<br>
					</c:forEach>
				</ul>
			</div>
			<br>
			<div align="center">
				<button id="regBtn" type="submit" class="btn text-white" style="background-color: DarkRed" >수정완료</button>
			</div>
		</form>
	</div>
	
	<div class="modifybox"></div>
	<script type="text/javascript">
		const bnoVal = '<c:out value="${boardDTO.bvo.bno}" />';
		console.log("bno > " + bnoVal);
	</script>
	<script type="text/javascript" src="/resources/js/boardRegister.js"></script>
	<script type="text/javascript" src="/resources/js/boardModify.js"></script>


</body>
</html>