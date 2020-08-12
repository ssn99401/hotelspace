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
	<div class="hero-wrap js-fullheight"
		style="background-image: url('resources/client/vendor/images/mainview8.jpg');"
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
					<form action="#" class="appointment-form">
						<h4 class="mb-3">어디로 떠나고 싶으신가요?</h4>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="ex) 서울,신라호텔">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="input-wrap">
										<div class="icon">
											<span class="ion-md-calendar"></span>
										</div>
										<input type="date" value="Check-in"
											class="input-group date"
											placeholder="Check-in">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<div class="input-wrap">
										<div class="icon">
											<span class="ion-md-calendar"></span>
										</div>
										<input type="date"
											class="input-group date"
											placeholder="Check-out">
									</div>
								</div>
							</div>
								<div class="col-md-6">
									<div class="form-group">
			    					<div class="form-field">
	          					<div class="select-wrap">
	                      <div class="icon"><span class="fa fa-chevron-down"></span></div>
	                      <select name="people" id="people" class="form-control">
	                      	<option value="">인원</option>
	                        <option value="">1</option>
	                        <option value="">2</option>
	                        <option value="">3</option>
	                        <option value="">4</option>
	                        <option value="">5</option>
	                        <option value="">6</option>
	                            <option value="">7</option>
	                              <option value="">8</option>
	                                <option value="">9</option>
	                                  <option value="">9명이상</option>
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
						<div class="img"
							style="background-image: url(resources/client/vendor/images/seoul.jpg);"></div>
						<div class="media-body py-4 px-3">
							<h3 class="heading">서울 특별시</h3>
							<p>서울 도심 안에있는 최고 인기호텔</p>
							<p>
								<a href="#" class="btn btn-primary">찾아보기</a>
							</p>
						</div>
					</div>
				</div>
				<div
					class="col-md-4 d-flex services align-self-stretch px-4 ftco-animate">
					<div class="d-block services-wrap text-center">
						<div class="img"
							style="background-image: url(resources/client/vendor/images/busan1.jpg);"></div>
						<div class="media-body py-4 px-3">
							<h3 class="heading">부산 광역시</h3>
							<p>제2의 수도 부산의 특별한 매력이 담겨있는 호텔</p>
							<p>
								<a href="#" class="btn btn-primary">찾아보기</a>
							</p>
						</div>
					</div>
				</div>
				<div
					class="col-md-4 d-flex services align-self-stretch px-4 ftco-animate">
					<div class="d-block services-wrap text-center">
						<div class="img"
							style="background-image: url(resources/client/vendor/images/jeju.jpg);"></div>
						<div class="media-body py-4 px-3">
							<h3 class="heading">제주도</h3>
							<p>우리나라의 아름다운 섬 제주도 호텔</p>
							<p>
								<a href="#" class="btn btn-primary">찾아보기</a>
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
				<div class="col-lg-6">
					<div class="room-wrap d-md-flex">
						<a href="#" class="img"
							style="background-image: url(resources/client/vendor/images/good1.jpg);"></a>
						<div class="half left-arrow d-flex align-items-center">
							<div class="text p-4 p-xl-5 text-center">
								<p class="star mb-0">
									<span class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span>
								</p>
								<!-- <p class="mb-0"><span class="price mr-1">$120.00</span> <span class="per">per night</span></p> -->
								<h3 class="mb-3">
									<a href="rooms.html">서울 시그니처 호텔</a>
								</h3>
								<ul class="list-accomodation">
									<li><span>조회수 : </span> 342042</li>
									<li><span>예약수 : </span> 3799</li>
									<li><span>리뷰 : </span> 2015</li>
									<li><span>별점 : </span> 4.9</li>
								</ul>
								<p class="pt-1">
									<a href="room-single.html" class="btn-custom px-3 py-2">예약하기<span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="room-wrap d-md-flex">
						<a href="#" class="img"
							style="background-image: url(resources/client/vendor/images/good2.jpg);"></a>
						<div class="half left-arrow d-flex align-items-center">
							<div class="text p-4 p-xl-5 text-center">
								<p class="star mb-0">
									<span class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span>
								</p>
								<!-- <p class="mb-0"><span class="price mr-1">$120.00</span> <span class="per">per night</span></p> -->
								<h3 class="mb-3">
									<a href="rooms.html">제주 아일랜드 호텔</a>
								</h3>
								<ul class="list-accomodation">
									<li><span>조회수 : </span> 229521</li>
									<li><span>예약수 : </span> 2910</li>
									<li><span>리뷰 : </span> 1203</li>
									<li><span>별점 : </span> 4.8</li>
								</ul>
								<p class="pt-1">
									<a href="room-single.html" class="btn-custom px-3 py-2">예약하기<span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="room-wrap d-md-flex">
						<a href="#" class="img order-md-last"
							style="background-image: url(resources/client/vendor/images/good3.jpg);"></a>
						<div class="half right-arrow d-flex align-items-center">
							<div class="text p-4 p-xl-5 text-center">
								<p class="star mb-0">
									<span class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span>
								</p>
								<!-- <p class="mb-0"><span class="price mr-1">$120.00</span> <span class="per">per night</span></p> -->
								<h3 class="mb-3">
									<a href="rooms.html">부산 그랜드 호텔</a>
								</h3>
								<ul class="list-accomodation">
									<li><span>조회수 : </span> 261031</li>
									<li><span>예약수 : </span> 5921</li>
									<li><span>리뷰 : </span> 3102</li>
									<li><span>별점 : </span> 4.8</li>
								</ul>
								<p class="pt-1">
									<a href="room-single.html" class="btn-custom px-3 py-2">예약하기<span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="room-wrap d-md-flex">
						<a href="#" class="img order-md-last"
							style="background-image: url(resources/client/vendor/images/good4.jpg);"></a>
						<div class="half right-arrow d-flex align-items-center">
							<div class="text p-4 p-xl-5 text-center">
								<p class="star mb-0">
									<span class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span><span class="fa fa-star"></span><span
										class="fa fa-star"></span>
								</p>
								<!-- <p class="mb-0"><span class="price mr-1">$120.00</span> <span class="per">per night</span></p> -->
								<h3 class="mb-3">
									<a href="rooms.html">강릉 백제 호텔</a>
								</h3>
								<ul class="list-accomodation">
									<li><span>조회수 : </span> 132842</li>
									<li><span>예약수 : </span> 2782</li>
									<li><span>리뷰 : </span> 1282</li>
									<li><span>별점 : </span> 4.9</li>
								</ul>
								<p class="pt-1">
									<a href="room-single.html" class="btn-custom px-3 py-2">예약하기<span
										class="icon-long-arrow-right"></span></a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section testimony-section bg-light">
		<div class="container">
			<div class="row justify-content-center pb-5 mb-3">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<h2>HotelSpace Rivew</h2>
				</div>
			</div>
			<div class="row ftco-animate">
				<div class="col-md-12">
					<div class="carousel-testimony owl-carousel">
						<div class="item">
							<div class="testimony-wrap d-flex">
								<div class="user-img"
									style="background-image: url(resources/client/vendor/images/person_1.jpg)">
								</div>
								<div class="text pl-4">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="fa fa-quote-left"></i>
									</span>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia and Consonantia, there live the blind texts.</p>
									<p class="name">Racky Henderson</p>
									<span class="position">Father</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap d-flex">
								<div class="user-img"
									style="background-image: url(resources/client/vendor/images/person_2.jpg)">
								</div>
								<div class="text pl-4">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="fa fa-quote-left"></i>
									</span>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia and Consonantia, there live the blind texts.</p>
									<p class="name">Henry Dee</p>
									<span class="position">Businesswoman</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap d-flex">
								<div class="user-img"
									style="background-image: url(resources/client/vendor/images/person_3.jpg)">
								</div>
								<div class="text pl-4">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="fa fa-quote-left"></i>
									</span>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia and Consonantia, there live the blind texts.</p>
									<p class="name">Mark Huff</p>
									<span class="position">Businesswoman</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap d-flex">
								<div class="user-img"
									style="background-image: url(resources/client/vendor/images/person_4.jpg)">
								</div>
								<div class="text pl-4">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="fa fa-quote-left"></i>
									</span>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia and Consonantia, there live the blind texts.</p>
									<p class="name">Rodel Golez</p>
									<span class="position">Businesswoman</span>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="testimony-wrap d-flex">
								<div class="user-img"
									style="background-image: url(resources/client/vendor/images/person_1.jpg)">
								</div>
								<div class="text pl-4">
									<span
										class="quote d-flex align-items-center justify-content-center">
										<i class="fa fa-quote-left"></i>
									</span>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia and Consonantia, there live the blind texts.</p>
									<p class="name">Ken Bosh</p>
									<span class="position">Businesswoman</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- <section class="ftco-section bg-light">
			<div class="container">
				<div class="row no-gutters">
					<div class="col-md-6 wrap-about">
						<div class="img img-2 mb-4" style="background-image: url(resources/client/vendor/images/about.jpg);">
						</div>
						<h2>The most recommended vacation rental</h2>
						<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
					</div>
					<div class="col-md-6 wrap-about ftco-animate">
	          <div class="heading-section">
	          	<div class="pl-md-5">
		            <h2 class="mb-2">What we offer</h2>
	            </div>
	          </div>
	          <div class="pl-md-5">
							<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
							<div class="row">
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-diet"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Tea Coffee</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div> 
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-workout"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Hot Showers</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div>
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-diet-1"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Laundry</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div>      
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-first"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Air Conditioning</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div>
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-first"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Free Wifi</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div> 
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-first"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Kitchen</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div> 
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-first"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Ironing</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div> 
		            <div class="services-2 col-lg-6 d-flex w-100">
		              <div class="icon d-flex justify-content-center align-items-center">
		            		<span class="flaticon-first"></span>
		              </div>
		              <div class="media-body pl-3">
		                <h3 class="heading">Lovkers</h3>
		                <p>A small river named Duden flows by their place and supplies it with the necessary</p>
		              </div>
		            </div>
		          </div>  
						</div>
					</div>
				</div>
			</div>
		</section> -->

	<!-- <section class="ftco-intro" style="background-image: url(resources/client/vendor/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-9 text-center">
						<h2>Ready to get started</h2>
						<p class="mb-4">It’s safe to book online with us! Get your dream stay in clicks or drop us a line with your questions.</p>
						<p class="mb-0"><a href="#" class="btn btn-primary px-4 py-3">Book now</a> <a href="#" class="btn btn-white px-4 py-3">Contact us</a></p>
					</div>
				</div>
			</div>
		</section> -->

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center pb-5 mb-3">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<h2>휴양지 속 특별한 이야기</h2>
					<span class="subheading">휴양지 속 휴양지 초대합니다!</span>
				</div>
			</div>
			<div class="row d-flex">
				<div class="col-md-4 d-flex ftco-animate">
					<div class="blog-entry align-self-stretch">
						<a href="blog-single.html" class="block-20 rounded"
							style="background-image: url('resources/client/vendor/images/gp1.jpg');">
						</a>
						<div class="text p-4 text-center">
							<div>
								<a href="#"><span class="fa fa-star"></span><span
									class="fa fa-star"></span><span class="fa fa-star"></span><span
									class="fa fa-star"></span><span class="fa fa-star"></span></a>
							</div>
							<h3 class="heading">
								<a href="#">강릉시 앤젤 글램핑</a>
							</h3>
							<div class="meta mb-2">
								<p>글램핑이 처음이십니까? 앤젤 글램핑은 전국 최고 인기 1위 글램핑입니다!</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 d-flex ftco-animate">
					<div class="blog-entry align-self-stretch">
						<a href="blog-single.html" class="block-20 rounded"
							style="background-image: url('resources/client/vendor/images/gh1.jpg');">
						</a>
						<div class="text p-4 text-center">
							<div>
								<a href="#"><span class="fa fa-star"></span><span
									class="fa fa-star"></span><span class="fa fa-star"></span><span
									class="fa fa-star"></span><span class="fa fa-star"></span></a>
							</div>
							<h3 class="heading">
								<a href="#">제주시 우주 게스트하우스</a>
							</h3>
							<div class="meta mb-2"></div>
							<p>게스트 하우스의 낭만 , 호텔과 같은 편안함 둘다 느낄수있는 특별한 게스트하우스로 초대합니다</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 d-flex ftco-animate">
					<div class="blog-entry align-self-stretch">
						<a href="blog-single.html" class="block-20 rounded"
							style="background-image: url('resources/client/vendor/images/fs1.jpg');">
						</a>
						<div class="text p-4 text-center">
							<div>
								<a href="#"><span class="fa fa-star"></span><span
									class="fa fa-star"></span><span class="fa fa-star"></span><span
									class="fa fa-star"></span><span class="fa fa-star"></span></a>
							</div>
							<h3 class="heading">
								<a href="#">부산 광안리 럭스 펜션</a>
							</h3>
							<div class="meta mb-2"></div>
							<p>최고의 팬션을 경험해 보고싶으신가요 부산 럭스 팬션을 경험해보십시오!</p>
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