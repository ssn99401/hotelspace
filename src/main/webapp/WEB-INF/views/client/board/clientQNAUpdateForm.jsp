
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
	/* function SetSelectBox() {
		var schField = $("#claim_Category option:selected").text();
	}
	function SetSelectBox() {
		var schField = $("#claim_Category option:selected").val();
	}
	function NoMultiChk(a) {
		var obj = document.getElementsByName("box");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != a) {
				obj[i].checked = false;
			}
		}
	}
	function NoMultiChk2(b) {
		var obj = document.getElementsByName("box2");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != b) {
				obj[i].checked = false;
			}
		}
	} */
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
				<b>게시글 수정</b>
			</h3>
			</div>
			<hr>
			<form action="QNAupdate.do" method="post"
				>
				<input type="hidden" name="claimNum" value="${update.claimNum}" />
				<table class="conta" >
					<tr>
						<td align="center">카테고리</td>
						<td><b>${update.claimCategory}</b>
					</tr>
					<tr>
						<td align="center">제목</td>
						<td><input type="text" name="claimTitle" id="claimTitle"  value="${update.claimTitle}"
							class="UpTitle" required /></td>
					</tr>
					<tr>
						<td align="center">내용</td>
						<td colspan="1"><textarea rows="20" cols="100" class="UpContent"
								name="claimContent" id="claimContent" required>${update.claimContent}</textarea></td>
					</tr>
					<%-- <tr>
						<td align="center">사진 첨부</td>
						<td><input type="file" name="file" id="file" value="${update.file}"></td>
					</tr> --%>
					
					
					<tr>
						<td></td><td align="center"><input type="hidden" name="clientId" value="${sessionScope.login.clientId}">
						<input type="submit" class="btn btn-outline-danger" value="수정하기" >
						<input type="button" style="margin-left:470px;"class="btn btn-outline-danger" value="목록으로"
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