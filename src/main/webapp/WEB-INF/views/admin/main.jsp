<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row bg-title">
			<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
				<h4 class="page-title">Dashboard</h4>
			</div>
			<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
				<ol class="breadcrumb">
					
				</ol>
			</div>

		</div>

		<!--
		by지홍 main.jsp 컨덴츠 목록
		
		총 호텔 수
		총 예약건 수
		총 회원 수
		--
		월별 예약건수(년도 드롭다운 검색)
		월별 매출(년도 드롭다운 검색)(추가 템플릿 삽입)
		--
		최근 예약 (거래)
		최근 리뷰(코멘트) 
		
		숙소 타입(컨셉) 별 예약률
		 -->

		<div class="row">
			<div class="col-lg-4 col-sm-6 col-xs-12">
				<div class="white-box analytics-info">
					<h3 class="box-title">Total Hotel</h3>
					<ul class="list-inline two-part">
						<li>
							<div id="sparklinedash"></div>
						</li>
						<li class="text-right"><i class="ti-arrow-up text-success"></i>
							<span class="counter text-success">${hotelCount}</span></li>
						<!--총 호텔 수 넘겨받기  -->
					</ul>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 col-xs-12">
				<div class="white-box analytics-info">
					<h3 class="box-title">Total Reservation</h3>
					<ul class="list-inline two-part">
						<li>
							<div id="sparklinedash2"></div>
						</li>
						<li class="text-right"><i class="ti-arrow-up text-purple"></i>
							<span class="counter text-purple">${resCount}</span></li>
						<!--총 예약완료 수 넘겨받기  -->
					</ul>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 col-xs-12">
				<div class="white-box analytics-info">
					<h3 class="box-title">Total User</h3>
					<ul class="list-inline two-part">
						<li>
							<div id="sparklinedash3"></div>
						</li>
						<li class="text-right"><i class="ti-arrow-up text-info"></i>
							<span class="counter texㅁt-info">${userCount}</span></li>
						<!-- 총 회원 수 넘겨받기  -->
					</ul>
				</div>
			</div>
		</div>

		<!--//----------------------------월별 예약건수,매출(매출 콤보박스, 2020년,2019년은 선으로 표시)  -->

		<div class="row">

			<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
				<div class="white-box">
					<div class="preloader">
						<svg class="circular" viewBox="25 25 50 50">
				            <circle class="path" cx="50" cy="50" r="20" fill="none"
								stroke-width="2" stroke-miterlimit="10" />
				        </svg>
					</div>
					<h3 class="box-title">Monthly Reservation</h3>

					<!--차트 콤보박스  -->
					<h4>
						<select name="option" id="option" onchange="change()">
							<option value="Reservation" selected>Reservation Sales</option>
							<option value="Expense">Expense</option>
						</select>
					</h4>

					<!----------------------차트 데이터 ------------------------------------------- -->
					<!--2020년 데이터  -->
					<c:set var="cset" value="0" />
					<c:forEach var="var1" items="${getData}" begin="0" end="0">
						<c:forEach var="var2" items="${var1}" begin="0" end="11">
							<input type="hidden" id="val${cset}" value="${var2}" />
							<%-- <c:out value="${var2}"></c:out> --%>
							<c:set var="cset" value="${cset + 1 }" />
						</c:forEach>
					</c:forEach>
					<br>
					<!--2019년 데이터  -->
					<c:forEach var="var1" items="${getData}" begin="1" end="1">
						<c:forEach var="var2" items="${var1}" begin="0" end="11">
							<input type="hidden" id="cval${cset}" value="${var2}" />
							<%-- <c:out value="${var2}"></c:out> --%>
							<c:set var="cset" value="${cset + 1 }" />
						</c:forEach>
					</c:forEach>

					<!-- ---------------------------------------------------------------------- -->

					<ul class="list-inline text-right">
						<li>
							<h5>
								<i class="fa fa-circle m-r-5 text-info"></i>2020
							</h5>
						</li>
						<li>
							<h5>
								<i class="fa fa-circle m-r-5 text-inverse"></i>2019
							</h5>
						</li>
					</ul>
					<div id="ct-box">
						<div id="ct-visits" style="height: 405px;"></div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 최근 예약 -->
		<div class="row">
			<div class="col-md-12 col-lg-12 col-sm-12">
				<div class="white-box">

					<h3 class="box-title">Recent reservations</h3>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>ID</th>
									<th>hotel</th>
									<th>room</th>
									<th>DATE</th>
									<th>PRICE</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="no" value="1" />
								<c:forEach var="re" items="${reservation}">
									<tr>
										<td>${no }</td>
										<td class="txt-oflo"><a href="profile.mdo?id=${re.clientId }">${re.clientId}</a></td>
										<td>${re.hotelName }</td>
										<td>${re.roomName }</td>
										<td class="txt-oflo">${re.reservationInDate}~
											${re.reservationOutDate}</td>
										<td><span class="text-info">${re.reservationPayment}</span></td>
									</tr>

									<c:set var="no" value="${no + 1 }" />
								</c:forEach>


								<!-- <tr>
									<td>6</td>
									<td class="txt-oflo">Digital Agency PSD</td>
									<td>SALE</td>
									<td class="txt-oflo">April 23, 2017</td>
									<td><span class="text-danger">-$14</span></td>
								</tr>
								<tr>
									<td>7</td>
									<td class="txt-oflo">Helping Hands WP Theme</td>
									<td>MEMBER</td>
									<td class="txt-oflo">April 22, 2017</td>
									<td><span class="text-success">$64</span></td>
								</tr> -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 최근 리뷰 -->
		<div class="row">
			<div class="col-md-12 col-lg-8 col-sm-12">
				<div class="white-box">
					<h3 class="box-title">Recent Comments</h3>
					<div class="comment-center p-t-10">
						<!-- <div class="comment-body">
							<div class="user-img">
								<img
									src="resources/admin/vendor/plugins/images/users/pawandeep.jpg"
									alt="user" class="img-circle">
							</div>
							<div class="mail-contnet">
								<h5>Pavan kumar</h5>
								<span class="time">10:20 AM 20 may 2016</span> <br /> <span
									class="mail-desc">Donec ac condimentum massa. Etiam
									pellentesque pretium lacus. Phasellus ultricies dictum
									suscipit. Aenean commodo dui pellentesque molestie feugiat.
									Aenean commodo dui pellentesque molestie feugiat</span> <a
									href="javacript:void(0)"
									class="btn btn btn-rounded btn-default btn-outline m-r-5"><i
									class="ti-check text-success m-r-5"></i>Approve</a><a
									href="javacript:void(0)"
									class="btn-rounded btn btn-default btn-outline"><i
									class="ti-close text-danger m-r-5"></i> Reject</a>
							</div>
						</div>-->
						<c:forEach var="re" items="${review}">
							<div class="comment-body">
								<div class="user-img">
								<img
									src="${re.imageLink }"
									alt="user" class="img-circle">
								</div>
								<div class="mail-contnet">
									<h5><a href="profile.mdo?id=${re.clientId }">${re.clientId}</a></h5>
									<span class="time"> ${re.reviewWriteDate} </span> <br /> <span
										class="mail-desc">${re.reviewContent }</span>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="panel">
					<div class="sk-chat-widgets">
						<div class="panel panel-default">

							<div class="panel-heading">Hotel Reservation Rate</div>
							<div class="panel-body">
							
							<!--파이차트 데이터 ---------------------------------------------------->
							
								<c:set var="cset" value="0"></c:set>
								<c:forEach var="var" items="${conceptarray}">
								<input type="hidden" id="hc${cset}" value="${var.hotelConcept}" />
								<input type="hidden" id="rhc${cset }" value="${var.reshotelcount}" />
								<c:set var="cset" value="${cset + 1 }" />
								</c:forEach>
							<!----------------------------------------------------------------->	
								<script type="text/javascript"
									src="https://www.gstatic.com/charts/loader.js"></script>
								<script>
									//구글차트
								</script>
								<body>
									<div id="piChart"></div>
								</body>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>