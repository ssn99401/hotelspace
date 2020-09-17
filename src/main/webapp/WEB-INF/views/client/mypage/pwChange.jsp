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
      data : { pw : inputed },
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
               $("#joinBtn").css("background-color", "#4CAF50");
            }
            
         } else if (data == '0') {//비밀번호가 일치하지 않을때
            $("#joinBtn").prop("disabled", true);
            $("#joinBtn").css("background-color", "#aaaaaa");
            $("#old_pw").css("background-color", "#FFCECE");
            pwdCheck = 0;
         }
         console.log(data);
      }
   });
}

$(document).ready(function checkPwd(){
   $(document).on('keyup', '#info input', infoChange)
})
function infoChange() {
   console.log("..................")

   var password = $("#clientPassword").val();

   if (password == "" || pwdCheck == 0 ) {
      $("#joinBtn").prop("disabled", true);
      $("#joinBtn").css("background-color", "#aaaaaa");
   }
   else{
      $("#joinBtn").prop("disabled", false);
      $("#joinBtn").css("background-color", "#4CAF50");
      signupCheck();
      
      
   }
}
   $(function(){
       
      if($("#changePW").submit(function(){
    	  if($("#old_pw").val() == $("#pw").val()){
         	 alert("현재와 동일한 패스워드는 변경이 불가능합니다.");
         	 $("#pw").val("").focus();
             $("#pw2").val("");
             return false;
    	  }else if($("#pw").val() !== $("#pw2").val()){
            alert("비밀번호가 다릅니다.");
            $("#pw").val("").focus();
            $("#pw2").val("");
            return false;
         }else if ($("#pw").val().length < 8) {
            alert("비밀번호는 8자 이상으로 설정해야 합니다.");
            $("#pw").val("").focus();
            return false;
         }else if($.trim($("#pw").val()) !== $("#pw").val()){
            alert("공백은 입력이 불가능합니다.");
            return false;
         }
      }));
   });
</script>
<title>My Page</title>
<jsp:include page="../headerCssLink.jspf" />
</head>
<body>
	<c:import url="/clientHeader.do" />

	<section id="middle">
		<div class="w3-content w3-container w3-margin-top w3-margin-bottom">
			<div class="w3-container w3-card-4">
				<div class="w3-center w3-large w3-margin-top">
					<h3>비밀번호 변경</h3>
				</div>
				<br> <br>
				<div>
					<form id="changePW" action="pwChange.do" method="post">
						<input type="hidden" name="clientId" value="${ login.clientId }">
						<p>
							<label>현재 비밀번호 확인</label> <input class="w3-input" id="old_pw"
								name="old_pw" type="password" oninput="checkPwd()" required>
						</p>
						<p>
							<label>새 비밀번호</label> <input class="w3-input" id="pw"
								name="clientPassword" type="password" required>
						</p>
						<p>
							<label>새 비밀번호 확인</label> <input class="w3-input" id="pw2"
								type="password" required>
						</p>
						<br> <br>
						<p class="w3-center">
							<button type="submit" id="joinBtn" disabled= true
								class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round">비밀번호
								변경</button>
						</p> 
					</form>
					
					<form id="back-1" action="clientMypage.do" method="get">
						<p class="w3-center">
							<input type="submit"
								class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
								value="My Page" />
					</form>
					<br> <br><br>
				</div>
			</div>
		</div>
	</section>
</body>

<footer>
	<c:import url="/clientFooter.do" />
</footer>

<jsp:include page="../headerScriptLink.jspf" />
</html>
