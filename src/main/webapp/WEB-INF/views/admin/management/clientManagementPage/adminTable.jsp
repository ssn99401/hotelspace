<%@page import="com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO"%>
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
<script>
	
	 $('#checkbox').click(function(){
	        $.ajax({
	            url:'./adminTable.jsp',
	            dataType:'json',
	            success:function(data){
	            	var check = $("input[type='checkbox']");
	            	check.click(function(){
	            		$("p").toggle();
	            	});
	        }
	    });
	
</script>
<style>/* The switch - the box around the slider */
.switch {
  position: relative;
  display: inline-block;
  width: 50px;
  height: 24px;
  vertical-align:middle;
}

/* Hide default HTML checkbox */
.switch input {display:none;}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 16px;
  width: 16px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}

p {
	margin:0px;
	display:inline-block;
	font-size:15px;
	font-weight:bold;
}</style>
<meta charset="utf-8">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>회원 관리</title>
<jsp:include page="/WEB-INF/views/admin/headerCssLink.jspf" />


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
										<tr style="font-size:20px;">
											<th>id</th>
											<th>name</th>
											<th>reg_date</th>
											<th>milage</th>
											<th>state</th>
										</tr>
									</thead>
									<tbody>
										<%
											List<AdminManageClientVO> clientList = (List<AdminManageClientVO>) request.getAttribute("clientList");
											System.out.println(clientList.get(0).getClientID());
											String status = null;
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


											<td>
											<label class="switch"> 
											<input type="checkbox" id="checkbox"> 
											<span class="slider round"></span>
											</label>
												<p id="ban">Banned</p>
												<p id="act" style="display: none;">active</p></td>
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
