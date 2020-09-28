<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	
		
        function popup(hotelId, roomId, reservationId){
			
        	var popupX = (window.screen.width / 2) - (500 / 2);

        	var popupY= (window.screen.height / 2) - (300 / 2);
        	
            var url = "reviewForm.do?hotelId="+hotelId+"&roomId="+roomId+"&reservationId="+reservationId;
            var name = "popup test";
            var option = "width = 500, height = 300, top = "+popupY+" left = "+popupX;
			
            window.open(url, name, option);
        }
        
    </script>

<title>마이페이지</title>
<jsp:include page="../headerCssLink.jspf" />
</head>
<body>
<body id="page-top">
	<c:import url="/clientHeader.do" />

	<section>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<div class="w3-sidebar2 w3-bar-block" style="position:absolute;  width: 25%; height: 40%">
			<div class="w3-bar-item w3-pink">
				<p>
					<a href='clientMypage.do' class="w3-font-white">My Page</a>
				</p>
			</div>
			<a href='myinfoUpdate.do' class="w3-bar-item w3-button"> 개인정보 수정
			</a> <a href='pwChangeForm.do' class="w3-bar-item w3-button"> 비밀번호 변경
			</a> <a href='myreservation.do' class="w3-bar-item w3-button"> 예약 상세
				정보 </a> <a href="withdrawalForm.do" class="w3-bar-item w3-button">
				회원탈퇴 </a>
		</div>

		<div style="margin-left: 25%; margin-bottom:25%">
			<div class="w3-content w3-container w3-margin-top w3-margin-bottom">
				<div class="w3-container w3-card-4">
					<div class="w3-content w3-container w3-margin-top w3-margin-bottom"
						align="left">
						<h2>예약 내역 확인</h2>
					</div>
					<div class="w3-container" style=" margin-bottom:25%; " >
						<table class="w3-table-all w3-margin" >
							<thead>
								<tr>
									<th class="w3-center">호텔명</th>
									<th class="w3-center">예약한 방</th>
									<th class="w3-center">입실일</th>
									<th class="w3-center">퇴실일</th>
									<th class="w3-center">가격</th>
									<th class="w3-center">예약 인원</th>
									<th class="w3-center">예약일</th>
									<th class="w3-center">리뷰</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="mR" items="${myReserv }">
								
									<input type="hidden" value="${mR.reservationOutDate }"
										id="reservationOutDate">
									<tr>
										
										<td class="w3-center">${mR.hotelId}</td>
										<td class="w3-center">${mR.roomId}</td>
										<td class="w3-center"><fmt:parseDate
												value='${mR.reservationInDate}' var='trading_day'
												pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
												value="${trading_day}" pattern="yyyy.MM.dd" /></td>

										<td class="w3-center"><fmt:parseDate
												value='${mR.reservationOutDate}' var='trading_day1'
												pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
												value="${trading_day1}" pattern="yyyy.MM.dd" /></td>

										<td class="w3-center">${mR.reservationPayment}</td>
										<td class="w3-center">${mR.reservationPeople}</td>
										<td class="w3-center"><fmt:parseDate
												value='${mR.reserveDate}' var='trading_day1'
												pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
												value="${trading_day1}" pattern="yyyy.MM.dd" />
										<input type="hidden" value="${mR.reservationId }"
										id="reservationId"></td>

										<td class="w3-center">
											<c:if
												test="${mR.reservationOutDate <= now && mR.reviewCheck == 0}">
												<a href="javascript:popup('${ mR.hotelId}','${ mR.roomId}','${ mR.reservationId}')">리뷰
													작성</a>
												<!--${mR.reviewCheck}-->
											</c:if>
											
											<c:if
												test="${mR.reviewCheck==1}">
												<a href="#" onclick="return false;"
												>작성완료</a>
												<!--${mR.reviewCheck}-->
											</c:if>
										</td>

									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<c:import url="/clientFooter.do" />
		</footer>
	</section>
</body>

<jsp:include page="../headerScriptLink.jspf" />
</html>