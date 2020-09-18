$(document).ready(function(){
	requestHotelList('1');
});

var data_save = null;

// 테이블 갱신
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
	requestHotelList('1');
})
$(document).on("change","#orderby-area",function(event){
	requestHotelList('1');
})
$(document).on("change","#orderby-average",function(event){
	requestHotelList('1');
})
$(document).on("click","#btn-search",function(event){
	requestHotelList('1');
})
$(document).on("click","#btn-resetFilter",function(event){
	resetFilter();
})
//-------------------------------------------------------------------------------------------------------------------//

function requestHotelList(pageNum) {
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

	var sendData = {
			hotelName : hotelName,
			hotelClientId : hotelClientId,
			hotelAddress : hotelAddress,
			orderbyOption : orderbyOption,
			orderbyName : orderbyName,
			orderbyArea : orderbyArea,
			orderbyStar : orderbyStar,
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

function setHotelListTable(data) {
	var hotelList = data['hotelList'];
	var html = "";
	for(var i = 0; i < hotelList.length; i++ ) {
		html += "<tr><td><a href=javascript:openHotelInfo('"+ hotelList[i].hotelId +"');>"+ 
		hotelList[i].hotelId +"</a></td>"+"<td>"+ hotelList[i].hotelName +"</td>"+"<td>"+ hotelList[i].hotelTel +"</td>"+"<td>"+ hotelList[i].userId + "</td>" 
		+"<td>"+hotelList[i].hotelArea+"</td>" + "<td>"+ hotelList[i].hotelConcept + "</td>" + "<td>"+ hotelList[i].hotelStar + "</td>" + "<td>"+ hotelList[i].hotelRegDate + "</td>" 
		+ "<td><button onclick=javascript:openHotelInfo('"+ hotelList[i].hotelId +"');><img src = 'resources/admin/images/edit.png'>"
		+ "<td><button onclick=javascript:openHotelInfo('"+ hotelList[i].hotelId +"');><img src = 'resources/admin/images/delete.png'>"
		+ "</tr>"
	}

	document.getElementById('hotelList-body').innerHTML = html;
	setHotelListpage(data['count'], data['pageNum'], data['pageBlock'], data['pageSize']);
}

function setHotelListpage(count ,pageNum, pageBlock, pageSize) {
	$('#div-pageNum').empty();
	var divPaging = document.getElementById('div-pageNum');

	if(count > 0) {
		var imsi = count % pageSize == 0 ? 0 : 1;
		var pageCount = count / pageSize + imsi;
		var result = (pageNum - 1) / pageBlock;
		var startPage = result * pageBlock + 1;
		var endPage = startPage + pageBlock - 1;

		if(endPage > pageCount) endPage = pageCount;

		if(startPage > pageBlock) {
			var aTag = document.createElement("a");
			aTag.setAttribute("href","javascript:requestHotelList('" + (startPage - pageBlock) + "');");
			aTag.append("[이전]");
			divPaging.appendChild(aTag);
		}
		for(var i = startPage; i <= endPage; i++) {
			var aTag = document.createElement("a");
			aTag.setAttribute("href","javascript:requestHotelList('"+ i + "');");
			aTag.append("[" + i + "]");
			divPaging.appendChild(aTag);
		}
		if(endPage < pageCount) {
			var aTag = document.createElement("a");
			aTag.setAttribute("href","javascript:requestHotelList('" + (startPage + pageBlock) + "');");
			aTag.append("[다음]");
			divPaging.appendChild(aTag);
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