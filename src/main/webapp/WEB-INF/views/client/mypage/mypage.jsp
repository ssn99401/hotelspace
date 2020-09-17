<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<title>내 정보</title>
</head>
<body>
<body id="page-top">
	<c:import url="/clientHeader.do" />

	<section>
		<div class="w3-sidebar w3-bar-block" style="width: 25%; height: 40%">
			<div class="w3-bar-item w3-pink">
				<p>
					<a href='clientMypage.do' class="w3-font-white">My Page</a>
				</p>
			</div>
			<a href='myinfoUpdate.do' class="w3-bar-item w3-button"> 개인정보 수정
			</a> <a href='pwChangeForm.do' class="w3-bar-item w3-button"> 비밀번호 변경
			</a> <a href='myreservation.do' class="w3-bar-item w3-button"> 예약 상세
				정보 </a> <a href="withdrawalForm.do" class="w3-bar-item w3-button"> 회원탈퇴 </a>
		</div>
			<div style="margin-left:25%">
			<div class="w3-content w3-container w3-margin" >
				<div class="w3-container w3-card-4">
					<div class="w3-content w3-container w3-margin" align="left">
						<h2>내 정보</h2>
					</div>
					<div class="w3-container">
						<table class="w3-table-all w3-margin w3-center">
							<tr colspan="2" class="w3-large w3-font-black">
								<td>아이디</td>
							</tr>
							<tr colspan="2">
								<td>${login.clientId}</td>
							</tr>

							<tr colspan="2">
								<td>이름</td>
							</tr>

							<tr colspan="2">
								<td>${login.clientName}
							</tr>

							<tr colspan="2">
								<td>전화번호</td>
							</tr>

							<tr colspan="2">
								<td>${login.clientTel}
							</tr>

							<tr colspan="2">
								<td>이메일</td>
							</tr>

							<tr colspan="2">
								<td>${login.clientEmail}
							</tr>

							<tr colspan="2">
								<td>생년월일</td>
							</tr>

							<tr colspan="2">
								<td><fmt:parseDate value='${login.clientBirth}'
										var='trading_day' pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
										value="${trading_day}" pattern="yyyy.MM.dd" /></td>
							</tr>

							<tr colspan="2">
								<td>생성일</td>
							</tr>

							<tr colspan="2">
								<td><fmt:parseDate value='${login.clientRegDate}'
										var='trading_day1' pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
										value="${trading_day1}" pattern="yyyy.MM.dd" /></td>
							</tr>

							<tr colspan="2">
								<td>마일리지</td>
							</tr>

							<tr colspan="2">
								<td>${login.clientMilage}</td>
							</tr>


						</table>
					</div>
				</div>
	</section>

	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

</body>

</html>
