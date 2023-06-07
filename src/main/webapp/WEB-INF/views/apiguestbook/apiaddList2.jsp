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

<!-- 부트스트랩 css -->
<link
	href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- jquery -->
<script
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

<!-- 부트스트랩 js -->
<script
	src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>

<!-- 모달 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
							<th><label class="form-text" for="input-uname">이름</label></th>
							<td><input id="input-uname" type="text" name="name" required></td>
							<th><label class="form-text" for="input-pass">패스워드</label></th>
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
				<div id="guest">
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

	<!-- 삭제 modal ------------------------------------------------------------------------------------>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">삭제 모달창</h4>
				</div>
				<div class="modal-body">
					<table id="guestDelete">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 25%;">
							<col style="width: 25%;">
						</colgroup>
						<tr>
							<td>비밀번호</td>
							<td><input id="modalpwd" type="password" name="pwd">
								<input id="modalboardId" type='hidden' name="boardId"></td>
							<td align="right"><a
								href="${pageContext.request.contextPath}/main">[메인으로 돌아가기]</a></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button id="btnDel" type="button" class="btn btn-danger btn-sm">삭제</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 삭제 modal ------------------------------------------------------------------------------------>


</body>

<script>
	
	$(window).ready(function() {
		
		//방명록 리스트 불러오는 함수 호출
		getList();
		console.log("dd")
			
		//방명록 등록했을때 ajax로 위에 추가하기
		  $("#btnSubmit").on("click", function() {
		    console.log("버튼클릭");
	
		    var name = $("[name='name']").val();
		    var pwd = $("[name='pwd']").val();
		    var content = $("[name='content']").val();
	
		    var guestbookVO = {
		      name: name,
		      pwd: pwd,
		      content: content
		    };
		    
		   
		    //등록되었을때 ajax 함수 호출
		    insert(guestbookVO);
		   		   
		  });
		
		//모달창에 있는 삭제 버튼 클릭했을때
			$("#btnDel").on("click", function() {
				console.log("삭제버튼");

				//숨겨놓은 넘버값 저장
				var boardId = $("#modalboardId").val();
				//입력된 비밀번호 저장
				var pwd = $("#modalpwd").val();
				//객채로 만들기
				var guestbookVO = {
					boardId : boardId,
					pwd : pwd

				};
				
				//삭제버튼 눌렀을때 ajax 함수 호출
				del(guestbookVO);

			});

			//삭제 모달창 호출 버튼
			$("#guest").on("click", ".deletemodal", function() {

				//삭제버튼 태그에서 no값 가져오기	
				var num = $(this).data("no");

				//히든창 value 에 no값 넣기
				var boardId = $("[name='boardId']");
				boardId.val(num);

				//초기화
				$("#modalpwd").val("");

				//모달창 보이기
				$("#myModal").modal("show");

			});
		

		//방명록 리스트 그리기
		function render(guestBookVO, dir) {

			var str = "";
			str += '<table id="t'+ guestBookVO.boardId +'" class="guestRead">';
			str += '      <colgroup>';
			str += '      		<col style="width: 10%;">';
			str += '      		<col style="width: 40%;">';
			str += '      		<col style="width: 40%;">';
			str += '      		<col style="width: 10%;">';
			str += '      </colgroup>';
			str += '      <tr>';
			str += '      		<td>' + guestBookVO.boardId
					+ '</td>';
			str += '      		<td>' + guestBookVO.name + '</td>';
			str += '      		<td>' + guestBookVO.regDate
					+ '</td>';
			str += '      		<td><button type="button" class="btn btn-danger btn-sm deletemodal" data-no="'+guestBookVO.boardId +'" >삭제</button></td>';
			str += '      </tr>';
			str += '      <tr>';
			str += '      		<td colspan="4" class="text-left">'
					+ guestBookVO.content + '</td>';
			str += '      </tr>';
			str += '</table>';
			if(dir == 'down'){
			$("#guest").append(str);
			}else if(dir =='up'){
			$("#guest").prepend(str);
			}else{
				console.log("방향없음");
			}
		}
		
		
		//getList 펑션	
		function getList() { 	
			  $.ajax({
				    url: "${pageContext.request.contextPath}/apiguestbook/guestBookList",
				    type: "post",
				    //contentType: "application/json",
				    //data: guestbookVO,
				    dataType: "json",
				    success: function(jsonResult) {
				      if (jsonResult.result == 'success') {
				        console.log(jsonResult);
			
				        for (var n in jsonResult.data) {
				          var guestBookVO = jsonResult.data[n];
				          render(guestBookVO, "down");
				        }
				      } else {
			
				      }
				    },
				    /* error: function(XHR, status, error) {
				      console.error(status + " : " + error);
				    } */
				  });
		}
		
		
			//insert 펑션
		 function insert(guestbookVO){
	    	 $.ajax({
			      url: "${pageContext.request.contextPath}/apiguestbook/addList2",
			      type: "post",
			      contentType: "application/json",
			      data: JSON.stringify(guestbookVO), //json 형태로 변경해서 보내주기
			      
			      dataType: "json",
			      success: function(jsonResult) {
			        if (jsonResult.result == 'success') {
			        	
			          render(jsonResult.data,'up');
		
			          $("[name='name']").val(""); //추가 후 input 요소 비워주기
			          $("[name='pwd']").val(""); //추가 후 input 요소 비워주기
			          $("[name='content']").val(""); //추가 후 input 요소 비워주기
			        } else {
		
			        }
			      },
			      /* error: function(XHR, status, error) {
			        console.error(status + " : " + error);
			      } */
			    });
	    	
	    }
			
			
		//delete 펑션
		 function del(guestbookVO){
				$.ajax({

					url : "${pageContext.request.contextPath}/apiguestbook/delete",
					type : "post",
					//contentType : "application/json",
					data : guestbookVO,

					dataType : "json",
					success : function(jsonResult) {

						if (jsonResult.result == 'success') {
							console.log(jsonResult);
							if (jsonResult.data > 0) {
								//삭제가된 넘버 가지고오기
								var boardId = guestbookVO.boardId;
								//테이블에 아이디를 넘버로 부여하고 타게팅해서 지우기
								$("#t" + boardId).remove();
								//버튼 클릭후 모달창 끄기
								$("#myModal").modal("hide");
								
								Swal.fire({
									  position: 'center',
									  icon: 'success',
									  title: '삭제되었습니다',
									  showConfirmButton: false,
									  timer: 1500
									});
								
							} else {
								$("#modalpwd").val("");
								Swal.fire({
									  icon: 'error',
									  title: '비밀번호가 틀렸습니다.'
									});
							}
						} else {

						}
					}
				});
				
			}
			
		
	});


</script>

</html>