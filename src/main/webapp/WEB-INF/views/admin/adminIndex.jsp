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
<jsp:include page="/WEB-INF/views/admin/headerCssLink.jspf" />

<script>
    //after window is loaded completely 
    window.onload = function(){
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
		<c:import url="/main.mdo" />
		<!-- ============================================================== -->


		<c:import url="/footer.mdo" />
		<!-- /.container-fluid -->

	</div>
	<jsp:include page="/WEB-INF/views/admin/headerScriptLink.jspf" />
</body>
</html>
