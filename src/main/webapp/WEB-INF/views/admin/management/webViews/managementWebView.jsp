<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>hotelspace</title>

<link rel="stylesheet"
	href="resources/admin/css/management/webViews/webViews.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<jsp:include page="/WEB-INF/views/admin/headerCssLink.jspf" />

<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
<script type="text/javascript" src="resources/admin/js/jquery-3.3.1.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resources/admin/js/management/webViews/webViews.js"></script>

</head>
<body class="fix-header">
	<div id="wrapper">
		<c:import url="/navbar.mdo" />
		<c:import url="/sidebar.mdo" />


		<!-- page Content -->
		<section class="page-section portfolio" id="portfolio">
			<div class="container" style="margin-top: 10%;;">
				<h2
					class="page-section-heading text-center text-uppercase text-secondary mb-0">페이지
					사진 관리</h2>
				<div>
					<hr style="border: solid 0.1px gray;" />
				</div>
				<div class="row" style="width: 100%;">
					<div class="col-md-6 col-lg-4 mb-5">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal1">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_mainhome">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_mainhome" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 홈 화면(메인) </b>
						</div>
					</div>
				</div>
				<div>
					<hr style="border: dashed 0.1px gray;" />
				</div>
				<div class="row" style="width: 100%;">
					<div class="col-md-6 col-lg-4 mb-5 mb-lg-0">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal4">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_seoul">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_seoul" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 홈 화면(서울) </b>
						</div>
					</div>

					<div class="col-md-6 col-lg-4 mb-5 mb-md-0">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal5">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_busan">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_busan" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 홈 화면(부산) </b>
						</div>
					</div>

					<div class="col-md-6 col-lg-4">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal6">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_jeju">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_jeju" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 홈 화면(제주도) </b>
						</div>
					</div>
				</div>
				<div>
					<hr style="border: dashed 0.1px gray;" />
				</div>
				<div class="row" style="width: 100%;">
					<div class="col-md-6 col-lg-4 mb-5 mb-lg-0">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal4">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_sea">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_sea" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 홈 화면(바다 낭만) </b>
						</div>
					</div>

					<div class="col-md-6 col-lg-4 mb-5 mb-md-0">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal5">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_healing">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_healing" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 홈 화면(도심 속 힐링) </b>
						</div>
					</div>

					<div class="col-md-6 col-lg-4">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal6">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_glamping">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_glamping" style="height: 200px; width: 250px;"/>
						</div>
						<div align="center">
							<b> 홈 화면(글렘핑) </b>
						</div>
					</div>
				</div>
				<div>
					<hr style="border: dashed 0.1px gray;" />
				</div>
				<div class="row" style="width: 100%;">
					<div class="col-md-6 col-lg-4 mb-5 mb-md-0">
						<div class="portfolio-item mx-auto" data-toggle="modal"
							data-target="#portfolioModal5">
							<div
								class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100"
								id="_login">
								<div
									class="portfolio-item-caption-content text-center text-white">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div>
							<img class="img-fluid" id="img_login" style="height: 200px; width: 250px;" />
						</div>
						<div align="center">
							<b> 로그인 화면 </b>
						</div>
					</div>
				</div>
				<div>
					<hr style="border: solid 0.1px gray;" />
				</div>
			</div>


			<div style="margin-top: 15%; margin-bottom: 15%;"></div>

			<div class="container" style="margin-top: 10%;">
				<h2
					class="page-section-heading text-center text-uppercase text-secondary mb-0">등록
					사진 관리</h2>

				<div>
					<h4>파일 등록</h4>
					<div>
						<hr style="border: solid 0.1px gray;" />
					</div>
					<div class="row" style="width: 100%;">

						<div id="div-fileUpload" style="width: 100%;">
							<div class="filebox" style="margin-left: 2%; margin-bottom: 1%;">

								<input type="file" id="select_file" name="select_file"
									class="upload-hidden" accept=".png, .jpg, .gif"
									style="display: inline;" multiple="multiple"
									onclick="saveElement(this)"> <span
									style="margin-left: 59.75%;">
									<button id="btn-plus" style="margin-right: 2%;">
										<img src="resources/admin/images/plus.png">
									</button>
									
								</span>

							</div>
						</div>
					</div>
					<div style="margin-top: 5%;">
						<span style="margin-left: 0.5%;">
							<button id="btn-showImage">사진 보기</button>
						</span> <span style="margin-top: 5%; margin-left: 70%;">
							<button id="btn-reset">초기화</button>
							<button id="btn-upload">사진 업로드</button>
						</span>
					</div>
				</div>


				<div>
					<hr style="border: solid 0.1px gray;" />
				</div>
			</div>

			<!-- Modal -->
			<div class="modal" id="imageModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-xl">
					<div class="modal-content" style="padding-left: 3%;" align="center">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">등록 사진 목록</h4>
						</div>
						<div class="modal-body" id="modal-body" align="center">...</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" id="btn-modal-cancle">취소</button>
							<button type="button" class="btn btn-primary" id="btn-modal-updatePageImage">사진 변경</button>
							<button type="button" class="btn btn-primary" id="btn-modal-delete">삭제</button>
							<button type="button" class="btn btn-default" data-dismiss="modal" id="btn-modal-confirm">확인</button>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- ============================================================== -->

		<c:import url="/footer.mdo" />
		<!-- /.container-fluid -->

	</div>

</body>
</html>
