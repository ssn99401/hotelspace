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
   <div id="container">
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

         <!-- <div id="QNA-Body">
         <div class="container-fluid"> -->
         <article id="QNA-Art">
            <section class="QnaSearch-area">
               <div class="Qna-srch">
                  <fieldset>
                     <!-- <legend>문의사항 검색</legend> -->
                     <h3 class="tit">문의사항 검색</h3>
                     <input type="text" name="searchContent" placeholder="검색어를 입력하세요."
                        title="검색어" value="" maxlength="30" id="search-Content2"> <span
                        class="btn_search"><button id="search-Btn2" type="submit">검색</button></span>
                  </fieldset>
               </div>
            </section>
            <ul class="Menu-list">
               <!-- <li class="QNA-Selected selected" id="Selected1"> -->
               <li class="selected" id="Selected1"><a href="#">전체 문의</a><span
                  class="bu"></span></li>
               <li class="selected2" id="Selected2"><a href="#">나의 Q&A</a></li>
            </ul>
            <select class="listLength" name="list-length" id="list-length"
               style="display: none">
               <option value="5">5개 보기</option>
               <option value="10">10개 보기</option>
               <option value="20">20개 보기</option>
            </select> <select class="listLength2" name="list-length2" id="list-length2"
               style="display: none">
               <option value="5">5개 보기</option>
               <option value="10">10개 보기</option>
               <option value="20">20개 보기</option>
            </select> <select class="listLength3" name="list-length3" id="list-length3"
               style="display: none">
               <option value="5">5개 보기</option>
               <option value="10">10개 보기</option>
               <option value="20">20개 보기</option>
            </select>
            <div class="Qna-table-Box">
               <table border='1' class="Qna-Table">
                  <colgroup>
                     <col style="width: 30px">
                     <col style="width: 75px">
                     <col style="width: 90px">
                     <col style="width: 500px">
                     <col style="width: 50px">
                     <col style="width: 100px">
                  </colgroup>
                  <thead class="Qna-Thead">
                  </thead>
                  <tbody class="QNA-List-All">
                  </tbody>
               </table>
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
            </div>
            <div class="searchForm">
               <fieldset>
                  <select name="opt" id="search-Type" style="width: 100px;">
                     <option value="0">제목</option>
                     <option value="1">내용</option>
                     <option value="2">제목+내용</option>
                     <option value="3">작성자</option>
                  </select>
                  <input id="search-Content" type="text" size="20" name="condition" />
                  <input id="search-Btn" type="submit" value="검색" />
               </fieldset>
            </div>
         </article>>
      </div>
   </div>

   <footer>
      <c:import url="/clientFooter.do" />
   </footer>
   <script src="resources/client/js/board/QNA.js"></script>
</body>
</html>