<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>회원관리</title>
<jsp:include page="/WEB-INF/views/admin/headerCssLink.jspf" />
<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
<script>
	//after window is loaded completely 
	window.onload = function() {
		//hide the preloader
		document.querySelector(".preloader").style.display = "none";
	}
</script>
</head>
<body class="fix-header">

	<div class="preloader">
		<svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none"
				stroke-width="2" stroke-miterlimit="10" />
        </svg>
	</div>
	<div id="wrapper">
		<c:import url="/navbar.mdo" />
		<c:import url="/sidebar.mdo" />


		<!-- ============================================================== -->
		<!-- End Left Sidebar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page Content -->
		<!-- ============================================================== -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Profile page</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<a href="https://wrappixel.com/templates/ampleadmin/"
							target="_blank"
							class="btn btn-danger pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">Upgrade
							to Pro</a>
						<ol class="breadcrumb">
							<li><a href="#">Dashboard</a></li>
							<li class="active">Profile Page</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-4 col-xs-12">
						<div class="white-box">
							<div class="user-bg">
						
								<div class="overlay-box">
									<div class="user-content">
									<h1 class="text-white">${client.clientID }</h1>
									</div>
								</div>
								
							</div>
							<div class="user-btm-box">
								<div class="text-center">
										<!-- <a href="javascript:void(0)"></a> -->
										<c:if test="${client.clientPassword == 'kakao' }">
											<h4>kakao로 로그인 한 회원</h4>										
										</c:if>
										<c:if test="${client.clientPassword != 'kakao' }">
											<h4>본 서버로 로그인 한 회원</h4>										
										</c:if>
								</div>
								<!-- <div class="col-md-4 col-sm-4 text-center">
									<p class="text-blue">
										<i class="ti-twitter"></i>
									</p>
									<h1>125</h1>
								</div>
								<div class="col-md-4 col-sm-4 text-center">
									<p class="text-danger">
										<i class="ti-dribbble"></i>
									</p>
									<h1>556</h1>
								</div> -->
							</div>
						</div>
					</div>
					
					
					
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form class="form-horizontal form-material">
								<div class="form-group">
									<label class="col-md-12">Name</label>
									<div class="col-md-12">
										<input type="text" placeholder="${client.clientName }"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label for="example-email" class="col-md-12">Email</label>
									<div class="col-md-12">
										<input type="email" placeholder="${client.clientEmail }"
											class="form-control form-control-line" name="example-email"
											id="example-email">
									</div>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-12">Password</label>
									<div class="col-md-12">
										<input type="password" value="password"
											class="form-control form-control-line">
									</div>
								</div> -->
								<div class="form-group">
									<label class="col-md-12">Phone No</label>
									<div class="col-md-12">
										<input type="text" placeholder="${client.clientTel }"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Birthday</label>
									<div class="col-md-12">
										<input type="text" placeholder="${client.clientBirth }"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Register Date</label>
									<div class="col-md-12">
										<input type="text" placeholder="${client.clientRegDate }"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Milage</label>
									<div class="col-md-12">
										<input type="text" placeholder="${client.clientMilage }"
											class="form-control form-control-line">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">State</label>
									<div class="col-md-12">
										<input type="text" placeholder="${client.clientState }"
											class="form-control form-control-line">
									</div>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-12">Message</label>
									<div class="col-md-12">
										<textarea rows="5" class="form-control form-control-line"></textarea>
									</div>
								</div> -->
								<!-- <div class="form-group">
									<label class="col-sm-12">Select Country</label>
									<div class="col-sm-12">
										<select class="form-control form-control-line">
											<option>London</option>
											<option>India</option>
											<option>Usa</option>
											<option>Canada</option>
											<option>Thailand</option>
										</select>
									</div>
								</div> -->
								<div class="form-group">
									<div class="col-sm-12">
										<button class="btn btn-success" onclick="myFunction()">Update Profile</button>
									</div>
								</div> 
							</form>
						</div>
					</div>
				</div>
			</div>


		</div>

	</div>

	<c:import url="/footer.mdo" />
	<!-- /.container-fluid -->

	</div>

</body>
</html>
