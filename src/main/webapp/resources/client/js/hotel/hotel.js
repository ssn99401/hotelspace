

function checkSearchDate() {

	var checkInDate = document.getElementById("checkInDate").value;        
	var checkInDate_arr = checkInDate.split("-");
	var checkOutDate = document.getElementById("checkOutDate").value;    
	var checkOutDate_arr = checkOutDate.split("-");

	if(checkInDate == "" || checkOutDate == "") {
		alert("날짜를 선택해 주세요");
		return null;
	}

	var checkInDate_obj = new Date(checkInDate_arr[0], Number(checkInDate_arr[1])-1, checkInDate_arr[2]);
	var checkOutDate_obj = new Date(checkOutDate_arr[0], Number(checkOutDate_arr[1])-1, checkOutDate_arr[2]);

	var betweenDay = (checkOutDate_obj.getTime() - checkInDate_obj.getTime());

	if(betweenDay <= 0) {
		alert("날짜를 확인해 주세요");
		return false;
	} else {
		return true;
	}

}


function searchHotel() {

	if(checkSearchDate()) {
		var sendData  = {
				searchKeyword : $('#searchKeyword').val(), 
				checkInDate : $('#checkInDate').val(), 
				checkOutDate : $('#checkOutDate').val(), 
				people : $('#people').val(), 
				area : $('#area').val(),
				pageNum : "1 "
		};

		$.ajax({
			type: "POST",
			url : "searhHotelToBar.do",
			dataType : 'json',
			contentType : 'application/json;  charset=utf-8;',
			data: JSON.stringify(sendData),
			success : function(data) {
				setHotelList(data);
				clearFilter();
			},
			error: function(jqXHR, textStatus, errorThrown) {
				alert("error : " + jqXHR.responseText);
			}
		});
	}
}

function fillteringToSearch() {

	var sendData = {};
	
	var concepts = document.getElementsByName("f-accid");
	
	sendData.checkedKeyword = $('#checkedKeyword').val();
	if($('#parking').prop('checked'))
		sendData.parking = $('#parking').val();
	if($('#pool').prop('checked'))
		sendData.pool = $('#pool').val();
	if($('#breakfast').prop('checked'))
		sendData.breakfast = $('#breakfast').val();
	if($('#fitness').prop('checked'))
		sendData.fitness = $('#fitness').val();
	if($('#wifi').prop('checked'))
		sendData.WIFI = $('#wifi').val();
	if($('#partyRoom').prop('checked'))
		sendData.partyRoom = $('#partyRoom').val();

	for(var i=0; i<concepts.length; i++){
		if(concepts[i].checked)
			sendData.checkedConcept = concepts[i].value;
	}
	var star = $('#amount2').val().split(' ~ ');
	sendData.minStar = star[0];
	sendData.maxStar = star[1];

	var priceRange = $('#amount').val().replace(/₩/g, "").split(' ~ ');
	sendData.minPrice = priceRange[0];
	sendData.maxPrice = priceRange[1];

	$.ajax({
		type: "POST",
		url : "applyFillter.do",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			setHotelList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});

}

function movePage(pageNum) {

	var sendData = {};
	var concepts = document.getElementsByName("f-accid");
	sendData.pageNum = pageNum;
	sendData.checkedKeyword = $('#checkedKeyword').val();
	if($('#parking').prop('checked'))
		sendData.parking = $('#parking').val();
	if($('#pool').prop('checked'))
		sendData.pool = $('#pool').val();
	if($('#breakfast').prop('checked'))
		sendData.breakfast = $('#breakfast').val();
	if($('#fitness').prop('checked'))
		sendData.fitness = $('#fitness').val();
	if($('#wifi').prop('checked'))
		sendData.WIFI = $('#wifi').val();
	if($('#partyRoom').prop('checked'))
		sendData.partyRoom = $('#partyRoom').val();

	for(var i=0; i<concepts.length; i++){
		if(concepts[i].checked)
			sendData.checkedConcept = concepts[i].value;
	}
	var star = $('#amount2').val().split(' ~ ');
	sendData.minStar = star[0];
	sendData.maxStar = star[1];

	var priceRange = $('#amount').val().replace(/₩/g, "").split(' ~ ');
	sendData.minPrice = priceRange[0];
	sendData.maxPrice = priceRange[1];

	$.ajax({
		type: "POST",
		url : "movePage.do",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			setHotelList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});

}

function setHotelList(data) {
	
	// 호텔 리스트 표시
	$('#div-hotelList').empty();
	var divHotelList = document.getElementById('div-hotelList');
	for(let hotel in data) {
		if(hotel == 'count' || hotel == 'pageBlock' || hotel == 'pageSize' || hotel == 'pageNum' )
			break;
		var divChild = document.createElement("div");
		
		divChild.setAttribute("class","col-md-8");
		divChild.setAttribute("style","margin-top: 5%; margin-bottom: 5%;");
		divChild.setAttribute("id","divChild");
		
		var divChild2 =  document.createElement("div");
		divChild2.setAttribute("class","d-md-flex");
		
		var divImage = document.createElement("div");
		var hotelImage = document.createElement("img");
		hotelImage.setAttribute("src",data[hotel].imageLink);
		hotelImage.setAttribute("style","height: 100%; width: 100%;");
		divImage.appendChild(hotelImage);
		
		
		var divContent = document.createElement("div");
		
		divContent.setAttribute("class","col-md-6 hotelInfo1");
		divContent.setAttribute("style","margin-left: 3%;");
		
		var divContentH2 = document.createElement('h2');
		divContentH2.setAttribute("class","heading");
		var divContentA1 = document.createElement('a');
		divContentA1.setAttribute("href","#");
		divContentA1.append(data[hotel].hotelName);
		divContentH2.appendChild(divContentA1);
		divContent.appendChild(divContentH2);
		
		var divContentP1 = document.createElement("p");
		divContentP1.append(data[hotel].hotelTel);
		var divContentP2 = document.createElement("p");
		divContentP2.append(data[hotel].hotelAddress);
		divContent.appendChild(divContentP1);
		divContent.appendChild(divContentP2);
		
		if(data[hotel].hotelFacility.facilityParking == '1') {
			var facility = document.createElement("img");
			facility.setAttribute("src","resources/client/images/parking.png")
			divContent.appendChild(facility);
		}
		if(data[hotel].hotelFacility.facilityPool == '1') {
			var facility = document.createElement("img");
			facility.setAttribute("src","resources/client/images/pool.png")
			divContent.appendChild(facility);
		}
		if(data[hotel].hotelFacility.facilityBreakfast == '1') {
			var facility = document.createElement("img");
			facility.setAttribute("src","resources/client/images/breakfast.png")
			divContent.appendChild(facility);
		}
		if(data[hotel].hotelFacility.facilityFitness == '1') {
			var facility = document.createElement("img");
			facility.setAttribute("src","resources/client/images/fitness.png")
			divContent.appendChild(facility);
		}
		if(data[hotel].hotelFacility.facilityWifi == '1') {
			var facility = document.createElement("img");
			facility.setAttribute("src","resources/client/images/wifi.png")
			divContent.appendChild(facility);
		}
		if(data[hotel].hotelFacility.facilityPartyRoom == '1') {
			var facility = document.createElement("img");
			facility.setAttribute("src","resources/client/images/party.png")
			divContent.appendChild(facility);
		}
		
		var divContent2 = document.createElement("div");
		divContent2.setAttribute("class","col-md-4 hotelInfo2");
		divContent2.setAttribute("style","margin-left: 3%;");
		
		var divContent2P1 = document.createElement("p");
		divContent2P1.append("평점 : " + data[hotel].hotelStar);
		var divContent2P2 = document.createElement("p");
		divContent2P2.append("가격 : " + data[hotel].lowestPrice);
		divContent2.appendChild(divContent2P1);
		divContent2.appendChild(divContent2P2);
		
		divChild2.appendChild(divImage);
		divChild2.appendChild(divContent);
		divChild2.appendChild(divContent2);
		divChild.appendChild(divChild2);
		divHotelList.appendChild(divChild);
	}
	
	// 페이징 처리
	$('#paging').empty();
	var divPaging = document.getElementById('paging');
	
	if(data['count'] > 0) {
		var imsi = data['count'] % data['pageSize'] == 0 ? 0 : 1;
		var pageCount = data['count'] / data['pageSize'] + imsi;
		var result = (data['pageNum'] - 1) / data['pageBlock'];
		var startPage = result * data['pageBlock'] + 1;
		var endPage = startPage + data['pageBlock'] - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		if(startPage > data['pageBlock']) {
			var aTag = document.createElement("a");
			aTag.setAttribute("href","javascript:movePage(" + (startPage - data['pageBlock']) + ");");
			aTag.append("[이전]");
			divPaging.appendChild(aTag);
		}
		for(var i = startPage; i <= endPage; i++) {
			var aTag = document.createElement("a");
			aTag.setAttribute("href","javascript:movePage(" + i + ");");
			aTag.append("[" + i + "]");
			divPaging.appendChild(aTag);
		}
		if(endPage < pageCount) {
			var aTag = document.createElement("a");
			aTag.setAttribute("href","javascript:movePage(" + (startPage + data['pageBlock']) + ");");
			aTag.append("[다음]");
			divPaging.appendChild(aTag);
		}
	}
	
	
}



function oneCheckbox(a){

	var concepts = document.getElementsByName("f-accid");

	for(var i=0; i<concepts.length; i++){

		if(concepts[i] != a){

			concepts[i].checked = false;

		}

	}

}

function clearFilter() {

	var concepts = document.getElementsByName("f-accid");
	var facilitys = document.getElementsByName("facility");

	for(var i=0; i<concepts.length; i++){
		concepts[i].checked = false;
	}

	for(var i=0; i<facilitys.length; i++){
		facilitys[i].checked = false;
	}



}
