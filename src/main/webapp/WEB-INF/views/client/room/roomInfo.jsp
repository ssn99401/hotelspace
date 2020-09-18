<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<title>Room</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="resources/client/css/room/slide.css">
<link href="https://fonts.googleapis.com/css?family=Rubik:300,400,500"
	rel="stylesheet">
<link rel="stylesheet"
	href="resources/client/css/room/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="resources/client/css/room/animate.css">
<link rel="stylesheet"
	href="resources/client/css/room/owl.carousel.min.css">
<link rel="stylesheet"
	href="resources/client/css/room/owl.theme.default.min.css">
<link rel="stylesheet"
	href="resources/client/css/room/magnific-popup.css">
<link rel="stylesheet" href="resources/client/css/room/ionicons.min.css">
<link rel="stylesheet"
	href="resources/client/css/room/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="resources/client/css/room/jquery.timepicker.css">
<link rel="stylesheet" href="resources/client/css/room/flaticon.css">
<link rel="stylesheet" href="resources/client/css/room/icomoon.css">
<link rel="stylesheet" href="resources/client/css/room/style.css">


</head>
<body>

	<header>
		<c:import url="/clientHeader.do" />
	</header>

	<div class="site-section bg-light">
		<div class="container">
			<div class="row mb-5">

				<c:forEach items="${roomList }" var="Room">
					<c:set var="index" value="${0}" />
					<c:set var="RoomId" value="${roomList[index].roomId }" />
					<div class="col-md-12 mb-5">

						<div class="block-3 d-md-flex">
							<c:if test="${roomList[index].roomId eq RoomId}">
								<div class="image" id="image"
									style="background-image: url('${Room.imageLink}');"></div>

								<div class="text">

									<h2 class="heading">${Room.roomName }</h2>
									<div class="price">
										<sup>￦</sup><span class="number"> <fmt:formatNumber
												value="${Room.roomPrice }" pattern="#,###,###" /></span><sub>/1박</sub>
									</div>
									<ul class="specs mb-5">
										<li><strong>방 기준인원: </strong>${Room.roomStandardPeople}</li>
										<li><strong>방 최대인원: </strong>${Room.roomMaxPeople }</li>
										<li><strong>기본옵션: </strong> ${Room.roomServices }</li>
										<li><strong>잔여 객실: </strong>${Room.roomAmount }</li>
										<li><strong>선택하신 날짜:</strong><br>
											${param.reservationInDate} ~ ${param.reservationOutDate}</li>
										<li><strong>Info: </strong><br>${Room.roomInfo }<br>
											방 기준인원에서 1인 추가시마다 +30,000￦씩 추가됩니다.</li>

									</ul>
								</div>
							</c:if>
							<p>
								<c:if test="${Room.roomAmount != 0 }">
									<a
										href="revInfo.do?roomId=${Room.roomId}&reservationInDate=${param.reservationInDate}&reservationOutDate=${param.reservationOutDate}"
										class="btn btn-primary py-3 px-5">예약</a>
								</c:if>
								<c:if test="${Room.roomAmount == 0 }">
									<a href="#" onclick="return false;"
										class="btn btn-primary py-3 px-5"
										style="background-color: #bbb2b3;">매진</a>
								</c:if>
							</p>
							
							<c:set var="index" value="${index + 1 }" />

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

	<script src="resources/client/js/jquery.min.js"></script>
	<script src="resources/client/js/room/jquery-migrate-3.0.1.min.js"></script>
	<script src="resources/client/js/room/jquery.easing.1.3.js"></script>
	<script src="resources/client/js/room/jquery.waypoints.min.js"></script>
	<script src="resources/client/js/room/jquery.stellar.min.js"></script>
	<script src="resources/client/js/room/owl.carousel.min.js"></script>
	<script src="resources/client/js/room/jquery.magnific-popup.min.js"></script>
	<script src="resources/client/js/room/bootstrap-datepicker.js"></script>


	<script src="resources/client/js/room/jquery.animateNumber.min.js"></script>

</body>
</html>