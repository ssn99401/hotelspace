<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-default sidebar" role="navigation"
	style="margin-top: 5%;">
	<div class="sidebar-nav slimscrollsidebar">
		<div class="sidebar-head">
			<h3>
				<span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span>
				<span class="hide-menu">Navigation</span>
			</h3>
		</div>
		<ul class="nav" id="side-menu">
			<li style="padding: 70px 0 0;"><a href="dashboard.html"
				class="waves-effect"><i class="fa fa-clock-o fa-fw"
					aria-hidden="true"></i>통계 정보</a></li>
			<li><a href="clientManagement.mdo?curPage=1" class="waves-effect"><i
					class="fa fa-table fa-fw" aria-hidden="true"></i>회원 관리</a></li>
			<li><a href="pageManagement.mdo" class="waves-effect"><i
					class="fa fa-font fa-fw" aria-hidden="true"></i>페이지 관리</a></li>
			<li><a href="blank.html" class="waves-effect"><i
					class="fa fa-columns fa-fw" aria-hidden="true"></i>업체(호텔) 관리</a></li>


		</ul>
	</div>
</div>