<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
<style>
#btn_write2 {
	border: 1px solid #A6A6A6;
	border-radius: 2px;
	background-color: #E5E5E5;
	padding: 5px 10px 5px 10px;
	font-size: 14px;
	float: right;
	margin-left: 10px;
}
</style>

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp" />
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //nav -->

		<div id="aside">
			<h2>게시판</h2>
			<ul><li><a href="${pageContext.request.contextPath}/board/list">일반게시판</a></li>
				<li><a href="${pageContext.request.contextPath}/rboard/list">댓글게시판</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>게시판</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>게시판</li>
						<li class="last">일반게시판</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="read">
					<form action="#" method="get">
					
						<!-- 작성자 -->
						<div class="form-group">
							<span class="form-text">작성자</span> <span class="form-value">${rboard.name}</span>
						</div>

						<!-- 조회수 -->
						<div class="form-group">
							<span class="form-text">조회수</span> <span class="form-value">${rboard.hit}</span>
						</div>

						<!-- 작성일 -->
						<div class="form-group">
							<span class="form-text">작성일</span> <span class="form-value">${rboard.regDate}</span>
						</div>

						<!-- 제목 -->
						<div class="form-group">
							<span class="form-text">제 목</span> <span class="form-value">${rboard.title}</span>
						</div>

						<!-- 내용 -->
						<div id="txt-content">
							<pre class="form-value">${rboard.content} </pre>
						</div>
						<c:if test="${user.no == rboard.userNo }">
							<a id="btn_modify"
								href="./modifyForm?no=${rboard.no}&userNo=${rboard.userNo}">수정</a>
						</c:if>
						<a id="btn_modify" href="./list">목록</a>
						<c:choose><c:when test="${rboard.depth < 2}">
						<a id="btn_write2" href="./rwriteForm/2?no=${rboard.no}">댓글쓰기</a>
						</c:when></c:choose> 
					</form>
					<!-- //form -->
				</div>
				<!-- //read -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
