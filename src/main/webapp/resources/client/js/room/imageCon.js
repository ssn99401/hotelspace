function setImageSlide(index, mainPicture, normalPictures) {
   var html = "";

   html +='<div id="carouselExampleIndicators' + index +'" class="carousel slide" data-ride="carousel" style="padding: 0; padding-top: 10%; padding-left: 5%; padding-right: 5%; height: 80%;" data-interval="false"> ';

   html +='<ol class="carousel-indicators">';
   html +='<li data-target="#carouselExampleIndicators'+ index +'" data-slide-to="0" class="active"></li>';

   for(var i = 1; i < normalPictures.length + 1; i++) {
      html +='<li data-target="#carouselExampleIndicators'+ index +'" data-slide-to="' + i +'"></li>';
   }
   html +='</ol>';
   html +='<div class="carousel-inner">';

   html +='<div class="carousel-item item active">';
   html +='<img class="d-block w-100" src="' + mainPicture.imageLink + '" alt="첫번째 슬라이드">';
   html +='<div class="carousel-caption" style="position: unset; color: #000;">';
   html +='메인 이미지';
   html +='<span style="position: absolute; right: 0;"><button id="addImage-'+ mainPicture.roomId +'" onClick="showAddImageModal(' + "'" + mainPicture.roomId + "'" + ",'" + index + "'" + ')"> + </button>&nbsp;';
   html +='<button id="editImage-'+ mainPicture.roomId +'" onClick="showEditImageModal(' + "'" + mainPicture.roomId + "'" +  ",'" + index + "'" + ')">편집</button></span>';
   html +='</div>';
   html +='</div>';

   for(var i = 0; i < normalPictures.length; i++) {
      html +='<div class="carousel-item item ">';
      html +='<img class="d-block w-100" src="' + normalPictures[i].imageLink + '" alt="두번째 슬라이드">';
      html +='<div class="carousel-caption" style="position: unset; color: #000;">';
      html +='일반 이미지';
      html +='<span style="position: absolute; right: 0;"><button id="addImage-'+ mainPicture.roomId +'" onClick="showAddImageModal(' + "'" + mainPicture.roomId + "'" + ",'" + index + "'" + ')"> + </button>&nbsp;';
      html +='<button id="editImage-'+ mainPicture.roomId +'" onClick="showEditImageModal(' + "'" + mainPicture.roomId + "'" +  ",'" + index + "'" + ')">편집</button></span>';
      html +='</div>';
      html +='</div>';
   }

   /*html +='</div>';

   html +='<a class="carousel-control-prev" href="#carouselExampleIndicators' + index + '" role="button" data-slide="prev" style="left: 5%;"> <span class="carousel-control-prev-icon" ></a>';
   html +='<a class="carousel-control-next" href="#carouselExampleIndicators' + index + '" role="button" data-slide="next" style="right: 5%;"> <span class="carousel-control-next-icon" ></a>';
   html +='</div>';*/

   return html;
}


//페이지 온로드 이벤트
window.onload = function() {
   requestHotelReviewList('${param.hotelId}');
}

// 리뷰 목록 Ajax 요청
function requestHotelReviewList(hotelId) {
   var sendData = {
      hotelId : hotelId
   };
   $.ajax({
      type : "POST",
      url : "getHotelReviewList.do",
      dataType : 'json',
      contentType : 'application/json; charset=utf-8;',
      data : JSON.stringify(sendData),
      success : function(data) {
         setReviewListTable(data);
      },
      error : function(jqXHR, textStatus, errorThrown) {
         alert("error : " + jqXHR.responseText);
      }
   });
}
$('#inDate').change(function(){
	var hotelId = $('#hotelId').val();
	var inDate = $('#inDate').val();
	var outDate = $('#outDate').val();
	location.href = "searchRoom.do?hotelId="+hotelId+"&reservationInDate="+inDate+"&reservationOutDate="+outDate;			
});

$('#outDate').change(function(){
	var hotelId = $('#hotelId').val();
	var inDate = $('#inDate').val();
	var outDate = $('#outDate').val();
	location.href = "searchRoom.do?hotelId="+hotelId+"&reservationInDate="+inDate+"&reservationOutDate="+outDate;
});
