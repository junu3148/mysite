<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/main.css"
	rel="stylesheet" type="text/css">
<style>
</style>
</head>

<body>
	<div id="wrap">

		<!-- 해더 네비 -->
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //해더 네비 -->


		<div id="container" class="clearfix">
			<!-- 게시판 aside -->
			<c:import url="/WEB-INF/views/include/galleryAside.jsp" />
			<!-- //게시판 aside -->


			<div id="content">

				<div id="content-head">
					<h3>첨부파일연습</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">첨부파일연습</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->


				<div id="file">

					<c:forEach items="${files}" var="file">
						<div>
							<img class="resultImg" src="${pageContext.request.contextPath}${file}" style= "width: 200px; border: 1px solid black;  float: left; margin-right: 10px;">
						</div>
					</c:forEach>
					<p>
						<a id="btnUpload"
							href="${pageContext.request.contextPath }/fileupload/form">
							다시 업로드 하기 </a>
					</p>

				</div>
				<!-- //file -->

			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->


		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>