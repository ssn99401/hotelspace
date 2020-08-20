<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
   $(function(){
      if(${msg ne null}){
         alert('${msg}');
      };
      
 /*      if($("#pwForm").submit(function(){
         if($("#pw").val() !== $("#pw2").val()){
            alert("비밀번호가 다릅니다.");
            $("#pw").val("").focus();
            $("#pw2").val("");
            return false;
         }else if ($("#pw").val().length < 8) {
            alert("비밀번호는 8자 이상으로 설정해야 합니다.");
            $("#pw").val("").focus();
            return false;
         }else if($.trim($("#clientEmail").val()) !== $("#pw").val()){
            alert("공백은 입력이 불가능합니다.");
            return false;
         }
      })); */
   })
</script>
<title>마이페이지</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>개인정보 변경</h3>
			</div>
			<div>
				<form id="myForm" action="mypageUpdate.do" method="post">
					<p>
						<label>ID</label> <input class="w3-input" type="text" id="id"
							name="clientId" readonly value="${ login.clientId }" >
					</p>
					<p>
						<label>이름</label> <input class="w3-input" type="text"
							id="clientName" name="clientName" readonly value="${ login.clientName }" >
					</p>
					<p>
						<label>Email</label> <input class="w3-input" type="text"
							id="clientEmail" name="clientEmail"  value="${ login.clientEmail }" required>
					</p>
					<p>
						<label>전화번호</label> <input class="w3-input" type="text"
							id="clientTel" name="clientTel" value="${ login.clientTel }" required>
					</p>
					
					 <input class="w3-input" type="hidden"
							id="clientBirth" name="clientBirth" value="${ login.clientBirth }">
					<input class="w3-input" type="hidden"
							id="clientRegDate" name="clientRegDate" value="${ login.clientRegDate }">
					<p class="w3-center">
						<input type="submit"
							class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round" value="회원정보 변경"/>
							
					</p>

				</form>
			</div>

		</div>
	</div>



</body>
</html>