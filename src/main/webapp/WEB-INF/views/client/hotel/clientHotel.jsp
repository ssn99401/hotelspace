<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="resources/client/css/HotelBody.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet"
	href="resources/client/css/jquery-ui.css">
</head>
<body>
	<header>
		<c:import url="/clientHeader.do" />
	</header>
	<div class="resp-row hotelbody" id="search-result">
	<div class="resp-col aside" id="slidePanel" style="">
		<div id="filters" class="filters aside-map-show">
			<div class="search-header-link aside-map">
				<a href="#" id="search-map-link" class="search-header-link-body link-map"><span><b>지도에서 보기</b></span></a>
			</div>
			<div class="filters-overlay-close">
				<div class="narrow-results-header-container">
					<h2 class="narrow-results-header">검색 결과 필터링:</h2>
				</div>
				<div class="reset-filters clear-filters-link" style="display: none;">
					<a
						href="?destination-id=759818&amp;q-check-out=2020-08-18&amp;q-destination=%EC%84%9C%EC%9A%B8,%20%ED%95%9C%EA%B5%AD&amp;q-room-0-adults=2&amp;q-rooms=1&amp;q-check-in=2020-08-17&amp;resolved-location=CITY:759818:UNKNOWN:UNKNOWN&amp;q-room-0-children=0"
						class="clear-filters" id="clear-filters">필터 모두 지우기</a>
				</div>
			</div>
			<div class="filters-scroll-container">
				<form method="GET" autocomplete="off" class="form-base"
					id="filters-form">
					<fieldset class="" data-filter-name="name" id="filter-name">
						<h3 aria-expanded="true" role="button" tabindex="0"
							aria-controls="filter-name-contents">검색할 이름</h3>
						<div id="filter-name-contents" class="filter-contents">
							<label for="f-name" class="offscreen hotellabel">숙박 시설 이름</label><span
								class="name-input-wrapper"><input type="text" value=""
								class="clearable" name="f-name" id="f-name"
								placeholder="숙박 시설 이름…"></span>
							<button type="submit" id="f-name-cta" name="nameSubmit" class="icon cta cta-control ">
								<span class="offscreen">숙박 시설 이름으로 검색 결과 필터링</span>
								<i class="xi-angle-right"></i>
							</button>
						</div>
					</fieldset>
					<div data-field-collection="non-name">
						<fieldset class="checkbox-filters" data-filter-name="popular"
							id="filter-popular">
							<legend class="filter-legend">
								<h3 aria-expanded="true" role="button" tabindex="0">인기 필터</h3>
							</legend>
							<div id="filter-popular-contents" class="filter-contents">
								<ul>
									<li class=""><input type="checkbox" value="2048"
										data-id="f-facilities-2048" id="f-popular-2048"
										aria-labelledby="f-label-popular-2048" name="f-amid"
										data-os-int="filterInteraction" data-os-filter-id="2048"
										data-os-filter-val="무료 아침 식사" data-os-filter-index="0"><label class="hotellabel"
										for="f-popular-2048" id="f-label-popular-2048">무료 아침
											식사</label></li>
									<li class=""><input type="checkbox" value="128"
										data-id="f-facilities-128" id="f-popular-128"
										aria-labelledby="f-label-popular-128" name="f-amid"
										data-os-int="filterInteraction" data-os-filter-id="128"
										data-os-filter-val="수영장" data-os-filter-index="1"><label class="hotellabel"
										for="f-popular-128" id="f-label-popular-128">수영장</label></li>
									<li class=""><input type="checkbox" value="527"
										data-id="f-facilities-527" id="f-popular-527"
										aria-labelledby="f-label-popular-527" name="f-amid"
										data-os-int="filterInteraction" data-os-filter-id="527"
										data-os-filter-val="무료 WiFi" data-os-filter-index="2"><label class="hotellabel"
										for="f-popular-527" id="f-label-popular-527">무료 WiFi</label></li>
									<li class=""><input type="checkbox" value="134234112"
										data-id="f-facilities-134234112" id="f-popular-134234112"
										aria-labelledby="f-label-popular-134234112" name="f-amid"
										data-os-int="filterInteraction" data-os-filter-id="134234112"
										data-os-filter-val="주차(무료)" data-os-filter-index="3"><label class="hotellabel"
										for="f-popular-134234112" id="f-label-popular-134234112">주차(무료)</label></li>
									<li class=""><input type="checkbox" value="64"
										data-id="f-facilities-64" id="f-popular-64"
										aria-labelledby="f-label-popular-64" name="f-amid"
										data-os-int="filterInteraction" data-os-filter-id="64"
										data-os-filter-val="반려동물 동반 가능" data-os-filter-index="4"><label class="hotellabel"
										for="f-popular-64" id="f-label-popular-64">반려동물 동반 가능</label></li>
								</ul>
							</div>
						</fieldset>
						<fieldset class="widget-slider-enabled"
							data-os-int="filterInteraction" data-filter-name="price"
							id="filter-price">
							<legend class="filter-legend">
								<h3 aria-expanded="true" role="button" tabindex="0">1박 요금</h3>
							</legend>
							<div id="filter-price-contents" class="filter-contents">
								<input name="f-price-currency-code"
									data-os-int="filterInteraction" type="hidden" value="KRW"><input
									name="f-price-multiplier" type="hidden"
									data-os-int="filterInteraction" value="1">
								<div class="input-wrapper">
									<label class="hotellabel" for="f-price-min" id="f-price-min-label">최저 (₩)</label><input
										type="text" aria-labelledby="f-price-min-label"
										data-os-int="filterInteraction" value="" name="f-price-min"
										id="f-price-min" placeholder="0" data-range-value="0"
										data-os-filter-min="" tabindex="-1">
								</div>
								<div class="input-wrapper">
									<label class="hotellabel" for="f-price-max" id="f-price-max-label">최고 (₩)</label><input
										type="text" aria-labelledby="f-price-max-label" value=""
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
										<div class="slider-padding"><div id="slider-range" class="widget-slider-cont"></div></div>
								</div>
							</div>
						</fieldset>
						<fieldset class="checkbox-filters inline-touch-controls "
							data-filter-name="star-rating" id="filter-star-rating">
							<legend class="filter-legend">
								<h3 aria-expanded="true" role="button" tabindex="0">숙박 시설
									등급</h3>
							</legend>
							<div id="filter-star-rating-contents" class="filter-contents">
								<ul>
									<li class=""><input type="checkbox" role="checkbox"
										name="f-star-rating" value="5" id="f-star-rating-5"
										aria-labelledby="f-label-star-rating-5"
										data-os-int="filterInteraction" data-os-filter-val="5"
										data-os-filter-index="0"><label class="hotellabel" for="f-star-rating-5"
										id="f-label-star-rating-5"><span class="offscreen"
											aria-label="5성급">5 </span><span class="star-rating">5성급</span></label></li>
									<li class=""><input type="checkbox" role="checkbox"
										name="f-star-rating" value="4" id="f-star-rating-4"
										aria-labelledby="f-label-star-rating-4"
										data-os-int="filterInteraction" data-os-filter-val="4"
										data-os-filter-index="1"><label class="hotellabel" for="f-star-rating-4"
										id="f-label-star-rating-4"><span class="offscreen"
											aria-label="4성급">4 </span><span class="star-rating">4성급</span></label></li>
									<li class=""><input type="checkbox" role="checkbox"
										name="f-star-rating" value="3" id="f-star-rating-3"
										aria-labelledby="f-label-star-rating-3"
										data-os-int="filterInteraction" data-os-filter-val="3"
										data-os-filter-index="2"><label class="hotellabel" for="f-star-rating-3"
										id="f-label-star-rating-3"><span class="offscreen"
											aria-label="3성급">3 </span><span class="star-rating">3성급</span></label></li>
									<li class=""><input type="checkbox" role="checkbox"
										name="f-star-rating" value="2" id="f-star-rating-2"
										aria-labelledby="f-label-star-rating-2"
										data-os-int="filterInteraction" data-os-filter-val="2"
										data-os-filter-index="3"><label class="hotellabel" for="f-star-rating-2"
										id="f-label-star-rating-2"><span class="offscreen"
											aria-label="2성급">2 </span><span class="star-rating">2성급</span></label></li>
									<li class=""><input type="checkbox" role="checkbox"
										name="f-star-rating" value="1" id="f-star-rating-1"
										aria-labelledby="f-label-star-rating-1"
										data-os-int="filterInteraction" data-os-filter-val="1"
										data-os-filter-index="4"><label class="hotellabel" for="f-star-rating-1"
										id="f-label-star-rating-1"><span class="offscreen"
											aria-label="1성급">1 </span><span class="star-rating">1성급</span></label></li>
								</ul>
							</div>
						</fieldset>
						<fieldset class="widget-slider-enabled"
							data-filter-name="guest-rating" id="filter-guest-rating"
							data-os-int="filterInteraction">
							<h3 aria-expanded="true" role="button" tabindex="0"
								aria-controls="filter-guest-rating-contents">고객 평점</h3>
							<!-- <div id="filter-guest-rating-contents" class="filter-contents">
								<div class="input-wrapper">
									<label class="hotellabel" for="f-guest-rating-min" id="f-guest-rating-min-label">최저</label><input
										type="number" value="" name="f-guest-rating-min"
										id="f-guest-rating-min" placeholder="0" data-range-value="0"
										min="0" max="10" step="0.5" tabindex="-1">
								</div>
								<div class="input-wrapper">
									<label class="hotellabel" for="f-guest-rating-max" id="f-guest-rating-max-label">최고</label><input
										type="number" value="" name="f-guest-rating-max"
										id="f-guest-rating-max" placeholder="10" data-range-value="10"
										min="0" max="10" step="0.5" tabindex="-1">
								</div>
							</div> -->
							<!-- <div class="filter-contents">
								<div class="widget-slider">
									<div class="widget-slider-current-values">
										<span class="min">0</span> ~ <span class="max">10</span>
									</div>
									<div class="widget-slider-cont" data-os-int="filterInteraction"
										data-os-filter-min="0" data-os-filter-max="10">
										<div class="widget-slider-highlight"
											data-os-int="filterInteraction"
											style="margin-left: 0%; margin-right: 0%;"></div>
										<div tabindex="0"
											class="cta cta-control widget-slider-handle widget-slider-handle-min"
											role="slider" aria-valuemin="0"
											data-os-int="filterInteraction" aria-valuemax="10"
											aria-labelledby="f-guest-rating-min-label"
											aria-controls="f-guest-rating-min" aria-valuenow="0"
											style="left: 0%;"><i class="xi-angle-left-min"></i></div>
										<div tabindex="0"
											class="cta cta-control widget-slider-handle widget-slider-handle-max"
											role="slider" aria-valuemin="0"
											data-os-int="filterInteraction" aria-valuemax="10"
											aria-labelledby="f-guest-rating-max-label"
											aria-controls="f-guest-rating-max" aria-valuenow="10"
											style="left: 100%;"><i class="xi-angle-right-min"></i></div>
									</div>
								</div>
							</div> -->
							<div class="filter-contents">
								<div class="widget-slider">
										<div class="widget-slider-current-values">
											<label for="amount2">guest rating range:</label> <input type="text"
												id="amount2" readonly>
										</div>
										<div class="slider-padding"><div id="slider-range2" class="widget-slider-cont"></div></div>
								</div>
							</div>
						</fieldset>
						<fieldset class="checkbox-filters filter-collapsed"
							data-filter-name="accommodation-type"
							id="filter-accommodation-type">
							<legend class="filter-legend">
								<h3 aria-expanded="false" role="button" tabindex="0">숙박 시설
									유형</h3>
							</legend>
							<div id="filter-accommodation-type-contents"
								class="filter-contents">
								<ul>
									<li class=""><input type="checkbox" name="f-accid"
										value="999999" id="f-accid-999999"
										aria-labelledby="f-label-accid-999999"
										data-os-int="filterInteraction" data-os-filter-id="999999"
										data-os-filter-val="주택 및 아파트" data-os-filter-index="0"
										class="vr-filter"><label class="hotellabel" for="f-accid-999999"
										id="f-label-accid-999999">주택 및 아파트</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="30" id="f-accid-30" aria-labelledby="f-label-accid-30"
										data-os-int="filterInteraction" data-os-filter-id="30"
										data-os-filter-val="게스트하우스" data-os-filter-index="1"><label class="hotellabel"
										for="f-accid-30" id="f-label-accid-30">게스트하우스</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="7" id="f-accid-7" aria-labelledby="f-label-accid-7"
										data-os-int="filterInteraction" data-os-filter-id="7"
										data-os-filter-val="모텔" data-os-filter-index="2"><label class="hotellabel"
										for="f-accid-7" id="f-label-accid-7">모텔</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="15" id="f-accid-15" aria-labelledby="f-label-accid-15"
										data-os-int="filterInteraction" data-os-filter-id="15"
										data-os-filter-val="아파트" data-os-filter-index="3"><label class="hotellabel"
										for="f-accid-15" id="f-label-accid-15">아파트</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="20" id="f-accid-20" aria-labelledby="f-label-accid-20"
										data-os-int="filterInteraction" data-os-filter-id="20"
										data-os-filter-val="아파트식 호텔" data-os-filter-index="4"><label class="hotellabel"
										for="f-accid-20" id="f-label-accid-20">아파트식 호텔</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="8" id="f-accid-8" aria-labelledby="f-label-accid-8"
										data-os-int="filterInteraction" data-os-filter-id="8"
										data-os-filter-val="인/여관" data-os-filter-index="5"><label class="hotellabel"
										for="f-accid-8" id="f-label-accid-8">인/여관</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="43" id="f-accid-43" aria-labelledby="f-label-accid-43"
										data-os-int="filterInteraction" data-os-filter-id="43"
										data-os-filter-val="캡슐 호텔" data-os-filter-index="6"><label class="hotellabel"
										for="f-accid-43" id="f-label-accid-43">캡슐 호텔</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="25" id="f-accid-25" aria-labelledby="f-label-accid-25"
										data-os-int="filterInteraction" data-os-filter-id="25"
										data-os-filter-val="펜션" data-os-filter-index="7"><label class="hotellabel"
										for="f-accid-25" id="f-label-accid-25">펜션</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="12" id="f-accid-12" aria-labelledby="f-label-accid-12"
										data-os-int="filterInteraction" data-os-filter-id="12"
										data-os-filter-val="호스텔" data-os-filter-index="8"><label class="hotellabel"
										for="f-accid-12" id="f-label-accid-12">호스텔</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="1" id="f-accid-1" aria-labelledby="f-label-accid-1"
										data-os-int="filterInteraction" data-os-filter-id="1"
										data-os-filter-val="호텔" data-os-filter-index="9"><label class="hotellabel"
										for="f-accid-1" id="f-label-accid-1">호텔</label></li>
									<li class=""><input type="checkbox" name="f-accid"
										value="4" id="f-accid-4" aria-labelledby="f-label-accid-4"
										data-os-int="filterInteraction" data-os-filter-id="4"
										data-os-filter-val="홀리데이 홈" data-os-filter-index="10"><label class="hotellabel"
										for="f-accid-4" id="f-label-accid-4">홀리데이 홈</label></li>
								</ul>
							</div>
						</fieldset>
						<fieldset class="checkbox-filters filter-collapsed"
							data-filter-name="guided-categories"
							id="filter-guided-categories" style="display: none;">
							<legend class="filter-legend">
								<h3 aria-expanded="false" role="button" tabindex="0"></h3>
							</legend>
							<div id="filter-accessibility-contents" class="filter-contents">
								<ul>
									<li class=""><input type="checkbox"
										name="g-quality-type-id" value="-2120873974"
										id="g-quality-type-id--2120873974"
										data-os-int="filterInteraction"
										data-os-filter-id="-2120873974" data-os-filter-val="럭셔리"
										data-os-filter-index="0"><label class="hotellabel">럭셔리</label></li>
									<li class=""><input type="checkbox"
										name="g-quality-type-id" value="-1228742696"
										id="g-quality-type-id--1228742696"
										data-os-int="filterInteraction"
										data-os-filter-id="-1228742696" data-os-filter-val="최고 평점"
										data-os-filter-index="1"><label class="hotellabel">최고 평점</label></li>
									<li class=""><input type="checkbox"
										name="g-quality-type-id" value="-1828091917"
										id="g-quality-type-id--1828091917"
										data-os-int="filterInteraction"
										data-os-filter-id="-1828091917" data-os-filter-val="최고 평점"
										data-os-filter-index="2"><label class="hotellabel">최고 평점</label></li>
									<li class=""><input type="checkbox"
										name="g-amenity-type-id" value="999223768"
										id="g-amenity-type-id-999223768"
										data-os-int="filterInteraction" data-os-filter-id="999223768"
										data-os-filter-val="레스토랑" data-os-filter-index="3"><label class="hotellabel">레스토랑</label></li>
									<li class=""><input type="checkbox"
										name="g-amenity-type-id" value="-1652835883"
										id="g-amenity-type-id--1652835883"
										data-os-int="filterInteraction"
										data-os-filter-id="-1652835883" data-os-filter-val="무료 주차"
										data-os-filter-index="4"><label class="hotellabel">무료 주차</label></li>
									<li class=""><input type="checkbox"
										name="g-amenity-type-id" value="-666540986"
										id="g-amenity-type-id--666540986"
										data-os-int="filterInteraction" data-os-filter-id="-666540986"
										data-os-filter-val="회의 시설" data-os-filter-index="5"><label class="hotellabel">회의
											시설</label></li>
									<li class=""><input type="checkbox"
										name="g-property-type-id" value="1621362132"
										id="g-property-type-id-1621362132"
										data-os-int="filterInteraction" data-os-filter-id="1621362132"
										data-os-filter-val="호텔" data-os-filter-index="6"><label class="hotellabel">호텔</label></li>
									<li class=""><input type="checkbox"
										name="g-property-type-id" value="380257727"
										id="g-property-type-id-380257727"
										data-os-int="filterInteraction" data-os-filter-id="380257727"
										data-os-filter-val="주택 및 아파트" data-os-filter-index="7"><label class="hotellabel">주택
											및 아파트</label></li>
									<li class="disabled "><input type="checkbox"
										name="g-property-type-id" value="-1700295402"
										id="g-property-type-id--1700295402"
										data-os-int="filterInteraction"
										data-os-filter-id="-1700295402" data-os-filter-val="리조트"
										data-os-filter-index="8" disabled="disabled"><label class="hotellabel">리조트</label></li>
									<li class=""><input type="checkbox"
										name="g-traveller-type-id" value="-1564604869"
										id="g-traveller-type-id--1564604869"
										data-os-int="filterInteraction"
										data-os-filter-id="-1564604869" data-os-filter-val="가족 여행"
										data-os-filter-index="9"><label class="hotellabel">가족 여행</label></li>
									<li class=""><input type="checkbox"
										name="g-traveller-type-id" value="236573259"
										id="g-traveller-type-id-236573259"
										data-os-int="filterInteraction" data-os-filter-id="236573259"
										data-os-filter-val="혼자 여행" data-os-filter-index="10"><label class="hotellabel">혼자
											여행</label></li>
									<li class=""><input type="checkbox"
										name="g-traveller-type-id" value="1982166108"
										id="g-traveller-type-id-1982166108"
										data-os-int="filterInteraction" data-os-filter-id="1982166108"
										data-os-filter-val="아동 동반 단체 여행" data-os-filter-index="11"><label class="hotellabel">아동
											동반 단체 여행</label></li>
								</ul>
							</div>
						</fieldset>
						<fieldset class="checkbox-filters filter-collapsed"
							data-filter-name="travellerTypes" id="filter-travellerTypes"
							style="display: none;">
							<legend class="filter-legend">
								<h3 aria-expanded="false" role="button" tabindex="0"></h3>
							</legend>
							<div id="filter-travellerTypes-contents" class="filter-contents">
								<ul>
									<li class=""><input type="checkbox"
										name="f-traveller-type-id" value="-120541382"
										id="f-travellerTypes--120541382"
										aria-labelledby="f-label-travellerTypes--120541382"
										data-os-int="filterInteraction" data-os-filter-id="-120541382"
										data-os-filter-val="2인 여행" data-os-filter-index="0"><label class="hotellabel"
										for="f-travellerTypes--120541382"
										id="f-label-travellerTypes--120541382">2인 여행</label></li>
									<li class=""><input type="checkbox"
										name="f-traveller-type-id" value="-1564604869"
										id="f-travellerTypes--1564604869"
										aria-labelledby="f-label-travellerTypes--1564604869"
										data-os-int="filterInteraction"
										data-os-filter-id="-1564604869" data-os-filter-val="가족 여행"
										data-os-filter-index="1"><label class="hotellabel"
										for="f-travellerTypes--1564604869"
										id="f-label-travellerTypes--1564604869">가족 여행</label></li>
									<li class=""><input type="checkbox"
										name="f-traveller-type-id" value="-219021175"
										id="f-travellerTypes--219021175"
										aria-labelledby="f-label-travellerTypes--219021175"
										data-os-int="filterInteraction" data-os-filter-id="-219021175"
										data-os-filter-val="단체 여행" data-os-filter-index="2"><label class="hotellabel"
										for="f-travellerTypes--219021175"
										id="f-label-travellerTypes--219021175">단체 여행</label></li>
									<li class=""><input type="checkbox"
										name="f-traveller-type-id" value="1982166108"
										id="f-travellerTypes-1982166108"
										aria-labelledby="f-label-travellerTypes-1982166108"
										data-os-int="filterInteraction" data-os-filter-id="1982166108"
										data-os-filter-val="아동 동반 단체 여행" data-os-filter-index="3"><label class="hotellabel"
										for="f-travellerTypes-1982166108"
										id="f-label-travellerTypes-1982166108">아동 동반 단체 여행</label></li>
									<li class=""><input type="checkbox"
										name="f-traveller-type-id" value="236573259"
										id="f-travellerTypes-236573259"
										aria-labelledby="f-label-travellerTypes-236573259"
										data-os-int="filterInteraction" data-os-filter-id="236573259"
										data-os-filter-val="혼자 여행" data-os-filter-index="4"><label class="hotellabel"
										for="f-travellerTypes-236573259"
										id="f-label-travellerTypes-236573259">혼자 여행</label></li>
								</ul>
							</div>
						</fieldset>
					</div>
					<fieldset class="applied" data-filter-name="hidden"
						id="filter-hidden">
						<input type="hidden" name="sort-order" value="BEST_SELLER"><input
							type="hidden" name="destination-id" value="759818"><input
							type="hidden" name="q-destination" value="서울, 한국"><input
							type="hidden" name="q-check-in" value="2020-08-17"><input
							type="hidden" name="q-check-out" value="2020-08-18"><input
							type="hidden" name="q-rooms" value="1"><input
							type="hidden" name="q-room-0-adults" value="2"><input
							type="hidden" name="q-room-0-children" value="0"><input
							type="hidden" name="f-lid" id="f-lid-generated" value=""><input
							type="hidden" name="include-filters" value="true"><input
							type="hidden" name="vrFilterClicked" value=""><input
							type="hidden" name="guidedFilterClickedId" value="">
					</fieldset>
					<div class="filters-submit-row">
						<button class="cta">선택 사항 적용</button>
					</div>
				</form>
			</div>
		</div>
		<meso-display-ad class="ad-div"
			mediaquery="only screen and (min-width: 849px)" slot="L1_160x600"
			uci="L1_160x600"
			experiments="DISPLAY_AD_PERF,MeSo_GPT_SRA,native_brand_listing"
			width="160" height="600"
			path="/23171577/hotels.kr_ko/hotels/results/L1"></meso-display-ad>
		<div id="adLEFT2_placeholder"
			style="width: 160px; height: 600px; margin: 20px 32px 0px; z-index: -1; visibility: hidden; top: -9999px; display: block;"></div>
		<meso-display-ad class="ad-div"
			mediaquery="only screen and (min-width: 849px)" slot="L2_160x600"
			uci="L2_160x600"
			experiments="DISPLAY_AD_PERF,MeSo_GPT_SRA,native_brand_listing"
			width="160" height="600"
			path="/23171577/hotels.kr_ko/hotels/results/L2"
			style="position: absolute; top: 1696px; margin-top: 0px;"></meso-display-ad>
	</div>
	</div>
	
	<footer>
		<c:import url="/clientFooter.do" />
	</footer>
	
	<script src="resources/client/js/jquery-3.3.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- <script src="resources/client/js/slider.js"></script> -->
	
	<script>
		$(function() {
			$("#slider-range")
					.slider(
							{
								range : true,
								min : 0,
								max : 1000000,
								values : [ 0, 1000000 ],
								slide : function(event, ui) {
									$("#amount").val(
											"₩" + ui.values[0] + " ~ ₩"
													+ ui.values[1]);
								}
							});
			$("#amount").val(
					"₩" + $("#slider-range").slider("values", 0) + " ~ ₩"
							+ $("#slider-range").slider("values", 1));
		});
	</script>
	<script>
	$(function() {
		$("#slider-range2")
				.slider(
						{
							range : true,
							min : 1,
							max : 5,
							values : [ 1, 5 ],
							slide : function(event, ui) {
								$("#amount2").val(
										ui.values[0] + " ~ "
												+ ui.values[1]);
							}
						});
		$("#amount2").val(
				$("#slider-range2").slider("values", 0) + " ~ "
						+ $("#slider-range2").slider("values", 1));
	});
	</script>
</body>
</html>