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
<link href="${pageContext.request.contextPath}/assets/css/user.css"
	rel="stylesheet" type="text/css">

</head>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp" />
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //nav -->

		<div id="aside">
			<h2>회원</h2>
			<ul>
				<li>회원정보</li>
				<li>로그인</li>
				<li>회원가입</li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>회원가입</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>회원</li>
						<li class="last">회원가입</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="user">
				<div id="joinForm">
					<form action="./join" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">아이디</label> <input
								type="text" id="input-uid" name="id" value=""
								placeholder="아이디를 입력하세요">
							<button type="button" id="idCheck">중복체크</button>
							<br>
							<p id="idCheckMsg" align="center"></p>
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">패스워드</label> <input
								type="password" id="input-pass" name="password" value=""
								placeholder="비밀번호를 입력하세요">
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">이름</label> <input
								type="text" id="input-name" name="name" value=""
								placeholder="이름을 입력하세요">
						</div>

						<!-- //나이 -->
						<div class="form-group">
							<span class="form-text">성별</span> <label for="rdo-male">남</label>
							<input type="radio" id="rdo-male" name="gender" value="male">

							<label for="rdo-female">여</label> <input type="radio"
								id="rdo-female" name="gender" value="female">

						</div>

						<!-- 약관동의 -->
						<div class="form-group">
							<span class="form-text">약관동의</span> <input type="checkbox"
								id="chk-agree" value="" name=""> <label for="chk-agree">서비스
								약관에 동의합니다.</label>
						</div>

						<!-- 버튼영역 -->
						<div class="button-area">
							<button type="submit" id="btn-submit">회원가입</button>
						</div>

					</form>
				</div>
				<!-- //joinForm -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

<script>
	//아이디 체크 버튼 클릭
	$("#idCheck").on("click", function() {
		console.log("나오냐");

		//통신 id
		var id = $("[name=id]").val();
		console.log(id);

		$.ajax({

			url : "${pageContext.request.contextPath}/user/idCheck",
			type : "post",
			//contentType : "application/json",
			data : {
				id : id
			},

			dataType : "json",
			success : function(result) {
				console.log(result);
				/*성공시 처리해야될 코드 작성*/
				if (result !== null) {
					$("#idCheckMsg").html(id + "는 사용중인 아이디 입니다");
				} else {
					$("#idCheckMsg").html(id + "는 사용가능한 아이디 입니다");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}

		});

	});
</script>

</html>