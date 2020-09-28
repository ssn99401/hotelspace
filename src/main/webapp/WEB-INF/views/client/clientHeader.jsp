<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="headerCssLink.jspf" />
<script type="text/javascript" src="resources/client/js/jquery-3.3.1.js"></script>
</head>

<body>
	<!-- loader -->
	<%-- <div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div> --%>
	<!-- header -->
	<div class="wrap">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col d-flex align-items-center">
					<p class="mb-0 phone">
						<span class="mailus">회사번호 :</span> <a href="#">02-764-8225</a> <span
							class="mailus">이메일 :</span> <a href="#">emailsample@email.com</a>
					</p>
				</div>
				<div class="col d-flex justify-content-end">
					<div class="social-media">
						<p class="mb-0 d-flex">
							<a href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a> <a
								href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a> <a
								href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
							<a href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index.do"><img
				src="resources/client/vendor/images/logo.png" width="200"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="fa fa-bars"></span> Menu
			</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="index.do"
						class="nav-link">Home</a></li>
					<li class="nav-item"><a href="searchHotelAll.do?pageNum=1"
						class="nav-link">Hotel</a></li>
					<li class="nav-item"><a href="clientFAQServices.do"
						class="nav-link">FAQ</a></li>
                    <li class="nav-item"><a href="clientQNAServices.do"
						class="nav-link">Q&A</a></li>

					<c:if test="${sessionScope.login != null }">
						<li class="nav-item"><a href="clientMypage.do"
							class="nav-link">MyPage</a></li>
						<li class="nav-item"><a href="clientLogout.do"
							class="nav-link">Logout</a></li>&nbsp;
						<li class="nav-item">${sessionScope.login }님환영합니다!</li>
					</c:if>
					
					<c:if test="${sessionScope.login == null }">
						<li class="nav-item"><a href="clientLogin.do"
							class="nav-link">Login</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
</body>
</html>