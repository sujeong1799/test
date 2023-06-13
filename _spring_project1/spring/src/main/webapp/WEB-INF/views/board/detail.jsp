<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글그르글</title>
</head>
<body>
	<h1>Board Detail Page</h1>
	<div style="width: 700px;">
		<table class="table table-bordered">
			<tr>
				<th>글 번호</th>
				<td>${bvo.bno }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bvo.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bvo.content }</td>
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

		<a href="/board/list"><button>목록</button></a>
		<!-- 로그인 i와 게시글의 작성자가 같지않으면 수정, 삭제버튼 안보이게 -->
		<c:if test="${ses != null && ses.id == bvo.writer }">
			<a href="/board/modify?bno=${bvo.bno }"><button>수정</button></a>
			<a href="/board/delete?bno=${bvo.bno }"><button>삭제</button></a>
		</c:if>
	</div>

<br>
	<!-- 댓글 라인 -->
	<div align="center">


		<!-- 댓글 작성 라인 -->
		<div>
			<span id="cmtWriter"> ${bvo.writer }</span> <input type="text"
				id="cmtText" placeholder="댓글을 적어주세요.">
			<button type="button" id="cmtPostBtn">등록</button>
		</div>


		<!-- 댓글 표시 라인 -->
		<div>
			<!-- li 하나가 하나의 댓글 객체 -->
			<ul id="cmtListArea" style="list-style: none;">
				<li>
					<div>
						<div >Writer</div> Content for Comment
					</div><span>mod_date</span>
				</li>
			</ul>
		</div>
	</div>


<script type="text/javascript">
const bnoVal = '<c:out value="${bvo.bno}" />';
console.log("bno > "+bnoVal);
</script>
<script type="text/javascript" src="/resources/js/boardComment.js"></script>
<script type="text/javascript">
getCommentList(bnoVal);
</script>

</body>
</html>