<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="resources/client/css/board/QNA.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>

<script>
	//댓글 리스트 출력
	function ReplyList() {
		$.ajax({
					type : 'GET',
					url : "Replylist.do",
					dataType : "json",
					data : $("#ReplyForm").serialize(),
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					success : function(data) {
						var sessionId = "${sessionScope.login.clientId}";
						var html = "";
						var cCnt = data.length;

						if (data.length > 0) {

							for (i = 0; i < data.length; i++) {
								html += "<div><div><div><div>";
								html += "<div><table class='table'><h6><strong>"
										+ data[i].clientName
										+ '(' 
										+ data[i].replyDate
										+')'
										+ "</strong></h6>";
										if(data[i].replyDate != data[i].replyAdate){
								html += "<div align='right'>" 
										+ '(수정시간:'
										+ data[i].replyAdate
										+ ')'
										+"</div>";
										}
								html += data[i].replyContent
										+ "<tr><td></td></tr>";
								if (sessionId == data[i].clientId) {
									html += "<div align='right'>";
									html += '<a onclick="ReplyUpdate('
											+ data[i].replyNum
											+ ',\''
											+ data[i].replyContent
											+ '\',\''
											+ i
											+ '\');" class="btn btn-link"> 수정 </a>';
									html += '<a onclick="ReplyDelete('
											+ data[i].replyNum
											+ ');" class="btn btn-link"> 삭제 </a>';
								}
								html += "</div>";

								html += "</div>";
								html += "<div id='"+i+"upform'></div>"
								html += "</table></div>";
								html += "</div>"
								html +=	"</div>"
								html +=	"</div>"
								html +=	"</div>";
							}
						} else {

							html += "<div>";
							html += "<div align='center'><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
							html += "</table></div>";
							html += "</div>";
							html += "<br><br>";

						}

						$("#cCnt").html(cCnt);
						$("#ReplyList").html(html);

					},
					error : function(request, status, error) {

					}

				});
	}
	$(document).ready(function() {
		ReplyList(); //페이지 로딩시 댓글 목록 출력 
		//댓글 쓰기
		$("#btnReply").click(function() {
			var replyContent = $("#replyContent").val(); //댓글 내용
			var claimNum = "${read.claimNum}"; //게시물 번호
			var clientId = "${sessionScope.login.clientId}";
			var param = {
				"replyContent" : replyContent,
				"claimNum" : claimNum,
				"clientId" : clientId
			};
			//var param="replytext="+replytext+"&bno="+bno;
			$.ajax({
				type : "POST", //데이터를 보낼 방식
				url : "ReplyInsert.do", //데이터를 보낼 url
				data : param, //보낼 데이터

				success : function() { //데이터를 보내는것이 성공했을시 출력되는 메시지
					alert("댓글이 등록되었습니다.");
					ReplyList(); //댓글 목록 출력
				}
			});
		});
	});

	//댓글 수정 
	function ReplyUpdate(replyNum, replyContent, i) {
		alert("수정하기");
		var a = '';

		a += '<div class="input-group">';
		a += '<input type="text" class="form-control" value="'+replyContent+'" id="Reply'+replyNum+'" name="Reply'+replyNum+'"/>';
		a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="ReplyUpdateProc('
				+ replyNum
				+ ');">수정하기</button> <button class="btn btn-default" type="button" onclick="ReplyList();">취소</button></span>';
		a += '</div>';
		$("#" + i + "upform").html(a);

	}

	//댓글 수정
	function ReplyUpdateProc(replyNum) {

		var replyContent = $('#Reply' + replyNum).val();
		var param = {
			"replyContent" : replyContent,
			"replyNum" : replyNum
		};
		$.ajax({
			url : 'ReplyUpdate.do',
			type : 'GET',
			data : param,
			success : function(data) {
				alert("수정이 완료되었습니다.");
				
				ReplyList(); //댓글 수정후 목록 출력 
			}

		});
	}
	//댓글 삭제 
	function ReplyDelete(replyNum) {

		var params = {
			"replyNum" : replyNum
		};
		$.ajax({
			url : 'ReplyDelete.do',
			type : 'GET',
			data : params, //보낼 데이터
			success : function() {
				alert("댓글이 삭제되었습니다.");
				ReplyList(); //댓글 삭제후 목록 출력 
			}
		});
	}
</script>
</head>
<body>
	<header>
		<c:import url="/clientHeader.do" />
	</header>
	<div class="readForm">
		<form method="post">
			<div class="maintitle">
				<b>게시글보기</b>
			</div>
			<hr>
			<div>
				<table>
					<tbody>
						<tr>
							<th scope="row">카테고리 :</th>
							<td>${read.claimCategory}</td>
						<tr>
							<th scope="row">작성자 :</th>
							<td>${read.clientId}</td>
							<th scope="row">작성시간 :</th>
							<td><fmt:formatDate value="${read.claimQdate}"
									pattern="yyyy-MM-dd HH:mm" /></td>

						</tr>
						<c:if test="${read.claimQdate!=read.claimAdate}">
							<tr>
								<th scope="row">수정시간 :</th>
								<td><fmt:formatDate value="${read.claimAdate}"
										pattern="yyyy-MM-dd HH:mm" /></td>
							</tr>
						</c:if>
						<tr>
							<td><br></td>
						</tr>
					</tbody>
				</table>
				<div>
					<table>
						<tr>
							<th class="titleTh">제목 :</th>
							<th class="titleTh2"><input style="width: 1100px;"
								value="${read.claimTitle}"></th>
						</tr>
					</table>
					<c:if test="${read.claimPhoto != null}">
						<table>
							<tr>
								<th>첨부이미지:<img class="imgs" src="${read.claimPhoto}">
								</th>
							</tr>
						</table>
					</c:if>
					<table class="tabtext">
						<tr>
							<td align="center"><textarea rows="20" cols="180"
									class="context" readonly="readonly">${read.claimContent }</textarea></td>
						</tr>
					</table>
				</div>
				<div align="right">
					<input type="button" style="font-size: 14px;" value="목록으로"
						class="btn btn-link"
						onclick="location.href='clientQNAServices.do'"> <input
						type="hidden" name="claimNum" value="${read.claimNum}">
					<c:if test="${sessionScope.login.clientId == read.clientId}">
						<input type="button" style="font-size: 14px;" value="수정하기"
							class="btn btn-link"
							onclick="location.href='clientQNAUpdateForm.do?claimNum=${read.claimNum}'">
						<input type="button" style="font-size: 14px;" value="삭제하기"
							class="btn btn-link" id="btnDelete"
							onclick="location.href='QNAdelete.do?claimNum=${read.claimNum}'">
					</c:if>
				</div>
			</div>
		</form>
		<%-- <!--  댓글  -->
	<div class="container">
		<label for="content">댓글쓰기</label>
		<form name="ReplyInsertForm" id="ReplyInsertForm">
			<div class="input-group">
				<input type="hidden" name="claimNum" value="${read.claimNum}" />
				<input type="hidden" name="RclaimNum" value="${replyNum}" /> <input
					type="text" class="form-control" id="content" name="content"
					placeholder="내용을 입력하세요."> <span class="input-group-btn">
					<input class="btn btn-default" type="button" name="ReplyInsertBtn" id="ReplyInsertBtn" value="등록"></input>
				</span>
			</div>
		</form>
	</div>
	<div class="container">
		<div class="ReplyList"></div>
	</div> --%>
		<div class="container">
			<form id="ReplyForm" name="ReplyForm" method="POST">

				<div>
					<div>
						<span><strong>댓글수</strong></span> <span id="cCnt"></span>
					</div>
					<div>
						<table class="table">
							<tr>
								<c:if test="${sessionScope.login.clientId != null }">
									<td><textarea style="width: 1000px" rows="5" cols="50"
											id="replyContent" name="replyContent" placeholder="댓글을 입력하세요"></textarea>
										<button type="button" id="btnReply"
											class="btn btn-outline-danger">댓글쓰기</button> <br>
										<hr></td>


									<input type="hidden" id="clientId" name="clientId"
										value="${sessionScope.login.clientId}" />

								</c:if>
							</tr>
						</table>
					</div>
				</div>

				<input type="hidden" id="claimNum" name="claimNum"
					value="${read.claimNum}" /> <input type="hidden" id="RclaimNum"
					name="RclaimNum" value="${replyNum}" />
			</form>
		</div>
		<div class="container">
			<form id="ReplyListForm" name="ReplyListForm" method="get">
				<div id="ReplyList"></div>
			</form>
		</div>
	</div>
	<footer>
		<c:import url="/clientFooter.do" />
	</footer>

</body>
</html>
