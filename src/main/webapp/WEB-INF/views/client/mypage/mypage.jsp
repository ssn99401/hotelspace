<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<style>
html, body {
	margin: 0px;
	padding: 0px;
}

#test_btn1 {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	margin-right: -4px;
}

#test_btn2 {
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	margin-left: -3px;
}
#test_btn3 {
	border-radius:5px;
	margin-left: -3px;
}

button {
	font-size: 16px;
	border: 1px solid pink;
	background-color: rgba(0, 0, 0, 0);
	color: pink;
	padding: 5px 100px;
	margin: auto;
}

button:hover {
	color: white;
	background-color: pink;
}
</style>
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


	<header class="bg-primary text-white">
		<div class="container text-center">
			<h1>My info</h1>
			<p class="lead">개인정보수정</p>
		</div>
	</header>
	<script>
		function getupdate(mode) {

			if (mode == 1) {
				document.mypage.action = 'myinfoUpdate.do';
			}
			if (mode == 2) {
				document.mypage.action = 'pwChangeForm.do';
			}
			
			document.mypage.submit();
		}
	</script>

	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<p class="lead">
					<form name="mypage" method="post">
						<table border=1
							style="margin: auto; padding: 50px; border-spacing: 10px; width: 80%;">
							<tr>
								<td>아이디</td>
								<td>${login.clientId}</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>${login.clientName}
							</tr>
							<tr>
								<td>전화번호</td>
								<td>${login.clientTel}
							</tr>
							<tr>
								<td>이메일</td>
								<td>${login.clientEmail}
							</tr>
							<tr>
								<td>생년월일</td>
								<td>${login.clientBirth}
							</tr>
							<tr>
								<td>생성일자</td>
								<td>${login.clientRegDate}</td>
							</tr>
							<tr>
								<td>마일리지</td>
								<td>${login.clientMilage}</td>
							</tr>
						</table>
						<br>
						<table style="margin:auto;">
							<tr>
								<td><button id="test_btn1" onclick="getupdate('1')">개인정보 수정</button></td>
							<td><button id="test_btn2" onclick="getupdate('2')">비밀번호 변경</button></td>
							</tr>
						</table>
						
						
					</form>


					<br>

					<form action="redirect:index.do">
					<table style="margin:auto;">
						<tr>
							<td>
						<button id="test_btn3">홈으로</button></td>
						</tr>
					</table>
					</form>
					<br> <br>
				</div>
			</div>
		</div>
	</section>


	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

	<jsp:include page="../headerScriptLink.jspf" />
</html>
