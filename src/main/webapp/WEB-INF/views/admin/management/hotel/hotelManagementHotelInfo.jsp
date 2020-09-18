<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>HOTEL INFO</title>
<link rel="shortcut icon" href="#">
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/open-iconic-bootstrap.min.css">
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/aos.css">
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/style.css">
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/carousel.css">
<link href="resources/admin/css/management/hotel/hotelInfo.css">

</head>
<body>
	<script type="text/javascript" src="resources/admin/js/jquery-3.3.1.js"
		type="text/javascript"></script>
	<script src="resources/admin/vendor/bootstrap/dist/js/bootstrap.js"
		type="text/javascript"></script>
	<script src="resources/admin/vendor/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="resources/admin/js/management/hotel/hotelInfo.js"
		type="text/javascript"></script>
	<script src="resources/admin/js/management/hotel/imageManagement.js"
		type="text/javascript"></script>
	<script src="resources/admin/vendor/bootstrap/js/carousel.js"
		type="text/javascript"></script>
	<input type="hidden" value="${hotelId }" id="hidden-hotelId" />

	<!-- page Content -->
	<div class="site-section bg-light">
		<div class="container">

			<!-- hotel Info -->
			<div align="center" style="border: double; margin-bottom: 200px;">
				<br />
				<h3 style="width: 100%;">호텔 정보</h3>
				<br />
				<div class="row mb-5" style="margin-bottom: 0rem !important;">
					<div class="col-md-12 mb-5">
						<div class="block-3 d-md-flex" id="div-hotelInfo"></div>
					</div>
				</div>
			</div>

			<!-- Room Info -->
			<div align="center" style="border: double; margin-bottom: 200px;">
				<br />
				<h3 style="width: 100%;">방 정보</h3>
				<br />
				<div class="row mb-5" id="div-roomInfo"></div>
			</div>


			<div class="row mb-5 pt-5 justify-content-center">
				<div class="col-md-7 text-center section-heading">
					<h2 class="heading">More Rooms</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Reprehenderit, iusto, omnis! Quidem, sint, impedit? Dicta eaque
						delectus tempora hic, corporis velit doloremque quod quam laborum,
						nobis iusto autem culpa quaerat!</p>
				</div>
			</div>
		</div>


		<!-- 이미지 관리 modal -->
		<div class="modal" id="manageImageModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-xl">
				<div class="modal-content" style="padding-left: 3%;" align="center">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">등록 사진 목록</h4>
					</div>
					
					<div class="modal-body" id="modal-body" align="center"></div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="btn-modal-cancle">취소</button>
						<button type="button" class="btn btn-primary"
							id="btn-modal-addPageImage">추가</button>
						<button type="button" class="btn btn-primary"
							id="btn-modal-updatePageImage">사진 변경</button>
						<button type="button" class="btn btn-primary"
							id="btn-modal-delete">삭제</button>
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="btn-modal-confirm">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>
