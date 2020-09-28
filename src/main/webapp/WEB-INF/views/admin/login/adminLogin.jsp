<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/client/css/main.css" />
<meta charset="UTF-8">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/client/login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/client/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="resources/client/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/client/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/client/login/css/main.css">
<!--===============================================================================================-->

<title>관리자 로그인</title>
</head>
<body>
<div class="container-login100">
<div class="wrap-login100 p-t-90 p-b-30">
	<form class="login100-form validate-form" action="adminLogin.mdo" method="post">
	<span class="login100-form-title p-b-40"> Admin Login </span>
		 <c:if test="${message != null}">
		 	<p align="center">${message }</p>
		 </c:if>
	<div class="wrap-input100 validate-input m-b-16">
		<input class="input100"	type="text" name="id" placeholder="id"> 
		 <span class="focus-input100"></span>  
		 
	</div>
	
	<div class="wrap-input100 validate-input m-b-20" data-validate = "Please enter password">
		<span class="btn-show-pass"> <i class="fa fa fa-eye"></i></span> 
		<input class="input100" type="password" name="password"
			placeholder="Password"> 
			 <span class="focus-input100"></span>
	</div>
		<input class="container-login100-form-btn" type="submit" value="login" />
	</form>
 <br>
 	<div align="center">
 	<br />
 	<br />
 	<br />
		<a href="clientLogin.do">HotelSpace</a>
	</div>

</div>
</div>







	<!--===============================================================================================-->
	<script src="resources/client/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="resources/client/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/client/login/vendor/bootstrap/js/popper.js"></script>
	<script
		src="resources/client/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="resources/client/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="resources/client/login/vendor/daterangepicker/moment.min.js"></script>
	<script
		src="resources/client/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script
		src="resources/client/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="resources/client/login/js/main.js"></script>
</body>
</html>