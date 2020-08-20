<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>hotelspace</title>
<link rel="stylesheet" type="text/css"
	href="resources/client/css/HotelBody.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="resources/client/css/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="resources/client/css/hotel/hotel.css">
<script type="text/javascript" src="resources/client/js/hotel/hotel.js"></script>
</head>
<body>
	<header>
		<c:import url="/clientHeader.do" />
	</header>

	<div class="container"
		style="background-color: #e0e0e0; min-width: 100%;">
		<div class="row mb-6"
			style="padding: 5%; background-color: #e9e9e9; max-width: 80%; max-height: 80%; margin-left: 10%;">
			<div class="col-md-12">
				<div class="block-32">
					<div class="row">
						<div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
							<label for="checkin">호텔명</label> <input type="text"
								class="form-control" placeholder="ex) 서울,신라호텔"
								name="searchKeyword" id="searchKeyword">
						</div>

						<div class="col-md-6 mb-3 mb-lg-0 col-lg-2">
							<label for="checkin">Check In</label> <input type="date"
								value="Check-in" class="input-group date" name="checkInDate"
								id="checkInDate" placeholder="Check-in">
						</div>
						<div class="col-md-6 mb-3 mb-lg-0 col-lg-2">
							<label for="checkin">Check Out</label> <input type="date"
								class="input-group date" name="checkOutDate" id="checkOutDate"
								placeholder="Check-out">
						</div>
						<div class="col-md-6 mb-3 mb-md-0 col-lg-3">
							<div class="row">
								<div class="col-md-6 mb-3 mb-md-0">
									<label for="checkin">지역</label>
									<div class="field-icon-wrap">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="area" id="area" class="form-control">
											<option value="서울" selected="selected">서울</option>
											<option value="인천">인천</option>
											<option value="경기">경기</option>
											<option value="ha1">ha1</option>
											<option value="ha3">ha2</option>
											<option value="">5</option>
											<option value="">6</option>
											<option value="">7</option>
											<option value="">8</option>
											<option value="">9</option>
										</select>
									</div>
								</div>
								<div class="col-md-6 mb-3 mb-md-0">
									<label for="checkin">인원</label>
									<div class="field-icon-wrap">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
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
						<div class="col-md-3 col-lg-2" style="margin-top: 2%;">
							<button class="btn btn-primary btn-block"
								onclick="searchHotel();">검색</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-lg-12" style="margin-left: 10%">
		<div class="row">
			<div class="col-xs-3 hidden-lg hidden-md hidden-xs"
				style="margin: 0%; padding: 0px;" id="sideSearchBar">
				<div class="resp-row" id="search-result">
					<div class="resp-col aside" id="slidePanel">
						<div id="filters" class="filters aside-map-show">
							<div class="search-header-link aside-map">
								<a href="#" id="search-map-link"
									class="search-header-link-body link-map"><span><b>지도에서
											보기</b></span></a>
							</div>
							<div class="filters-overlay-close">
								<div class="narrow-results-header-container">
									<h2 class="narrow-results-header">검색 결과 필터링:</h2>
								</div>
								<div class="reset-filters clear-filters-link"
									style="display: none;">
									<a
										href="?destination-id=759818&amp;q-check-out=2020-08-18&amp;q-destination=%EC%84%9C%EC%9A%B8,%20%ED%95%9C%EA%B5%AD&amp;q-room-0-adults=2&amp;q-rooms=1&amp;q-check-in=2020-08-17&amp;resolved-location=CITY:759818:UNKNOWN:UNKNOWN&amp;q-room-0-children=0"
										class="clear-filters" id="clear-filters">필터 모두 지우기</a>
								</div>
							</div>
							<div class="filters-scroll-container">

								<fieldset class="" data-filter-name="name" id="filter-name">
									<h3 aria-expanded="true" role="button" tabindex="0"
										aria-controls="filter-name-contents">검색할 이름</h3>
									<div id="filter-name-contents" class="filter-contents">
										<label for="f-name" class="offscreen hotellabel">호텔명</label><span
											class="name-input-wrapper"><input type="text" value=""
											class="clearable" name="f-name" id="checkedKeyword"
											id="f-name" placeholder="호텔 이름…"
											onchange="fillteringToSearch();"></span>
									</div>
								</fieldset>
								<div data-field-collection="non-name">
									<fieldset class="checkbox-filters" data-filter-name="popular"
										id="filter-popular">
										<legend class="filter-legend">
											<h3 aria-expanded="true" role="button" tabindex="0">시설</h3>
										</legend>
										<div id="filter-popular-contents" class="filter-contents">
											<ul>
												<li><input type="checkbox" value="parking"
													name="facility" id="parking"
													onchange="fillteringToSearch();"><label
													class="hotellabel">주차장</label></li>
												<li><input type="checkbox" value="pool" name="facility"
													id="pool" onchange="fillteringToSearch();"><label
													class="hotellabel">수영장</label></li>
												<li><input type="checkbox" value="breakfast"
													name="facility" id="breakfast"
													onchange="fillteringToSearch();"><label
													class="hotellabel">식당</label></li>
												<li><input type="checkbox" value="fitness"
													name="facility" id="fitness"
													onchange="fillteringToSearch();"><label
													class="hotellabel">FITNESS</label></li>
												<li><input type="checkbox" value="wifi" name="facility"
													id="wifi" onchange="fillteringToSearch();"><label
													class="hotellabel">WIFI</label></li>
												<li><input type="checkbox" value="partyRoom"
													name="facility" id="partyRoom"
													onchange="fillteringToSearch();"><label
													class="hotellabel">파티 룸</label></li>
											</ul>
										</div>
									</fieldset>
									<fieldset class="widget-slider-enabled"
										data-os-int="filterInteraction" data-filter-name="price"
										id="filter-price">
										<legend class="filter-legend">
											<h3 aria-expanded="true" role="button" tabindex="0">1박
												요금</h3>
										</legend>
										<div id="filter-price-contents" class="filter-contents">
											<input name="f-price-currency-code"
												data-os-int="filterInteraction" type="hidden" value="KRW"><input
												name="f-price-multiplier" type="hidden"
												data-os-int="filterInteraction" value="1">
											<div class="input-wrapper">
												<label class="hotellabel" for="f-price-min"
													id="f-price-min-label">최저 (₩)</label><input type="text"
													aria-labelledby="f-price-min-label"
													data-os-int="filterInteraction" value="" name="f-price-min"
													id="f-price-min" placeholder="0" data-range-value="0"
													data-os-filter-min="" tabindex="-1">
											</div>
											<div class="input-wrapper">
												<label class="hotellabel" for="f-price-max"
													id="f-price-max-label">최고 (₩)</label><input type="text"
													aria-labelledby="f-price-max-label" value=""
													name="f-price-max" id="f-price-max" placeholder="1000000+"
													data-range-value="1000000" tabindex="-1">
											</div>
										</div>
										<div class="filter-contents">
											<div class="widget-slider">
												<div class="widget-slider-current-values">
													<label for="amount">Price range:</label> <input type="text"
														id="amount" readonly>
												</div>
												<div class="slider-padding">
													<div id="slider-range" class="widget-slider-cont"></div>
												</div>
											</div>
										</div>
									</fieldset>
									<fieldset class="widget-slider-enabled"
										data-filter-name="guest-rating" id="filter-guest-rating"
										data-os-int="filterInteraction">
										<h3 aria-expanded="true" role="button" tabindex="0"
											aria-controls="filter-guest-rating-contents">고객 평점</h3>
										<div class="filter-contents">
											<div class="widget-slider">
												<div class="widget-slider-current-values">
													<label for="amount2">guest rating range:</label> <input
														type="text" id="amount2" readonly>
												</div>
												<div class="slider-padding">
													<div id="slider-range2" class="widget-slider-cont"></div>
												</div>
											</div>
										</div>
									</fieldset>
									<fieldset class="checkbox-filters filter-collapsed"
										data-filter-name="accommodation-type"
										id="filter-accommodation-type">
										<div id="filter-accommodation-type-contents"
											class="filter-contents">
											<h3 aria-expanded="true" role="button" tabindex="0"
												aria-controls="filter-guest-rating-contents">여행 테마</h3>
											<ul>
												<li class=""><input type="checkbox" name="f-accid"
													id="f-accid-999999" aria-labelledby="f-label-accid-999999"
													data-os-int="filterInteraction" data-os-filter-id="999999"
													data-os-filter-val="도심 속 힐링" data-os-filter-index="0"
													class="vr-filter" value="도심 속 힐링"
													onchange="oneCheckbox(this); fillteringToSearch();"">
													<label class="hotellabel" for="f-accid-999999"
													id="f-label-accid-999999""> 도심 속 힐링</label></li>
												<li class=""><input type="checkbox" name="f-accid"
													id="f-accid-30" aria-labelledby="f-label-accid-30"
													data-os-int="filterInteraction" data-os-filter-id="30"
													data-os-filter-val="바다 낭만" data-os-filter-index="1"
													value="바다 낭만"
													onchange="oneCheckbox(this); fillteringToSearch();"><label
													class="hotellabel" for="f-accid-30" id="f-label-accid-30"">
														바다 낭만</label></li>
												<li class=""><input type="checkbox" name="f-accid"
													id="f-accid-7" aria-labelledby="f-label-accid-7"
													data-os-int="filterInteraction" data-os-filter-id="7"
													data-os-filter-val="hc3" data-os-filter-index="2"
													value="hc3"
													onchange="oneCheckbox(this); fillteringToSearch();"><label
													class="hotellabel" for="f-accid-7" id="f-label-accid-7">hc3</label></li>
												<li class=""><input type="checkbox" name="f-accid"
													id="f-accid-15" aria-labelledby="f-label-accid-15"
													data-os-int="filterInteraction" data-os-filter-id="15"
													data-os-filter-val="hc4" data-os-filter-index="3"
													value="hc4"
													onchange="oneCheckbox(this); fillteringToSearch();"><label
													class="hotellabel" for="f-accid-15" id="f-label-accid-15">hc4</label></li>
											</ul>
										</div>
									</fieldset>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xs-9" style="margin-top: 3%; margin-left: 0%;">
				<div class=" site-section bg-light" id="blog">
					<div class="resp-row">
						<div class="col-md-6">
							<h2 align="center">호텔 리스트</h2>
						</div>
						<div id="div-hotelList">
							<c:forEach items="${hotelList }" var="hotel">

								<c:if test="${fn:startsWith(hotel.key, 'hotel')}">
									<div class="col-md-8"
										style="margin-top: 5%; margin-bottom: 5%;">
										<div class="d-md-flex">
											<div class="col-md-3">
												<img src="${hotel.value.imageLink}"
													style="height: 100%; width: 100%;" />
											</div>
											<div class="col-md-6 hotelInfo1" style="margin-left: 3%;">
												<h2 class="heading">
													<a href="#">${hotel.value.hotelName }</a>
												</h2>
												<p class="meta">
													<em>Posted on</em> <a href="#">${hotel.value.hotelRegDate }</a>
													<span class="sep">&bullet;</span>
												</p>
												<p>${hotel.value.hotelTel }</p>
												<p>${hotel.value.hotelAddress }</p>

												<c:if
													test="${hotel.value.hotelFacility.facilityParking == 1 }">
													<img src="resources/client/images/parking.png" />
												</c:if>
												<c:if test="${hotel.value.hotelFacility.facilityPool == 1 }">
													<img src="resources/client/images/pool.png" />
												</c:if>
												<c:if
													test="${hotel.value.hotelFacility.facilityBreakfast == 1 }">
													<img src="resources/client/images/breakfast.png" />
												</c:if>
												<c:if
													test="${hotel.value.hotelFacility.facilityFitness == 1 }">
													<img src="resources/client/images/fitness.png" />
												</c:if>
												<c:if test="${hotel.value.hotelFacility.facilityWifi == 1 }">
													<img src="resources/client/images/wifi.png" />
												</c:if>
												<c:if
													test="${hotel.value.hotelFacility.facilityPartyRoom == 1 }">
													<img src="resources/client/images/party.png" />
												</c:if>
											</div>
											<div class="col-md-4 hotelInfo2" style="margin-left: 3%;">
												<p>
													<b>평점 : </b>${hotel.value.hotelStar }</p>
												<p>
													<b>가격 : </b>${hotel.value.lowestPrice }</p>
											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<div id="paging" align="center">
						<c:if test="${hotelList.count > 0 }">
							<c:set var="imsi"
								value="${hotelList.count % hotelList.pageSize == 0 ? 0: 1}" />
							<c:set var="pageCount"
								value="${hotelList.count / hotelList.pageSize + imsi}" />
							<fmt:parseNumber var="result" value="${(hotelList.pageNum-1) / hotelList.pageBlock}"
								integerOnly="true" />
							<c:set var="startPage" value="${result * hotelList.pageBlock + 1}" />
							<c:set var="endPage" value="${startPage + hotelList.pageBlock-1}" />
							<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}"></c:set>
							</c:if>
							<c:if test="${startPage > hotelList.pageBlock}">
								<a href="javascript:movePage('${startPage - hotelList.pageBlock}');">[이전]</a>
							</c:if>
							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<a href="javascript:movePage('${i}');">[${i}]</a>
       						</c:forEach>
							<c:if test="${endPage < pageCount}">
								<a href="javascript:movePage('${startPage  + hotelList.pageBlock}');">[다음]</a>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- <script src="resources/client/js/slider.js"></script> -->

	<script>
		$(function() {
			$("#slider-range")
					.slider(
							{
								range : true,
								min : 0,
								max : 100000,
								step : 10000,
								values : [ 0, 1000000 ],
								slide : function(event, ui) {
									$("#amount").val(
											"₩" + ui.values[0] + " ~ ₩"
													+ ui.values[1]);
									fillteringToSearch();
								}
							});
			$("#amount").val(
					"₩" + $("#slider-range").slider("values", 0) + " ~ ₩"
							+ $("#slider-range").slider("values", 1));
		});
	</script>
	<script>
		$(function() {
			$("#slider-range2").slider({
				range : true,
				min : 1,
				max : 5,
				values : [ 1, 5 ],
				slide : function(event, ui) {
					$("#amount2").val(ui.values[0] + " ~ " + ui.values[1]);
					fillteringToSearch();
				}

			});
			$("#amount2").val(
					$("#slider-range2").slider("values", 0) + " ~ "
							+ $("#slider-range2").slider("values", 1));
		});
	</script>
</body>
</html>