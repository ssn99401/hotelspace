<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="resources/client/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="resources/client/css/reservInfo/reservInfo.css">
<script src="resources/client/js/reservInfo/reservInfo.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>
	<header>
		<c:import url="/clientHeader.do" />
	</header>

<div style="height: 500px;">
	<input type="hidden" id="clientId"
		value="${sessionScope.login.clientId }">

	<c:forEach items="${revList }" var="rev">
		<input type="hidden" id="roomId" value="${rev.roomId }">
		<input type="hidden" id="hotelId" value="${rev.hotelId }">
		<input type="hidden" id="reservationInDate"
			value="${param.reservationInDate}">
		<input type="hidden" id="reservationOutDate"
			value="${param.reservationOutDate }">

		<table border="2">
			<tr>
				<th colspan="3" style="text-align: center;">선택하신 예약정보입니다</th>
			</tr>
			<tr>
				<td>선택하신 방 :</td>
				<td colspan="2" style="text-align: center;" id="roomName">${rev.roomName }</td>
			</tr>
			<tr>
				<td>방 기본가격:</td>
				<td colspan="3" style="text-align: center;"><fmt:formatNumber
						value="${rev.roomPrice }" pattern="#,###,###" />￦</td>
			</tr>

			<tr>
				<td>선택하신 날짜 :</td>
				<td>${param.reservationInDate}~ ${param.reservationOutDate }</td>
			</tr>

			<tr align="center">
				<td>입실인원 수정 :</td>
				<td colspan="2"><input type=button value="-"
					onclick="javascript:peopleMinus();"> <input type="hidden"
					id="mPeople" value=${rev.roomMaxPeople }> <input
					type="hidden" id=sPeople value=${rev.roomStandardPeople }>

					<input type=text name=people id=reservationPeople
					value=${rev.roomStandardPeople }
					style="width: 30px; text-align: center;">인 <input
					type=button value="+" onclick="javascript:peoplePlus();"></td>
			<tr>
			<td>최종 가격:</td>
				<td colspan="3" style="text-align: center;" id="price"><input
					type="hidden" id="hPrice" value="${rev.roomPrice }"> <fmt:formatNumber
						value="${rev.roomPrice }" pattern="#,###,###" />￦</td>
			</tr>
			<tr>
			
				<td colspan="3" style="text-align: center;">
				<input type = "button" class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round" value = "뒤로가기" id = "back" onclick="history.back(-1);">
				<input
					type="button" value="결제" id=pay class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round" ></td>
			</tr>
		</table>


	</c:forEach>

</div>


	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

</body>
</html>