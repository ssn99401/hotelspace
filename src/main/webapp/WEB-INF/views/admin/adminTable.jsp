<%@page import="com.spring.hotelspace.admin.main.vo.AdminMainVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
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
<title>회원 관리</title>
<jsp:include page="/WEB-INF/views/admin/headerCssLink.jspf" />

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


		<!-- page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Basic Table</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<a href="https://wrappixel.com/templates/ampleadmin/"
							target="_blank"
							class="btn btn-danger pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">Upgrade
							to Pro </a>
						<ol class="breadcrumb">
							<li><a href="#">Dashboard</a></li>
							<li class="active">Basic Table</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /row -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Client Management</h3>
							<p class="text-muted">회원 관리</p>
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>id</th>
											<th>name</th>
											<th>reg_date</th>
											<th>milage</th>
											<th>state</th>
										</tr>
									</thead>
									<tbody>
										<%
											List<AdminMainVO> clientList = (List<AdminMainVO>) request.getAttribute("clientList");
											System.out.println(clientList.get(0).getClientID());
											String status=null;
											for (int i = 0; i < clientList.size(); i++) {
												if (clientList.get(i).getClientState() == 0) {
													status = "active";
												} else {
													status = "banned";
												}

										%>
										<tr>
											<td><a
												href="profile.do?id=<%=clientList.get(i).getClientID()%>"><%=clientList.get(i).getClientID()%></a></td>
											<td><%=clientList.get(i).getClientName()%></td>
											<td><%=clientList.get(i).getClientRegDate()%></td>
											<td><%=clientList.get(i).getClientMilage()%></td>


											<td><%=status%></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>


			<c:import url="/footer.mdo" />
			<!-- /.container-fluid -->

		</div>
		<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
</body>
</html>
