<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>호텔 등록</title>
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/registerHotel.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
<script type="text/javascript" src="resources/admin/js/jquery-3.3.1.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resources/admin/js/management/hotel/registerHotel.js"></script>

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

	<!-- page Content -->
	<section class="page-section portfolio" id="portfolio">
		
		<div class="container">
			<div class="row" style="width: 100%;" align="center">
				<div style="width:100%;" align="center">
					<h2>호텔 등록 정보 입력</h2>
				</div>
			</div>
			<br /> 1. 호텔 메인 이미지 등록
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
			<br /> <br /> <br /> 2. 호텔 일반 이미지 등록
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
			<br /> 3. 호텔 정보 입력
			<hr />
			<div>
				<div class="row" style="width: 100%;">
					<table class="table table-bordered" style="text-align: center;">

						<tbody id="hotelInfo-body">
							<tr>
								<td>호텔명 :</td>
								<td><input type="text" id="hotel-name" /></td>
							</tr>
							<tr>
								<td>등록인 ID :</td>
								<td><input type="text" id="hotel-clientId" /></td>
							</tr>
							<tr>
								<td>전화번호 :</td>
								<td><input type="tel" id="hotel-tel" /></td>
							</tr>
							<tr>
								<td>지역 :</td>
								<td><input type="text" id="hotel-area" /></td>
							</tr>
							<tr>
								<td>주소 :</td>
								<td><input type="text" id="hotel-address" /></td>
							</tr>
							<tr>
								<td>테마 :</td>
								<td><input type="text" id="hotel-concept" /></td>
							</tr>
							<tr>
								<td>편의시설 :</td>
								<td><input type="checkbox" name="facilities" id="facility-parking"
									value="FACILITIES_PARKING" /><label for="">주차장</label>&nbsp;&nbsp;
									<input type="checkbox" name="facilities" id="facility-pool"
									value="FACILITIES_POOL" /><label for="">수영장</label>&nbsp;&nbsp;
									<input type="checkbox" name="facilities" id="facility-breakfast"
									value="FACILITIES_BREAKFAST" /><label for="">식당</label>&nbsp;&nbsp;
									<input type="checkbox" name="facilities" id="facility-fitness"
									value="FACILITIES_FITNESS" /><label for="">헬스장</label>&nbsp;&nbsp;
									<input type="checkbox" name="facilities" id="facility-wifi"
									value="FACILITIES_WIFI" /><label for="">WIFI</label>&nbsp;&nbsp;
									<input type="checkbox" name="facilities" id="facility-partyRoom"
									value="FACILITIES_PARTYROOM" /><label for="">파티룸</label>&nbsp;&nbsp;
								</td>
							</tr>
						</tbody>
					</table>
					<div style="width: 100%;">
						<span style="float: right;">
							<button id="btn-reset" onclick="resetInput();">초기화</button>
							<button id="btn-cancel" onclick="windowClose();">취소</button>
							<button id="btn-registerHotel" onclick="requestRegisterHotel();">호텔 등록</button>
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
