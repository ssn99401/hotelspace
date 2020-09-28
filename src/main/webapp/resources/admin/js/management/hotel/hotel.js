$(document).ready(function(){
	requestHotelList('1');
});

var data_save = null;
var currentPageNum = 1;

//테이블 갱신
function reloadTable() {
	$.ajax({
		type: "POST",
		url : "hotelList.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(data_save),
		success : function(data) {
			setHotelListTable(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//필터 변경 시 목록 다시 요청
$(document).on("change","#criteria",function(event){
	requestHotelList('1');
})
$(document).on("change","#pageSize",function(event){
	requestHotelList('1');
})
$(document).on("change","#orderby-name",function(event){
	setRarioButton(event.target);
	requestHotelList('1');
})
$(document).on("change","#orderby-area",function(event){
	setRarioButton(event.target);
	requestHotelList('1');
})
$(document).on("change","#orderby-average",function(event){
	setRarioButton(event.target);
	requestHotelList('1');
})
$(document).on("click","#btn-search",function(event){
	requestHotelList('1');

})
$(document).on("click","#btn-resetFilter",function(event){
	resetFilter();
})
//-------------------------------------------------------------------------------------------------------------------//

// 호텔 리스트 요청
function requestHotelList(pageNum) {
	currentPageNum = pageNum;
	var hotelName = $("#hotelName").val();
	var hotelAddress = $("#hotelAddress").val();
	var hotelClientId = $("#hotel_clientId").val();
	var selectedOrderByOption = document.getElementById('criteria');
	selectedOrderByOption = selectedOrderByOption.options[selectedOrderByOption.selectedIndex].value;
	var orderbyOption = null;
	orderbyOption = selectedOrderByOption == '정렬' || selectedOrderByOption == '오름차순' ? 'ASC' : 'DESC';

	var pageSize = document.getElementById('pageSize');
	pageSize = (pageSize.options[pageSize.selectedIndex].value).substring(0, 2);
	var orderbyName = null;
	var orderbyArea = null;
	var orderbyStar = null;

	if($('#orderby-name').prop('checked')) 
		orderbyName = document.getElementById('orderby-name').value;
	if($('#orderby-area').prop('checked')) 
		orderbyArea = document.getElementById("orderby-area").val;
	if($('#orderby-average').prop('checked')) 
		orderbyStar = document.getElementById('orderby-average').val;

//	var check_count = document.getElementsByName("order").length;
//	var checkedOrderValue = null;
//	for (var i=0; i<check_count; i++) {
//	if (document.getElementsByName("order")[i].checked == true) {
//	checkedOrderValue = document.getElementsByName("order")[i].value;
//	}
//	}
	var checkedOrderValue =  $(':radio[name="orderby"]:checked').val();

	var sendData = {
			hotelName : hotelName,
			hotelClientId : hotelClientId,
			hotelAddress : hotelAddress,
			orderbyOption : orderbyOption,
			checkedOrderValue : checkedOrderValue,
//			orderbyName : orderbyName,
//			orderbyArea : orderbyArea,
//			orderbyStar : orderbyStar,
			pageNum : pageNum,
			pageSize : pageSize
	};

	data_save = sendData;

	$.ajax({
		type: "POST",
		url : "hotelList.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			setHotelListTable(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});

}

// 호텔 리스트 테이블 set
function setHotelListTable(data) {
	var hotelList = data['hotelList'];
	var html = "";
	for(var i = 0; i < hotelList.length; i++ ) {
		html += "<tr><td><a href=javascript:openHotelInfo('"+ hotelList[i].hotelId +"');>"+ 
		hotelList[i].hotelId +"</a></td>"+"<td>"+ hotelList[i].hotelName +"</td>"+"<td>"+ hotelList[i].hotelTel +"</td>"+"<td>"+ hotelList[i].userId + "</td>" 
		+"<td>"+hotelList[i].hotelArea+"</td>" + "<td>"+ hotelList[i].hotelConcept + "</td>" + "<td>"+ hotelList[i].hotelStar + "</td>" + "<td>"+ hotelList[i].hotelRegDate + "</td>" 
		+ "<td><button onclick=javascript:openHotelInfo('"+ hotelList[i].hotelId +"');><img src = 'resources/admin/images/edit.png'>"
		+ "<td><button onclick=javascript:deleteHotel('"+ hotelList[i].hotelId +"');><img src = 'resources/admin/images/delete.png'>"
		+ "</tr>"
	}

	document.getElementById('hotelList-body').innerHTML = html;
	setHotelListpage(data);
}

// 호텔 리스트 페이징 처리
function setHotelListpage(data) {
	$('#div-pageNum').empty();
	var divPaging = document.getElementById('div-pageNum');
	var html = "";
	if(data['pagination'].curRange != 1) {
        html += '<a href="#" onClick="requestHotelList(' + "'" + 1 + "'" + ')">[처음]</a>&nbsp;';
     }
     if(data['pagination'].curPage != 1) {
        html += '<a href="#" onClick="requestHotelList('+ "'" + data['pagination'].prevPage + "'" +')">[이전]</a>&nbsp;&nbsp;';
     }
     for(var i = data['pagination'].startPage; i <= data['pagination'].endPage; i++) {
        if(data['pageNum'] == data['pageNum'].curPage) {
           html += '<span style="font-weight: bold;"><a href="#" onClick="requestHotelList(' + "'" + i + "'" + ')">'+ i +'</a>&nbsp;&nbsp;</span>';
        } else {
           html += '<a href="#" onClick="requestHotelList(' + "'" + i + "'" +')">' + i + '</a>&nbsp;&nbsp;';
        }
     }
     if(data['pagination'].curPage != data['pagination'].pageCnt && data['pagination'].pageCnt > 0) {
        html += '<a href="#" onClick="requestHotelList(' + "'" + data['pagination'].nextPage + "'"  + ')">[다음]</a>&nbsp;';
     }
     if(data['pagination'].curRange != data['pagination'].rangeCnt && data['pagination'].pageCnt > 0) {
        html += '<a href="#" onClick="requestHotelList('+ "'" + data['pagination'].pageCnt + "'" + ')">[끝]</a>';
     }

     divPaging.innerHTML = html;
}

//선택 호텔삭제 요청
function deleteHotel(hotelId) {
	if (confirm("정말 삭제하시겠습니까?") != true){    //확인
		return
	}
	var sendData = {
			hotelId : hotelId
	};
	$.ajax({
		type: "POST",
		url : "deleteHotel.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			requestHotelList(currentPageNum);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//라디오 박스 나머지 버튼 체크 해제
function setRarioButton(btn) {
	var radioBoxArray = document.getElementsByName("orderby");
	for(var i=0; i < radioBoxArray.length; i++){
		if (radioBoxArray[i].value != btn.value) {
			radioBoxArray[i].checked = false;
		}
	}
}

function resetFilter() {
	$("#hotelName").val('');
	$("#hotelAddress").val('');
	$("#hotel_clientId").val('');
	requestHotelList('1');
}

function openHotelInfo(hotelId) {
	var popupWidth = (window.screen.width / 1.5);
	var popupHeight = (window.screen.height / 1.5);

	var popupX = (window.screen.width / 2) - (popupWidth / 2);

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	window.open('hotelInfoView.mdo?hotelId=' + hotelId , '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY); 
}

function openRegisterHotel() {
	var popupWidth = (window.screen.width / 1.5);
	var popupHeight = (window.screen.height / 1.5);

	var popupX = (window.screen.width / 2) - (popupWidth / 2);

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	window.open('hotelRegisterView.mdo', '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY); 
}
