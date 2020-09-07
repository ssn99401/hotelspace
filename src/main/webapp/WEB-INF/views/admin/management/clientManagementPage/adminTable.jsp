<%@page
	import="com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO"%>
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

	doubleSubmitFlag = false;

	//값을 저장시키고 불러올수 있는 함수
	function doubleState1(num) {
		if (num == 1) {
			doubleSubmitFlag = false;

			return doubleSubmitFlag;
		} else if (num == 2) {
			doubleSubmitFlag = true;

			return doubleSubmitFlag;
		}

	}

	
	function change() {//토글버튼 누를 시

		console.log(doubleSubmitFlag);
		console.log('버튼맨처음');

		if (doubleSubmitFlag == true) {//버튼 동작 도중 클릭시
			alert('잠시 후 시도해주세요');
			window.location.reload();
			return;
		}
		doubleSubmitFlag = doubleState1(2);//true

		console.log(doubleSubmitFlag);
		console.log('버튼동작시작');

		var chkarr = [];
		var Nchkarr = [];

		for (var i = 1; i < $('table tr').size(); i++) {

			// table 중 tr이 i번째 있는 자식중에 체크박스가 체크중이면

			var chk = $('table tr').eq(i).children().find(
					'input[type="checkbox"]').is(':checked');

			if (chk == true) {
				// 그 i 번째 행을 배열 chkarr에 푸시
				chkarr.push(i);
			} else {
				//비활성화 된 것은 Nchkarr에 푸시
				Nchkarr.push(i);
			}

		}//for문 -end

		$.ajax({
			type : "GET",
			url : 'togglebutton.mdo',
			dataType : 'text',
			data : {
				'state' : chkarr,
				'Nstate' : Nchkarr
			},
			success : function(data) {

				for (var i = 1; i <= chkarr.length + Nchkarr.length; i++) {

					var getId = "checkbox" + i;
					var ischecked = $('input:checkbox[id="' + getId + '"]').is(
							':checked');//i번째 체크박스가 active냐?
					if (ischecked) {//맞으면
						$('#act' + i).show();//active출력
						$('#ban' + i).hide();
					} else {
						$('#act' + i).hide();//틀리면 banned출력
						$('#ban' + i).show();
					}
				}

				doubleSubmitFlag = doubleState1(1);//false

				console.log(doubleSubmitFlag);
				console.log('버튼끝부분');

			},
			error : function(request, status, error) {
				alert(error);
			}

		});//ajax-end
	}//change-end


</script>

<style>/* The switch - the box around the slider */
.switch {
	position: relative;
	display: inline-block;
	width: 50px;
	height: 24px;
	vertical-align: middle;
}

/* Hide default HTML checkbox */
.switch input {
	display: none;
}

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

input:checked+.slider {
	background-color: #2196F3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider:before {
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
	margin: 0px;
	display: inline-block;
	font-size: 15px;
	font-weight: bold;
}
</style>
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
							<br> 
							<form action="searchUserIdName.mdo">
							<select name="type" id="type">
								<option value="none" selected>찾기옵션</option>
								<option value="ID">ID</option>
								<option value="NAME">이름</option>
								<input type="text" name="searchUser" id="searchUser" />
								<input type="submit" value="검색" />
								</form>
								<form action="clientManagement.mdo">
								<input type="submit" value="전체보기" />
								</form>
								
								<script>
								function inputText() {
									
									var user = $('#searchUser').val();
									console.log(user);
									var type = $('#type').val();
									console.log(type);
									
									if(type=="ID"){
										$( '#table > tbody:last').empty();

										$.ajax({
											type : "GET",
											url : 'searchId.mdo',
											dataType : 'text',
											data : {
												'user' : user
											},
											success : function(data) {
											console.log('iD성공');
											},
											error : function(request, status, error) {
												alert(error);
											}

										});//ajax-end
									}else if(type=="NAME"){
										
										$( '#table > tbody:last').empty();
										$.ajax({
											type : "GET",
											url : 'searchName.mdo',
											dataType : 'text',
											data : {
												'user' : user
											},
											success : function(data) {
												console.log('Name성공');
											},
											error : function(request, status, error) {
												alert(error);
											}

										});//ajax-end
									}//if-end
								}//inputText()-end
								</script>
								<div class="table-responsive" id="table-responsive">
									<table class="table" id="table">
										<thead>
											<tr style="font-size: 20px;">
												<th>ID</th>
												<th>Name</th>
												<th>Reg Date</th>
												<th>Milage</th>
												<th>State</th>
											</tr>
										</thead>
										<tbody>
											
												<%
												List<AdminManageClientVO> clientList = (List<AdminManageClientVO>) request.getAttribute("clientList");

												String status = null;
												for (int i = 0; i < clientList.size(); i++) {
											%>
											<tr>
												<td><a
													href="profile.mdo?id=<%=clientList.get(i).getClientID()%>"><%=clientList.get(i).getClientID()%></a></td>
												<td><%=clientList.get(i).getClientName()%></td>
												<td><%=clientList.get(i).getClientRegDate()%></td>
												<td><%=clientList.get(i).getClientMilage()%></td>
												<td>
													<%
														if (clientList.get(i).getClientState() == 0) {//active상태 일 때는 체크되어서 로딩
													%> <label class="switch"> <!--체크박스  --> <input
														type="checkbox" id="checkbox<%=i + 1%>" name="checkbox"
														checked="checked" onchange="change()"> <span
														class="slider round"></span>
												</label>
												<td>
													<!-- 0이면 체크박스 체크(active),0이아니면 체크박스 해제(banned)  -->
													<p id="act<%=i + 1%>" style="color: green;">Actived</p>
													<p id="ban<%=i + 1%>" style="color: red; display: none;">Banned</p>
												</td>
												<%
													} else {
												%>
												<label class="switch"> <!--체크박스  --> <input
													type="checkbox" id="checkbox<%=i + 1%>" name="checkbox"
													onchange="change()"> <span class="slider round"></span>
												</label>
												<td>
													<p id="act<%=i + 1%>" style="color: green; display: none;">Actived</p>
													<p id="ban<%=i + 1%>" style="color: red;">Banned</p>
												</td>
												<%
													}
												%>
											</tr>
											<%
												} //for문--end
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
