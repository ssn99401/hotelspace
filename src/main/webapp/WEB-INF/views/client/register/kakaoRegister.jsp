<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<script src="resources/client/js/jquery-3.3.1.js"></script>


<head>
<script>
	//닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
	function signupCheck() {
		var email = $("#clientEmail").val();
		var tel = $("#clientTel").val();
		var birth = $("#clientBirth").val();
		var name = $("#clientName").val();
		if (email == "" || tel == "" || birth == "" || name == "") {
			$(".signupbtn").prop("disabled", true);
			$(".signupbtn").css("background-color", "#aaaaaa");
		} else {
		}
	}

	$(document).ready(function() {
		$(document).on('keyup', '#info input', infoChange)
	})

	function infoChange() {
		console.log("..................")

		var email = $("#clientEmail").val();
		var tel = $("#clientTel").val();
		var birth = $("#clientBirth").val();
		var name = $("#clientName").val();

		if (email == "" || tel == "" || birth == "" || name == "") {
			$(".signupbtn").prop("disabled", true);
			$(".signupbtn").css("background-color", "#aaaaaa");
		} else {
			$(".signupbtn").prop("disabled", false);
			$(".signupbtn").css("background-color", "#4CAF50");
			signupCheck();

		}
	}

	//캔슬버튼 눌렀을 눌렀을시 인풋박스 클리어
	function index() {	
		location.href = "clientLogout.do";
		
		//카카오 로그인 연결 끊기 넣기///////
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<form action="RegisterInsert.do" method="Post" id="info">
		<h2>카카오 회원가입</h2>
		<table class="table table-boardered">
			<input type="hidden" id="clientId" name="clientId" value="${login.clientId}">
			<input type="hidden" id="clientPassword" name="clientPassword" value="kakao">

			<tr>
				<th>이름</th>
				<td><input type="text" class="form-control" id="clientName"
					name="clientName"></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="Date" class="form-control" id="clientBirth"
					name="clientBirth"></td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><input type="email" class="form-control" id="clientEmail"
					name="clientEmail"></td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td><input type="tel" class="form-control" id="clientTel"
					name="clientTel"></td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="button" class="cancelbtn" onclick="index()">Cancel</button>
					<input type="submit" class="signupbtn" disabled="disabled"
					value="Sign Up">
			</tr>


		</table>

	</form>
</body>
</html>