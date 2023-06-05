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
<script
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
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
				<li><a
					href="${pageContext.request.contextPath}/guestbook/guestBookForm">일반방명록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/apiguestbook/guestBookForm">ajax방명록</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>ajax방명록</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>방명록</li>
						<li class="last">ajax방명록</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="guestbook">
				<!-- <form action="./addList" method="get" name="addList" onsubmit="return valiaddForm()"> -->
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
							<td colspan="4"><button type="button" id="btnSubmit">등록</button></td>
						</tr>
					</tbody>

				</table>
				<!-- //guestWrite -->
				<input type="hidden" name="action" value="add">

				<!-- 		</form> -->
				<div id ="guest">
					<c:forEach var="list" items="${guestBookList}">
						<table class="guestRead" >
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
				</div>
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

<script>
	$("#btnSubmit").on("click", function() {
		console.log("버튼클릭");
				
		var name = $("[name='name']").val();
		var pwd = $("[name='pwd']").val();
		var content = $("[name='content']").val();
	
		var guestbookVO = {
				name : name,
				pwd : pwd,
				content : content			
		};
	
		var guestbook = $("#guest");
		
		$.ajax({

			url : "${pageContext.request.contextPath}/apiguestbook/addList",
			type : "post",
			//contentType : "application/json",
			data : guestbookVO,

			dataType : "json",
			success : function(jsonResult) {
				console.log(jsonResult);
				console.log(jsonResult.data.boardId);
				
				var str = "";
				str += '<table class="guestRead">';
				str += '      <colgroup>';
				str += '      		<col style="width: 10%;">';
				str += '      		<col style="width: 40%;">';
				str += '      		<col style="width: 40%;">';
				str += '      		<col style="width: 10%;">';
				str += '      </colgroup>';
				str += '      <tr>';
				str += '      		<td>'+jsonResult.data.boardId+'</td>';
				str += '      		<td>'+jsonResult.data.name+'</td>';
				str += '      		<td>'+jsonResult.data.regDate+'</td>';
				str += '      		<td><a href="${pageContext.request.contextPath}/guestbook/deleteForm?boardId='+jsonResult.data.boardId+'">[삭제]</a></td>';
				str += '      </tr>';
				str += '      <tr>';
				str += '      		<td colspan="4" class="text-left">'+ jsonResult.data.content +'</td>';
				str += '      </tr>';
				str += '</table>';
		        guestbook.prepend(str);
				
			
		/* 	},
			error : function(XHR, status, error) {
				console.error(status + " : " + error); */
			}

		});

	});
</script>

</html>