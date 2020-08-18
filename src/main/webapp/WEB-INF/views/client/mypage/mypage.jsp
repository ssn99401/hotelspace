<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>내 정보</title>

<!-- Bootstrap core CSS -->
<link
	href="resources/client/vendor/scroll-nav/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/client/css/scrolling-nav.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Start
				Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">About</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Services</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<header class="bg-primary text-white">
		<div class="container text-center">
			<h1>My info</h1>
			<p class="lead">맨위에 화면(개인정보수정)</p>
		</div>
	</header>

	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>중간시작</h2>
					<p class="lead">
					<form action="myinfoupdate.do">
						테스트임<br> ${login.clientId} <br> ${login.clientName} <br>
						${login.clientTel} <br> ${login.clientEmail} <br>
						${login.clientBirth} <br> ${login.clientRegDate} <br>
						${login.clientMilage} <br> <input type="submit"
							value="개인정보 수정" /><br> <input type="submit" value="비밀번호 변경" /><br>
						<input type="reset" value="취소" />
					</form>

				</div>
			</div>
		</div>
	</section>

	<section id="services" class="bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Services we offer</h2>
					<p class="lead">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Aut optio velit inventore, expedita quo
						laboriosam possimus ea consequatur vitae, doloribus consequuntur
						ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>
				</div>
			</div>
		</div>
	</section>

	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Contact us</h2>
					<p class="lead">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Vero odio fugiat voluptatem dolor, provident
						officiis, id iusto! Obcaecati incidunt, qui nihil beatae magnam et
						repudiandae ipsa exercitationem, in, quo totam.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>






	<!-- Bootstrap core JavaScript -->
	<script src="resources/client/vendor/scroll-nav/jquery/jquery.min.js"></script>
	<script
		src="resources/client/vendor/scroll-nav/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="resources/client/vendor/scroll-nav/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="resources/client/js/scrolling-nav.js"></script>

</body>

</html>


<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript" src="resources/client/js/index/index.js"></script>
<title>Insert title here</title>
<jsp:include page="../headerCssLink.jspf" />
</head>
<body>

	<header>
		<c:import url="/clientHeader.do" />
	</header>
	<h1>내 정보</h1>
	
	table
	${login.clientId}
	<br> ${login.clientName}
	<br> ${login.clientTel}
	<br> ${login.clientEmail}
	<br> ${login.clientBirth}
	<br> ${login.clientRegDate}
	<br> ${login.clientMilage}
	<br>
	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

</body>
</html> --%>