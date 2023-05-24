<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소원상세보기</title>
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<h1>D-DAY</h1>
		</thead>
		<tbody>
			<tr>
				<td>소원번호</td>
				<td>${bvo.bno }</td>
				<td>소원제목</td>
				<td>${bvo.title }</td>
			</tr>
			<tr >
				<td>ㄱㅆㅇ</td>
				<td>${bvo.writer}</td>
				<td>등록날짜</td>
				<td>${bvo.reg_date }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${bvo.read_count }</td>
				<td>조아요</td>
				<td>${bvo.like_count }</td>
			</tr>
			<tr>
				<td>소원내용</td>
				<td colspan="3">${bvo.content }</td>
			</tr>
		</tbody>
	</table>
	
	
	<div align="center">
	<br>
	<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly">
	<input type="text" id="cmtText" placeholder="댓글을 작성해주세요.">
	<button type="button" id="cmtAddBtn">댓글 등록</button>
	</div>
	<br>
	<hr>
	
	<!-- 댓글 나타나는 부분 -->
	<div class="accordion accordion-flush" id="accordionFlushExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="flush-headingOne">
				<button class="accordion-button collapsed" type="button"
					data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
					aria-expanded="false" aria-controls="flush-collapseOne">
					cno, writer</button>
			</h2>
			<div id="flush-collapseOne" class="accordion-collapse collapse"
				aria-labelledby="flush-headingOne"
				data-bs-parent="#accordionFlushExample">
				<div class="accordion-body">
				content, reg_date
				</div>
			</div>
		</div>
	</div>
	
	<div align="center">
	<a href="/brd/editPage?bno=${bvo.bno }"><button>소원수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno } "><button>소원삭제</button></a>
	<a href="/brd/page"><button>소원리스트</button></a>
	</div>
	
	<script type="text/javascript">
	/* resources - board_detail.js에서 bno값을 알 방법이 없음.. 그래서 bnoVal로 연결해줘야함 
	지금 우리가 있는 detail.jsp에 bno번호가 있으니까 훔쳐서 가져옴 */
	const bnoVal = `<c:out value = "${bvo.bno}"/>`;
	</script>
	
	<!-- 링크로 달때는 타입 없어도 됨, board_detail.jsp에 연결하겠다는 의미  -->
	<script src="/resources/board_detail.js"></script>
	<script type="text/javascript">
		printCommentList(bnoVal);
	</script>

</body>
</html>