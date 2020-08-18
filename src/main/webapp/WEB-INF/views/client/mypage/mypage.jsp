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
<!-- <link
	href="resources/client/vendor/scroll-nav/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">  -->

<!-- Custom styles for this template -->
<!-- <link href="resources/client/css/scrolling-nav.css" rel="stylesheet"> -->
<jsp:include page="../headerCssLink.jspf" />
</head>
<body>
<body id="page-top">
<c:import url="/clientHeader.do" />

	<!-- Navigation
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
	</nav>-->

	<header class="bg-primary text-white">
		<div class="container text-center">
			<h1>My info</h1>
			<p class="lead">개인정보수정</p>
		</div>
	</header>
		
	
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<p class="lead">
					<form action="myinfoupdate.do" method="get">
					<table align="center">
						<tr><td>아이디</td><td>${login.clientId}</td></tr>  
						<tr><td>이름</td><td>${login.clientName}</tr>
						<tr><td>전화번호</td><td>${login.clientTel}</tr>
						<tr><td>이메일</td><td>${login.clientEmail}</tr>
						<tr><td>생년월일</td><td>${login.clientBirth}</tr>
						<tr><td>생성일자</td><td>${login.clientRegDate}</td></tr>
						<tr><td>마일리지</td><td>${login.clientMilage}</td></tr>
						<tr><td colspan="2"><input type="submit" value="개인정보 수정" /> </td></tr>
						<tr><td colspan="2"><input type="submit" value="비밀번호 변경" /></td></tr>
						<tr><td colspan="2"><input type="reset" value="취소" /></td></tr>
					</table>
					</form>

				</div>
			</div>
		</div>
	</section>


	<footer>
		<c:import url="/clientFooter.do" />
	</footer>
	
	<jsp:include page="../headerScriptLink.jspf" />

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