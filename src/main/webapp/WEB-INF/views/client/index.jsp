<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>HotelSpace</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="headerCssLink.jspf" />
</head>
<body>
	<header>
		<c:import url="/clientHeader.do" />
	</header>

	<script type="text/javascript" src="resources/client/js/index/index.js"></script>
	<script>
		function reserveBestHotel(hotelId) {
			var reservationInDate = null;
			var reservationOutDate = null;
			
			var today = new Date(); 
			var tomorrow = new Date();
			tomorrow.setDate(tomorrow.getDate() + 1);
			var today_year = today.getFullYear(); // 년도
			var today_month = today.getMonth();  // 월
			var today_date = today.getDate();  // 날짜
			var tomorrow_year = tomorrow.getFullYear(); // 년도
			var tomorrow_month = tomorrow.getMonth();  // 월
			var tomorrow_date = tomorrow.getDate();  // 날짜
			reservationInDate = today_year.toString().substring(2, 4) + '-' + today_month.toString() + '-' + today_date.toString();
			reservationOutDate = tomorrow_year.toString().substr(2,4) + '-' + tomorrow_month.toString() + '-' + tomorrow_date.toString();
			
			window.location.href= "searchRoom.do?hotelId=" + hotelId + "&reservationInDate=" + reservationInDate + "&reservationOutDate=" + reservationOutDate;
		}
	</script>

	<div class="hero-wrap js-fullheight"
		style="background-image: url('${image['MAINPAGE']}');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-start"
				data-scrollax-parent="true">
				<div class="col-md-7 ftco-animate">
					<h2 class="subheading" style="color: #F261AAD">호텔 스페이스에 오신걸
						환영합니다</h2>
					<h1 class="mb-4" style="color: #F261AAD">
						최저가로 즐기는 <br> 최고가 호텔
					</h1>
					<!--    <p><a href="#" class="btn btn-primary">더 알아보기</a> <a href="#" class="btn btn-white">문의하기</a></p> -->
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section ftco-book ftco-no-pt ftco-no-pb">
		<div class="container">
			<div class="row justify-content-end">
				<div class="col-lg-4">
					<form action="searchHotelToIndex.do" class="appointment-form"
						onsubmit="return checkInputDate()">
						<h4 class="mb-3">어디로 떠나고 싶으신가요?</h4>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="ex) 서울,신라호텔" name="searchKeyword"
										id="searchKeyword">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="input-wrap">
										<div class="icon">
											<span class="ion-md-calendar"></span>
										</div>
										<input type="date" value="Check-in" class="input-group date"
											name="checkInDate" id="checkInDate" placeholder="Check-in">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="input-wrap">
										<div class="icon">
											<span class="ion-md-calendar"></span>
										</div>
										<input type="date" class="input-group date"
											name="checkOutDate" id="checkOutDate" placeholder="Check-out">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="form-field">
										<div class="select-wrap">
											<div class="icon">
												<span class="fa fa-chevron-down"></span>
											</div>
											<select name="area" id="area" class="form-control">
												<option value="전체" selected="selected">전체</option>
												<option value="서울">서울</option>
												<option value="인천">인천</option>
												<option value="경기">경기</option>
												<option value="부산">부산</option>
												<option value="대전">대전</option>
												<option value="제주">제주</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="form-field">
										<div class="select-wrap">
											<div class="icon">
												<span class="fa fa-chevron-down"></span>
											</div>
											<select name="people" id="people" class="form-control">
												<option value="0">인원</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="10">9명이상</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<input type="submit" value="검색하기"
										class="btn btn-primary py-3 px-4">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-services">
		<div class="container">
			<div class="row">
				<div
					class="col-md-4 d-flex services align-self-stretch px-4 ftco-animate">
					<div class="d-block services-wrap text-center">
						<div class="img" style="background-image: url(${image['SEOUL']});"></div>
						<div class="media-body py-4 px-3">
							<h3 class="heading">서울 특별시</h3>
							<p>서울 도심 안에있는 최고 인기호텔</p>
							<p>
								<a
									href="searchHotelToIndex.do?area=서울"
									class="btn btn-primary">찾아보기</a>
							</p>
						</div>
					</div>
				</div>
				<div
					class="col-md-4 d-flex services align-self-stretch px-4 ftco-animate">
					<div class="d-block services-wrap text-center">
						<div class="img" style="background-image: url(${image['BUSAN']});"></div>
						<div class="media-body py-4 px-3">
							<h3 class="heading">부산 광역시</h3>
							<p>제2의 수도 부산의 특별한 매력이 담겨있는 호텔</p>
							<p>
								<a
									href="searchHotelToIndex.do?area=부산"
									class="btn btn-primary">찾아보기</a>
							</p>
						</div>
					</div>
				</div>
				<div
					class="col-md-4 d-flex services align-self-stretch px-4 ftco-animate">
					<div class="d-block services-wrap text-center">
						<div class="img" style="background-image: url(${image['JEJU']});"></div>
						<div class="media-body py-4 px-3">
							<h3 class="heading">제주도</h3>
							<p>우리나라의 아름다운 섬 제주도 호텔</p>
							<p>
								<a
									href="searchHotelToIndex.do?area=제주"
									class="btn btn-primary">찾아보기</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section bg-light">
		<div class="container-fluid px-md-0">
			<div class="row no-gutters justify-content-center pb-5 mb-3">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<h2>최고 평점 호텔</h2>
				</div>
			</div>
			<div class="row no-gutters">

				<c:set var="cnt" value="0"></c:set>
				<c:forEach var="top" items="${hotel}">
					<div class="col-lg-6">
						<div class="room-wrap d-md-flex">
							<c:if test="${cnt < 2}">
								<a href="#" class="img order-md-last"
									style="background-image: url(${top.imageLink});"></a>
							</c:if>
							<c:if test="${cnt >= 2}">
								<a href="#" class="img"
									style="background-image: url(${top.imageLink});"></a>
							</c:if>
							<c:set var="cnt" value="${cnt + 1 }"></c:set>
							<div class="half left-arrow d-flex align-items-center">
								<div class="text p-4 p-xl-5 text-center">
									<p class="star mb-0">									
									<c:set var="star" value="${top.hotelStar }"/>
									
									<!-- 별점 0~1 -->
									<c:if test="${star <= 0.1 }">
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
				
									<c:if test="${star <= 0.8 && star > 0.1}">
										<span class="fa fa-star-half-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
									<c:if test="${star > 0.8 && star <= 1.1}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
									
									<!-- 별점 1~2 -->
									<c:if test="${star > 1.1 && star <= 1.8}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star-half-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
				
									<c:if test="${star > 1.8 && star <= 2.1}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
				
									<c:if test="${star > 2.1 && star <= 2.8}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star-half-o"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
									<c:if test="${star > 2.8 && star <= 3.1}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
						
									<c:if test="${star > 3.1 && star <= 3.8}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star-half-o"></span>
										<span class="fa fa-star-o"></span>
									</c:if>
									<c:if test="${star > 3.8 && star <= 4.1}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>										
										<span class="fa fa-star"></span>										
										<span class="fa fa-star-o"></span>
									</c:if>
						
									<c:if test="${star > 4.1 && star <= 4.8}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star-half-o"></span>
									</c:if>
									<c:if test="${star > 4.8}">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										
									</c:if>
						
											
									</p>
									<!-- <p class="mb-0"><span class="price mr-1">$120.00</span> <span class="per">per night</span></p> -->
									<h3 class="mb-3">
										<a href="javascript:reserveBestHotel('${top.hotelId }');">${top.hotelName }</a>
									</h3>
									<ul class="list-accomodation">
										<c:if test="${top.revCnt != null }">
											<li><span>예약수 : </span> ${top.revCnt }</li>
										</c:if>
										<c:if test="${top.comCnt != null }">
											<li><span>리뷰 : </span> ${top.comCnt }</li>
										</c:if>
										<li><span>별점 : </span> ${top.hotelStar }</li>
									</ul>
									<p class="pt-1">
										<a href="javascript:reserveBestHotel('${top.hotelId }');" class="btn-custom px-3 py-2">예약하기<span
											class="icon-long-arrow-right"></span></a>
									</p>
								</div>
							</div>
						</div>
					</div>



				</c:forEach>

			</div>
		</div>
	</section>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center pb-5 mb-3">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<h2>휴양지 속 특별한 story</h2>
					<span class="subheading">휴양지 속 휴양지 초대합니다!</span>
				</div>
			</div>
			<div class="row d-flex">
				<div class="col-md-4 d-flex ftco-animate">
					<div class="blog-entry align-self-stretch">
						<a href="searchHotelToIndex.do?concept=글램핑" class="block-20 rounded"
							style="background-image: url('${image['글렘핑']}');"> </a>
						<div class="text p-4 text-center">
							<h3 class="heading">
								<a
									href="searchHotelToIndex.do?concept=글렘핑">글램핑</a>
							</h3>
							<div class="meta mb-2">
								<p>글램핑이 처음이십니까? 첫 글램핑을 경험해 보십시오!</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 d-flex ftco-animate">
					<div class="blog-entry align-self-stretch">
						<a href="searchHotelToIndex.do?concept=바다 낭만" class="block-20 rounded"
							style="background-image: url('${image['바다 낭만']}');"> </a>
						<div class="text p-4 text-center">
							<h3 class="heading">
								<a
									href="searchHotelToIndex.do?concept=바다 낭만">바다
									낭만</a>
							</h3>
							<div class="meta mb-2"></div>
							<p>아름다운 바다 뷰를 보며 즐거움, 편안함 둘다 느낄수있는 호텔로 당신을 초대합니다</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 d-flex ftco-animate">
					<div class="blog-entry align-self-stretch">
						<a href="searchHotelToIndex.do?concept=도심 속 힐링" class="block-20 rounded"
							style="background-image: url('${image['도심 속 힐링']}');"> </a>
						<div class="text p-4 text-center">
							<h3 class="heading">
								<a
									href="searchHotelToIndex.do?concept=도심 속 힐링">도심
									힐링</a>
							</h3>
							<div class="meta mb-2"></div>
							<p>도심 속에서 낭만적인 야경을 만끽하십시오!</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

	<jsp:include page="headerScriptLink.jspf" />

</body>
</html>