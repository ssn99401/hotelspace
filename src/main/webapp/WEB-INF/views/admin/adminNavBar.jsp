<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-static-top m-b-0">
	<div class="navbar-header">
		<div class="top-left-part">
			<!-- Logo -->
			<a class="logo" href="dashboard.html"> <!-- Logo text image you can use text also -->
				<span class="hidden-xs"> <!--This is light logo text--> <img
					src="resources/admin/images/logo.png"
					style="max-width: 70%; max-height: 60%;" alt="home"
					class="light-logo" />
			</span>
			</a>
		</div>
		<!-- /Logo -->
		<ul class="nav navbar-top-links navbar-right pull-right">
			<li><a
				class="nav-toggler open-close waves-effect waves-light hidden-md hidden-lg"
				href="javascript:void(0)"><i class="fa fa-bars"></i></a></li>
			<li>
				<form role="search" class="app-search hidden-sm hidden-xs m-r-10">
					<input type="text" placeholder="Search..." class="form-control">
					<a href=""> <i class="fa fa-search"></i>
					</a>
				</form>
			</li>
			<li><a class="profile-pic" href="#"> <img
					src="resources/admin/vendor/plugins/images/users/varun.jpg"
					alt="user-img" width="36" class="img-circle"><b
					class="hidden-xs">Steave</b></a></li>
		</ul>
	</div>
	<!-- /.navbar-header -->
	<!-- /.navbar-top-links -->
	<!-- /.navbar-static-side -->
</nav>