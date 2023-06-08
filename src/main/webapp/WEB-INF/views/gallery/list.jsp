<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<!-- nav -->
		<c:import url="/WEB-INF/views/include/nav.jsp" />
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/galleryAside.jsp"></c:import>
		<!-- //aside -->


		<div id="content">

			<div id="content-head">
				<h3>갤러리</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>갤러리</li>
						<li class="last">갤러리</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->


			<div id="gallery">
				<div id="list">

					<c:if test="${!empty user.id}">
						<button id="btnImgUpload">이미지올리기</button>
					</c:if>

					<div class="clear"></div>


					<ul id="viewArea">
						<!-- 이미지반복영역 -->
						<c:forEach items="${galleryList}" var="gallery">
							<li>
								<div id="g${gallery.no}" class="view" data-no="${gallery.no}">
									<img class="imgItem"
										src="${pageContext.request.contextPath}/upload/${gallery.saveName}" >
										
									<div class="imgWriter">
										작성자: <strong>${gallery.name}</strong>
									</div>
								</div>
							</li>
						</c:forEach>
						<!-- 이미지반복영역 -->


					</ul>
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->



	<!-- 이미지등록 팝업(모달)창 -->
	<div class="modal fade" id="addModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지등록</h4>
				</div>

				<form method="post" action="./insert" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group">
							<label class="form-text">글작성</label> <input id="addModalContent"
								type="text" name="content" value="">
						</div>
						<div class="form-group">
							<label class="form-text">이미지선택</label> <input id="file"
								type="file" name="file" value=""> <input type="hidden"
								name="userNo" value="${user.no}">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn" id="btnUpload">등록</button>
					</div>
				</form>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<!-- 이미지보기 팝업(모달)창 -->
	<div class="modal fade" id="viewModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지보기</h4>
				</div>
				<div class="modal-body">

					<div class="formgroup">
						<img id="viewModelImg" src="" style="max-width: 200px;">
						<!-- ajax로 처리 : 이미지출력 위치-->
					</div>

					<div class="formgroup">
						<p id="viewModelContent"></p>
					</div>

				</div>
				<form method="" action="">
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" id="btnDel" >삭제</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						
					</div>
					<input id="hiddenNo" type="hidden" name="no" value=""/>	

				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


</body>

<script type="text/javascript">

	/* 인서트 모달 이벤트처리 */
	$("#btnImgUpload").on("click", function() {
		
		$("#addModal").modal("show");

	});
	// view 모달창
	$(".view").on("click",function(){
				
		var no = $(this).data("no");
				
		var galleryVO = {
			no : no
		};
		
		getgallery(galleryVO);
		
	});
	
	$("#btnDel").on("click",function(){
		
		//숨겨둔 겔러리no 가져오기
		var delno = $("#hiddenNo").val();
		
		delgallery(delno);
		
				
	});
	
	// 삭제
	function delgallery(delno){
		
		
		$.ajax({
			
			url : "${pageContext.request.contextPath }/gallery/delete",		
			type : "get",
			//contentType : "application/json",
			data : {no:delno},

			dataType : "json",
			success : function(jsonResult){
				
				
				//삭제된 갤러리제거
				$("#g" +delno).remove();
				//모다창 닫기
				$("#viewModal").modal("hide");
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
		
	};
	// 이미지보기 팝업(모달)창
	function getgallery(galleryVO){
		
		$.ajax({
					
					url : "${pageContext.request.contextPath }/gallery/getgallery",		
					type : "post",
					//contentType : "application/json",
					data : galleryVO,
		
					dataType : "json",
					success : function(jsonResult){
						console.log(jsonResult)
						
						//사진경로 삽입
						var saveName = "${pageContext.request.contextPath}/upload/"+jsonResult.data.saveName ;
						$("#viewModelImg").attr("src", saveName);
						
						//내용 삽입
						var content = jsonResult.data.content;
						$("#viewModelContent").text(content);
						
						//no 삽입
						var no = jsonResult.data.no;
						$("#hiddenNo").val(no);
						
						//삭제창 띄우기
						var userNo = $("[name='userNo']").val();
						if(userNo==jsonResult.data.userNo){
							$("#btnDel").show();
						}else{
							$("#btnDel").hide();
						}
						
						
						//모달창 띄우기
						$("#viewModal").modal("show");
						
						//$(".formgroup").remove();
										
						
						/*성공시 처리해야될 코드 작성*/
					},
					error : function(XHR, status, error) {
						console.error(status + " : " + error);
					}
				});
	};
	
</script>





</html>

