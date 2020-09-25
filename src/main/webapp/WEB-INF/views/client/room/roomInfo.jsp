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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Anton'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Neucha'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="resources/client/css/room/carousel.css">
</head>



<body>


	<header>
		<c:import url="/clientHeader.do" />
	</header>




	<div class="site-section bg-light">
		<div class="container">
			<div class="row mb-5">
				<c:set var="index" value="${0}" />

				<c:set var="number" value="${0 }" />
				<c:forEach items="${roomList }" var="Room">
					<h3>${index }</h3>

					<input type="hidden" id="numberCount" value="${number }">


					<c:if test="${index < fn:length(roomList) }">
						<c:set var="count" value="${0}" />
						<div class="col-md-12 mb-5">

							<div class="block-3 d-md-flex">
								<div style="width: 50%;">
									<c:forEach items="${roomList }" var="r">
										<c:if test="${roomList[index].roomId eq r.roomId }">
											<c:set var="count" value="${count + 1}" />
										</c:if>
									</c:forEach>

									<!--  -->

									<div id="carouselExampleIndicators${number}"
										class="carousel slide" data-ride="carousel"
										style="padding: 0; padding-top: 10%; padding-left: 5%; padding-right: 5%; width: 100%; height: 80%;"
										data-interval="false">

										<ol class="carousel-indicators">
											<c:set var="c" value="${0}" />
											<c:forEach items="${image }" var="image">
												<c:if test="${roomList[index].roomId eq image.roomId }">
													<li data-target="#carouselExampleIndicators${number}"
														data-slide-to="${c}"></li>
													<c:set var="c" value="${c + 1}" />
												</c:if>
											</c:forEach>
										</ol>

										<div class="carousel-inner">
											<!-- Room 이미지 출력 -->
											<c:set var="active" value="${0}" />
											<c:forEach items="${image }" var="image">
												<c:if test="${roomList[index].roomId eq image.roomId }">
													<%-- <div class="image" id="image"
											style="background-image: url('${image.imageLink}');"></div> --%>
													<c:if test="${active eq 0 }">
														<div class="carousel-item item active">
															<img class="d-block w-100" src="${image.imageLink}"
																id="${number }" alt="첫번째 슬라이드">
															<div class="carousel-caption"
																style="position: unset; color: #000;"></div>
														</div>

														<c:set var="active" value="${1}" />
													</c:if>
													<c:if test="${active ne 0 }">
														<div class="carousel-item item ">
															<img class="d-block w-100" src="${image.imageLink}"
																alt="첫번째 슬라이드">
															<div class="carousel-caption"
																style="position: unset; color: #000;"></div>
														</div>
													</c:if>


												</c:if>
											</c:forEach>
										</div>

										<a class="carousel-control-prev"
											href="#carouselExampleIndicators${number}" role="button"
											data-slide="prev" style="left: 4%;"> <span
											class="carousel-control-prev-icon"></span></a> <a
											class="carousel-control-next"
											href="#carouselExampleIndicators${number}" role="button"
											data-slide="next" style="right: 5%;"> <span
											class="carousel-control-next-icon"></span></a>
									</div>
								</div>





								<!-- Room 정보 -->
								<div class="text">

									<h2 class="heading">${roomList[index].roomName }</h2>
									<div class="price">
										<sup>￦</sup><span class="number"> <fmt:formatNumber
												value="${roomList[index].roomPrice }" pattern="#,###,###" /></span><sub>/1박</sub>
									</div>
									<ul class="specs mb-5">
										<li><strong>방 기준인원: </strong>${roomList[index].roomStandardPeople}</li>
										<li><strong>방 최대인원: </strong>${roomList[index].roomMaxPeople }</li>
										<li><strong>기본옵션: </strong>
											${roomList[index].roomServices }</li>
										<li><strong>잔여 객실: </strong>${roomList[index].roomAmount }</li>
										<li><strong>선택하신 날짜:</strong><br>
											${param.reservationInDate} ~ ${param.reservationOutDate}</li>
										<li><strong>Info: </strong><br>${roomList[index].roomInfo }<br>
											방 기준인원에서 1인 추가시마다 +30,000￦씩 추가됩니다.</li>

									</ul>
									<p>
										<c:if test="${roomList[index].roomAmount != 0 }">
											<a
												href="revInfo.do?roomId=${roomList[index].roomId}&reservationInDate=${param.reservationInDate}&reservationOutDate=${param.reservationOutDate}"
												class="btn btn-primary py-3 px-5">예약</a>
										</c:if>
										<c:if test="${roomList[index].roomAmount == 0 }">
											<a href="#" onclick="return false;"
												class="btn btn-primary py-3 px-5"
												style="background-color: #bbb2b3;">매진</a>
										</c:if>
									</p>
								</div>
								<c:set var="index" value="${index + count}" />
							</div>
						</div>
					</c:if>
					<c:set var="number" value="${number + 1 }" />
				</c:forEach>
			</div>
		</div>
	</div>





	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

	<script src="resources/client/js/room/bootstrap.js"></script>
	<script src="resources/client/js/room/bootstrap.min.js"></script>
	<script src="resources/client/js/jquery.min.js"></script>
	<script src="resources/client/js/jquery-3.3.1.js"></script>
	<script src="resources/client/js/room/bootstrap-datepicker.js"></script>
	<script src="resources/client/js/room/carousel.js"></script>

</body>
</html>