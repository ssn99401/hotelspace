<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/client/css/board/QNASidebar.css">
<link rel="stylesheet"
	href="resources/client/css/board/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
</head>
<body>
	<input type=hidden id="clientId" value="${sessionScope.login.clientId}">
	<header>
		<c:import url="/clientHeader.do" />
	</header>
	<div id="QNA-all">
		<div id="QNA-Sidebar">
			<div class="QNA-Sidebar-Header">Q&A</div>
			<div class="QNA-Sidebar-List">
				<ul class="QNA-Sidebar-Style" style="list-style: none;">
					<li><a href="#" id="sideSelected1">전체 보기</a></li>
					<li><a href="#" id="sideSelected2">나의 Q&A 보기</a></li>
				</ul>
			</div>
		</div>

		<div id="QNA-Body">
			<div class="container-fluid">
				<article>
					<section>
						<div>
							<h1 class="mt-4">문의 내역</h1>
							<table border="1" class="QNA-dl-Style">
								<tr>
									<td class="QNA-Selected selected" id="Selected1"><a
										href="#">전체 문의</a></td>
									<td class="QNA-Selected selected" id="Selected2"><a
										href="#">나의 Q&A</a></td>
								</tr>
							</table>
							<div class="ListBody">
								<select class="listLength" name="list-length" id="list-length"
									style="display: none">
									<option value="5">5개 보기</option>
									<option value="10">10개 보기</option>
									<option value="20">20개 보기</option>
								</select> <select class="listLength2" name="list-length2"
									id="list-length2" style="display: none">
									<option value="5">5개 보기</option>
									<option value="10">10개 보기</option>
									<option value="20">20개 보기</option>
								</select> <select class="listLength3" name="list-length3"
									id="list-length3" style="display: none">
									<option value="5">5개 보기</option>
									<option value="10">10개 보기</option>
									<option value="20">20개 보기</option>
								</select>
								<div class="getList"></div>
								<br>
								<table border=0 id="Selected1-dd" class="morebtnT">
									<tr>
										<td colspan=5 align=center>
											<!-- <button id=moreList style="display: none"> -->
											<button id=moreList style="display: none">
												<span>더보기(more)</span>
											</button>
										</td>
									</tr>
								</table>
								<table border=0 id="Selected1-dd" class="morebtnT2">
									<tr>
										<td colspan=5 align=center>
											<!-- <button id=moreList style="display: none"> -->
											<button id=moreList2 style="display: none">
												<span>더보기(more)</span>
											</button>
										</td>
									</tr>
								</table>
								<table border=0 id="Selected1-dd" class="morebtnT3">
									<tr>
										<td colspan=5 align=center>
											<!-- <button id=moreList style="display: none"> -->
											<button id=moreList3 style="display: none">
												<span>더보기(more)</span>
											</button>
										</td>
									</tr>
									<tr>
										<td colspan=5 align=right><c:if
												test="${sessionScope.login.clientId!=null}">
												<a id="forWrite" href="clientQNAServiceForm.do"
													style="font-size: 15px">문의하기</a>
											</c:if></td>
									</tr>
								</table>
								<br>
								<div id="searchForm">
									<!-- <form action="resources/client/js/board/QNA.js"> -->
									<select name="opt" id="search-Type">
										<option value="0">제목</option>
										<option value="1">내용</option>
										<option value="2">제목+내용</option>
										<option value="3">작성자</option>
									</select> <input id="search-Content" type="text" size="20"
										name="condition" /> <input id="search-Btn" type="submit"
										value="검색" />
									<!-- </form> -->
								</div>
							</div>
						</div>
					</section>
				</article>
			</div>
		</div>
	</div>

	<footer>
		<c:import url="/clientFooter.do" />
	</footer>
	<script src="resources/client/js/board/QNA.js"></script>
</body>
</html>