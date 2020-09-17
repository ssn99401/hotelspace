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
	function email_check( clientEmail ) { 
		var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; 
	return (clientEmail != '' && clientEmail != 'undefined' && regex.test(email));
	}
	
	
	$(document).ready(function) { 
		// name 속성이 'email'인 input 이 focus를 잃었을때 처리한다. 
		$("input[name='clientEmail']").blur(function(){ 
			var email = $(this).val(); // 값을 입력안한경우는 아예 체크를 하지 않는다.
			if( email == '' || email == 'undefined') 
		return; // 이메일 유효성 검사 
		if(! email_check(email) ) { 
			alert('잘못된 형식의 이메일 주소입니다.'); $(this).focus(); 
			return false; } 
			}); 
		});
</script>
		
<script>
   $(function(){
      if(${msg ne null}){
         alert('${msg}');
      };
      
   })
</script>
<title>마이페이지</title>
<jsp:include page="../headerCssLink.jspf" />
</head>
<body>
<body id="page-top">
	<c:import url="/clientHeader.do" />
	<section>
		<div class="w3-content w3-container w3-margin-top">
			<div class="w3-container w3-card-4">
				<div class="w3-content w3-container w3-margin-top w3-margin-bottom"
					align="center">
					<h3>개인정보 변경</h3>
				</div>
				<div>
					<form id="myForm" action="mypageUpdate.do" method="post">
						<p>
							<label>ID</label> <input class="w3-input" type="text" id="id"
								name="clientId" readonly value="${ login.clientId }">
						</p>
						<p>
							<label>이름</label> <br> <input class="w3-input" type="text"
								id="clientName" name="clientName" readonly
								value="${ login.clientName }">
						</p>
						<p>
							<label>Email</label> <input class="w3-input" type="text"
								id="clientEmail" name="clientEmail"
								placeholder="example@email.com" required />
						</p>
						<p>
							<label>전화번호</label> <input class="w3-input" type="text"
								placeholder="010-XXXX-XXXX" id="clientTel" name="clientTel"
								required />
						</p>

						<br> <br> <input class="w3-input" type="hidden"
							id="clientBirth" name="clientBirth"
							value="${ login.clientBirth }"> <input class="w3-input"
							type="hidden" id="clientRegDate" name="clientRegDate"
							value="${ login.clientRegDate }">
						<p class="w3-center">
							<input type="submit"
								class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
								value="회원정보 변경" />
					</form>

					<form id="back-1" action="clientMypage.do" method="get">
						<p class="w3-center">
							<input type="submit"
								class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
								value="My Page" />
					</form>
					<br> <br>
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