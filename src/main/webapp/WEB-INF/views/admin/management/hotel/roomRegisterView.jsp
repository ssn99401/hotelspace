<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>방 등록</title>
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/registerHotel.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
<script type="text/javascript" src="resources/admin/js/jquery-3.3.1.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resources/admin/js/management/hotel/registerRoom.js"></script>

</head>
<body>
	<script type="text/javascript" src="resources/admin/js/jquery-3.3.1.js"
		type="text/javascript"></script>
	<script src="resources/admin/vendor/bootstrap/dist/js/bootstrap.js"
		type="text/javascript"></script>
	<script src="resources/admin/vendor/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="resources/admin/js/management/hotel/imageManagement.js"
		type="text/javascript"></script>
	<script src="resources/admin/vendor/bootstrap/js/carousel.js"
		type="text/javascript"></script>
	<input type="hidden" value="${hotelId }" id="hidden-hotelId" />
	<!-- page Content -->
	<section class="page-section portfolio" id="portfolio">
		
		<div class="container">
			<div class="row" style="width: 100%;" align="center">
				<div style="width:100%;" align="center">
					<h2>방 등록 정보 입력</h2>
				</div>
			</div>
			<br /> 1. 방 메인 이미지 등록
			<hr />
			<div>
				<div class="row" style="width: 100%;">

					<div id="div-fileUpload-main" style="width: 100%;">
						<div class="filebox" style="margin-left: 2%; margin-bottom: 1%;">

							<input type="file" id="select_file-main" name="select_file-main"
								class="upload-hidden" accept=".png, .jpg, .gif"
								style="display: inline;" onclick="saveElement(this)"> <span
								style="margin-left: 59.75%;"> </span>
						</div>
					</div>
				</div>
			</div>
			<div>
				<hr style="border: solid 0.1px gray;" />
			</div>
			<br /> <br /> <br /> 2. 방 일반 이미지 등록
			<hr />
			<div>

				<div class="row" style="width: 100%;">

					<div id="div-fileUpload-normal" style="width: 100%;">
						<div class="filebox" style="margin-left: 2%; margin-bottom: 1%;">

							<input type="file" id="select_file-normal"
								name="select_file-normal" class="upload-hidden"
								accept=".png, .jpg, .gif" style="display: inline;"
								multiple="multiple" onclick="saveElement(this)"> <span
								style="float: right;">
								<button id="btn-plus" style="margin-right: 2%;">
									<img src="resources/admin/images/plus.png">
								</button>

							</span>

						</div>
					</div>
					<div style="margin-top: 5%; width: 100%;">
						<span style="margin-top: 5%; margin-left: 70%; float: right;">
							<button id="btn-reset">초기화</button>
						</span>
					</div>
				</div>
			</div>
			<div>
				<hr style="border: solid 0.1px gray;" />
			</div>
		</div>
		<br />
		<br />
		<div class="container">
			<br /> 3. 방 정보 입력
			<hr />
			<div>
				<div class="row" style="width: 100%;">
					<table class="table table-bordered" style="text-align: center;">

						<tbody id="RoomInfo-body">
							<tr>
								<td>방 이름 :</td>
								<td><input type="text" id="room-name" /></td>
							</tr>
							<tr>
								<td>1박 요금 :</td>
								<td><input type="number" id="room-price" /></td>
							</tr>
							<tr>
								<td>방 갯수 :</td>
								<td><input type="number" id="room-amount" /></td>
							</tr>
							<tr>
								<td>표준 인원 :</td>
								<td><input type="number" id="room-standardPeople" /></td>
							</tr>
							<tr>
								<td>최대 인원 :</td>
								<td><input type="number" id="room-maxPeople" /></td>
							</tr>
							<tr>
								<td>인당 추가 요금 :</td>
								<td><input type="text" id="room-price-people" /></td>
							</tr>
							<tr>
								<td>서비스 :</td>
								<td><textarea name="content" id="room-service" cols="20" rows="10"></textarea></td>
							</tr>
							<tr>
								<td>방 정보 :</td>
								<td><textarea name="content" id="room-info" cols="20" rows="10"></textarea></td>
							</tr>
						</tbody>
					</table>
					<div style="width: 100%;">
						<span style="float: right;">
							<button id="btn-reset" onclick="resetInput();">초기화</button>
							<button id="btn-cancel" onclick="windowClose();">취소</button>
							<button id="btn-registerHotel" onclick="requestRegisterRoom();">방 등록</button>
						</span>
					</div>
				</div>
			</div>

			<div>
				<hr style="border: solid 0.1px gray;" />
			</div>
		</div>

	</section>

</body>

</html>
