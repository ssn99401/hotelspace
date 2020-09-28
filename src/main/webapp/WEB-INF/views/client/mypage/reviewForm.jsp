<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Bootstrap 4 -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!--  Start Rating -->
<link href="resources/client/css/star-rating.css" media="all"
   rel="stylesheet" type="text/css" />
<!-- jQuery -->
<script src="resources/client/js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="resources/client/js/jquery.min.js" type="text/javascript"></script>
<!--  Star Rating  -->
<script src="resources/client/js/star-rating.js" type="text/javascript"></script>
<script>
   $(document).ready(function() {
      
      var form = $('form#reviewForm');
      
      $(form).submit(function(e) {
         if ($("#content").val()=="") {
            alert("공백은 입력이 불가능합니다.");
            $("#content").val("").focus();
            return false;
         }
         e.preventDefault();
         
         var formData = $(form).serialize();
         
         $.ajax({
            type:'POST',
            data:formData,
            url:$(form).attr('action'),
            success:function(data) {
               
               alert("리뷰가 등록되었습니다.");

               opener.document.location.reload();

               self.close();


            }
         });
      });
   });

</script>
<title>리뷰 달기</title>
</head>
<body>
   <div style="margin: 10%">
      <form:form id="reviewForm" modelAttribute="review"
         action='addReview.do' method="post">
         <form:textarea id="content" path="reviewContent"
            cssClass="form-control" rows="5" />
         <!-- 평점 선택창 -->
         <form:label id="star" path="reviewStar">평점: </form:label>
         <form:select path="reviewStar">
            <form:options items="${ ratingOptions }" />
         </form:select>
         <form:hidden path="reviewId" />
         <form:hidden path="reservationId" />
         <form:hidden path="hotelId" />
         <form:hidden path="roomId" />
         <form:hidden path="reviewParentComment" />
         <input
            class="w3-button w3-block w3-pink w3-ripple w3-margin-top w3-round"
            type="submit" value="리뷰 등록" />
      </form:form>
   </div>
</body>
</html>