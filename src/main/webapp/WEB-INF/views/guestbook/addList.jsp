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
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">

<script>
	function valiaddForm() {
		var name = document.forms["addList"]["name"].value;
		var password = document.forms["addList"]["pwd"].value;
		var content = document.forms["addList"]["content"].value;
		
		if (name === "") {
			alert("이름을 입력해주세요.");
			return false;
		}
		if (password === "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		if (content === "") {
			alert("내용을 입력해주세요.");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp" />
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //nav -->

		<div id="aside">
			<h2>방명록</h2>
			<ul>
				<li><a href="${pageContext.request.contextPath}/guestbook/guestBookForm">일반방명록</a></li>
				<li><a href="${pageContext.request.contextPath}/apiguestbook/guestBookForm">ajax방명록</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>일반방명록</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>방명록</li>
						<li class="last">일반방명록</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="guestbook">
				<form action="./addList" method="get" name="addList" onsubmit="return valiaddForm()">
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label>
								</td>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">패스워드</label>
								</td>
								<td><input id="input-pass" type="password" name="pwd"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4"><button type="submit">등록</button></td>
							</tr>
						</tbody>

					</table>
					<!-- //guestWrite -->
					<input type="hidden" name="action" value="add">

				</form>
				<c:forEach var="list" items="${guestBookList}">
					<table class="guestRead">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td>${list.boardId}</td>
							<td>${list.name}</td>
							<td>${list.regDate}</td>
							<td><a
								href="${pageContext.request.contextPath}/guestbook/deleteForm?boardId=${list.boardId}">[삭제]</a></td>
						</tr>
						<tr>
							<td colspan="4" class="text-left">${list.content}</td>
						</tr>
					</table>
				</c:forEach>
				<!-- //guestRead -->
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>