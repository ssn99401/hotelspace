<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
</style>
<title></title>
<link rel="stylesheet" href="resources/client/css/board/QNA.css">
<script>
	function SetSelectBox() {
		var schField = $("#claim_Category option:selected").text();
	}
	function SetSelectBox() {
		var schField = $("#claim_Category option:selected").val();
	}
	/* function NoMultiChk(a) {
		var obj = document.getElementsByName("claimSecret");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != a) {
				obj[i].checked = false;
			}
		}
	}
	function NoMultiChk2(b) {
		var obj = document.getElementsByName("claimSecret");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != b) {
				obj[i].checked = false;
			}
		}
	} */
	 function imgValidChk() { 
		 alert("(JPG, PNG, GIF 파일만 업로드가 가능합니다)");
		 if( $("#file").val() != "" ){

			 var ext = $('#file').val().split('.').pop().toLowerCase();

			       if($.inArray(ext, ['JPG','PNG','GIF']) == -1) {

			 	 alert('JPG, PNG, GIF 파일만 업로드 할수 있습니다.');
			 	
			 	 return;

			       }

			 }

	 }

			
</script>

</head>
<body>
	<header>
		<c:import url="/clientHeader.do" />
	</header>
	<div align="center">
		<div class="container">
			<div>
				<h3>
					<b>게시글 작성</b>
				</h3>
			</div>
			<hr>
			<form action="QNAInsert.do" method="post"
				enctype="multipart/form-data">
				<table class="conta">
					<tr>
						<td align="center">카테고리</td>
						<td><select id="claimCategory" name="claimCategory"
							onchange="SetSelectBox();">
								<option value="결제 및 환불 ">결제 및 환불</option>
								<option value="변경 및 취소 ">변경 및 취소</option>
								<option value="체크인 및 체크아웃 ">체크인 및 체크아웃</option>
								<option value="기타 문의 ">기타 문의</option>
						</select></td>

					</tr>

					<tr>
						<td align="center">제목</td>
						<td><input type="text" name="claimTitle" id="claimTitle"
							required /></td>
					</tr>
					<tr>
						<td align="center">내용</td>
						<td colspan="1"><textarea rows="20" cols="100"
								name="claimContent" id="claimContent" required></textarea></td>
					</tr>
					<tr>
						<td align="center">이미지 첨부</td>
						<td><input type="file" name="file" id="file" 
							onclick="imgValidChk();"> (JPG, PNG, GIF 파일만 가능합니다)</td>
					</tr>
					<!-- <tr>
						<td >답변시 이메일 수신 여부</td>
						<td>수신<input type="checkbox" name="box" value="a1"
							onclick="NoMultiChk(this);"> 비수신 <input type="checkbox"
							name="box" value="a2" onclick="NoMultiChk(this);"></td>
					</tr> -->
					<tr>
						<td align="center">게시글 공개 여부</td>
						<td><img src="resources/client/images/secretLock1.png"
                     width="20px"> <b>공개</b><input type="radio" name="claimSecret"
                     value="공개" class="b1" checked> <img
                     src="resources/client/images/secretLock2.png" width="20px">
                     <b>비공개</b><input type="radio" class="b2" name="claimSecret"
                     value="비공개"></td>
					</tr>
					<tr>
						<td></td>
						<td align="center"><input type="hidden" name="clientId"
							value="${sessionScope.login.clientId}"> <input
							type="submit" class="btn btn-outline-danger" value="작성하기">
							<input type="button" style="margin-left: 470px;"
							class="btn btn-outline-danger" value="목록으로"
							onclick="location.href='clientQNAServices.do'"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<footer>
		<c:import url="/clientFooter.do" />
	</footer>
</body>
</html>