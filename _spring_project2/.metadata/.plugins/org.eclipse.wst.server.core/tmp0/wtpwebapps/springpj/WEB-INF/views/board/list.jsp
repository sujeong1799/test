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

	<div class="listall">
		<!-- 검색라인 -->
		<form action="/board/list" method="get">
			<div align="center">
				<c:set value="${ph.pgvo.type }" var="typed"></c:set>
				<select name="type">
					<option ${typed == null ? 'selected' : '' }>선택</option>
					<option value="t" ${type eq 't' ? 'selected' :'' }>제목</option>
					<option value="w" ${type eq 'w' ? 'selected' :'' }>작성자</option>
					<option value="n" ${type eq 'n' ? 'selected' :'' }>글번호</option>
					<option value="c" ${type eq 'c' ? 'selected' :'' }>내용</option>
				</select> <input type="text" name="keyword" placeholder="search" class="search">
				<input
					type="hidden" name="pageNo" value="${ph.pgvo.pageNo }"> <input
					type="hidden" name="qty" value="${ph.pgvo.qty }">
				<button type="submit" class="btn btn-outline-light">Search</button>
			</div>
		</form>

		<div style="width: 550px; margin: 0px auto;">
			<table class="table" style="border-color: gray; color: white;">
				<thead>
					<tr align="center">
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:forEach items="${list }" var="bvo">
						<tr align="center">
							<th>${bvo.bno }</th>
							<td><a href="/board/detail?bno=${bvo.bno }" class="listA">${bvo.title }</a></td>
							<td>${bvo.writer }</td>
							<td>${bvo.read_count }</td>
							<td>${bvo.reg_date }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div align="center">
				<a href="/board/register"><button type="button" class="btn text-white" style="background-color: DarkRed">글 등록</button></a> <a
					href="/mem/home2"><button type="button" class="btn text-white" style="background-color: DarkRed">메인가기</button></a> <br>
			</div>
			<br>
			<!-- 페이징처리 -->
			<div style="display: table; margin-left: auto; margin-right: auto;">
				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<c:if test="${ph.prev }">
							<li class="page-item"><a class="page-link text-white" style="background-color: DarkRed"
								href="/board/list?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
							<li class="page-item"><a class="page-link text-white" style="background-color: DarkRed"
								href="/board/list?pageNo=${i }&qty=${ph.pgvo.qty}">${i }</a></li>
						</c:forEach>

						<c:if test="${ph.next }">
							<li class="page-item"><a class="page-link text-white" style="background-color: DarkRed"
								href="/board/list?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}">&raquo;</a></li>
						</c:if>
					</ul>
				</nav>
			</div>


		</div>
	</div>
	<div class="listbox"></div>
	<div class="listpic">
		<img alt="없음" src="/resources/리스트벽화.jpg"
			style="width: 1400px; height: 800px; border-radius: 50px;">
	</div>


</body>
</html>