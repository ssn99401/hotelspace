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
<title>hotelspace</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<jsp:include page="/WEB-INF/views/admin/headerCssLink.jspf" />
<link rel="stylesheet"
	href="resources/admin/css/management/hotel/hotel.css" />

<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
<script type="text/javascript" src="resources/admin/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="resources/admin/js/management/hotel/hotel.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


</head>
<body class="fix-header">
	<div id="wrapper">
		<c:import url="/navbar.mdo" />
		<c:import url="/sidebar.mdo" />

		<!-- page Content -->
		<div class="container" style="margin-top: 200px;" align="center">
			<div class="row">
				<div class="col-md-12" style="width: 100%; margin-bottom: 50px;" align="right">
					<button>호텔 등록</button>
				</div>
				<div class="col-md-12" style="width: 100%;">
					<div id="hotel-filter">
						<span style="display: inline-block; float: left;"> <input
							type="text" id="hotelName" placeholder="호텔명"> <input
							type="text" id="hotelAddress" placeholder="주소"><input
							type="text" id="hotel_clientId" placeholder="등록인 ID">
							<button id="btn-search">필터링</button>
							<button id="btn-resetFilter">초기화</button>
						</span><span style="display: inline-block; width: 30%; float: right;">
							<select class="form-control" id="criteria"
							style="width: 40%; float: left; height: 100%;">
								<option selected="selected">정렬</option>
								<option>오름차순</option>
								<option>내림차순</option>
						</select> <input type="checkbox" name="orderby-name" id="orderby-name"
							value="HOTEL_NAME"> <label>ID</label>&nbsp; <input
							type="checkbox" name="orderby-area" id="orderby-area"
							value="HOTEL_AREA"> <label>지역</label>&nbsp; <input
							type="checkbox" name="orderby-average" id="orderby-average"
							value="HOTEL_STAR"> <label>평점</label> &nbsp; 
						</span>
					</div>
					<div class="col-md-12" style="width: 100%; margin-bottom: 25px; margin-top: 25px;" align="right">
						<select class="form-control" id="pageSize"
							style="width: 10%; float: right;">
								<option selected="selected">10개</option>
								<option>20개</option>
								<option>30개</option>
								<option>40개</option>
								<option>50개</option>
						</select>
					</div>
					<table class="table table-bordered" style="text-align: center;">
						<thead>
							<th>호텔 ID</th>
							<th>호텔명</th>
							<th>TEL</th>
							<th>등록인 ID</th>
							<th>지역</th>
							<th>테마</th>
							<th>평점</th>
							<th>등록일</th>
							<th></th>
							<th></th>
						</thead>
						<tbody id="hotelList-body">
						</tbody>

					</table>
					<div id="div-pageNum" align="center"></div>
				</div>
				
			</div>


			<div class="modal" id="delete" tabindex="-1" role="dialog"
				aria-labelledby="edit" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</button>
							<h4 class="modal-title custom_align" id="Heading">Delete
								this entry</h4>
						</div>
						<div class="modal-body">

							<div class="alert alert-danger">
								<span class="glyphicon glyphicon-warning-sign"></span> Are you
								sure you want to delete this Record?
							</div>

						</div>
						<div class="modal-footer ">
							<button type="button" class="btn btn-success">
								<span class="glyphicon glyphicon-ok-sign"></span> Yes
							</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-remove"></span> No
							</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</div>
		<!-- ============================================================== -->

		<c:import url="/footer.mdo" />
		<!-- /.container-fluid -->

	</div>

</body>
</html>
