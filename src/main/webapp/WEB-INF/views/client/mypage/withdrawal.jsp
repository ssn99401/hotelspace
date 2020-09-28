<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	//패스워드 입력하지 않았을 경우 가입버튼 비활성화
	function signupCheck() {
		var password = $("#clientPassword").val();

		if (password == "") {
			$(".joinBtn").prop("disabled", true);
			$(".joinBtn").css("background-color", "#aaaaaa");
		}
	}

	//아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활성화를 위한 변수설정
	var pwdCheck = 0;

	//비밀번호 체크하여 가입버튼 비활성화, 비밀번호 일치 확인.
	function checkPwd() {
		var inputed = $('.w3-input').val();
		console.log(inputed);
		$.ajax({
			data : {
				pw : inputed
			},
			url : "checkPw.do",
			success : function(data) {
				if (inputed == "" && data == '0') { //비밀번호가 일치하지 않으면서 입력 데이터가 없을때
					$("#joinBtn").prop("disabled", true);
					$("#joinBtn").css("background-color", "#aaaaaa");
					$("#old_pw").css("background-color", "#FFCECE");
					pwdCheck = 0;
				} else if (data == '1') { //비밀번호가 일치할때
					$("#old_pw").css("background-color", "#B0F6AC");
					pwdCheck = 1;

					/* 비밀번호가 일치할때 */
					if (pwdCheck == 1) {
						$("#joinBtn").prop("disabled", false);
						$("#joinBtn").css("background-color", "#4CAF50"); //핑크색
					}

				} else if (data == '0') {//비밀번호가 일치하지 않을때
					$("#joinBtn").prop("disabled", true);
					$("#joinBtn").css("background-color", "#aaaaaa"); //회색
					$("#old_pw").css("background-color", "#FFCECE"); 
					pwdCheck = 0;
				}
				console.log(data);
			}
		});
	}

	$(document).ready(function checkPwd() {
		$(document).on('keyup', '#info input', infoChange)
	})
	function infoChange() {
		console.log("..................")

		var password = $("#clientPassword").val();

		if (password == "" || pwdCheck == 0) {
			$("#joinBtn").prop("disabled", true);
			$("#joinBtn").css("background-color", "#aaaaaa");
		} else {
			$("#joinBtn").prop("disabled", false);
			$("#joinBtn").css("background-color", "#4CAF50");
			signupCheck();

		}
	}
	$(function() {

		if ($("#withdrawal2").submit(function() {
				if(confirm("정말 회원탈퇴하시겠습니까? 회원탈퇴시 복구할 수 없습니다.") == false)
					return false; 
				else
					return true;
		}))
			;
	});
</script>

<title>마이페이지</title>
<jsp:include page="../headerCssLink.jspf" />
</head>
<body>
<body id="page-top">
	<c:import url="/clientHeader.do" />

	<section>
		<div class="w3-sidebar2 w3-bar-block" style="position:absolute;  width: 25%; height: 40%">
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

		<!-- 본문 부분(컨테이너) -->

		<section>
		<div style="margin-left: 25%; margin-bottom:15%">
			<div class="w3-content w3-container w3-margin-top w3-margin-bottom">
				<div class="w3-container w3-card-4">
					<div class="w3-center w3-large w3-margin-top">
						<h3>회원탈퇴</h3>
					</div>
					<br> <br>
					<div>
						<form id="withdrawal" action="checkPw.do" method="get">
							<input type="hidden" name="clientId" value="${ login.clientId }">
							<p>
								<label>현재 비밀번호 </label> <input class="w3-input" id="old_pw"
									name="old_pw" type="password" oninput="checkPwd()" required>
							</p>
							<p>
								<label>비밀번호 확인</label> <input class="w3-input" id="old_pwCheck"
									name="old_pwCheck" type="password" required>
							</p>
							</form>
							
							<br> <br>
							
							<form id="withdrawal2" action="withdrawal.do" method="get">
							<p class="w3-center">
								<button type="submit" id="joinBtn" disabled=true
									class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">회원탈퇴</button>
							</p>
						</form>

						<form id="back-1" action="clientMypage.do" method="get">
							<p class="w3-center">
								<input type="submit"
									class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
									value="My Page" />
						</form>
						<br> <br>
						<br>
						</div>
					</div>
				</div>
			</div>
		</section>

		<footer>
			<c:import url="/clientFooter.do" />
		</footer>
	</section>
</body>

<jsp:include page="../headerScriptLink.jspf" />
</html>