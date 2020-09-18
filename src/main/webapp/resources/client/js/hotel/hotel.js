window.onload = function () {
	loadingHotelList();
}

function setConceptFilter(concept) {
	if(concept == "도심 속 힐링") {
		document.getElementById("f-accid-999999").checked = true;
	}
	else if(concept == "바다 낭만") {
		document.getElementById("f-accid-30").checked = true;
	}
	else if(concept == "글램핑") {
		document.getElementById("f-accid-7").checked = true;
	}
}

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

function loadingHotelList() {
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
		sendData.wifi = $('#wifi').val();
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
		url : "searchHotelList.do",
		dataType : 'json',
		contentType : 'application/json;  charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			switchScreen()
			setHotelList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});

}

function searchHotel() {

	if(checkSearchDate()) {
		switchScreen();
		var sendData  = {
				searchKeyword : $('#searchKeyword').val(), 
				checkInDate : $('#checkInDate').val(), 
				checkOutDate : $('#checkOutDate').val(), 
				people : $('#people').val(), 
				area : $('#area').val(),
				pageNum : "1"
		};

		$.ajax({
			type: "POST",
			url : "searhHotelToBar.do",
			dataType : 'json',
			contentType : 'application/json;  charset=utf-8;',
			data: JSON.stringify(sendData),
			success : function(data) {
				switchScreen();
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
	switchScreen();
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
		sendData.wifi = $('#wifi').val();
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
		url : "searchHotelList.do",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			switchScreen();
			setHotelList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});

}

function movePage(pageNum) {
	switchScreen();
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
		sendData.wifi = $('#wifi').val();
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
			switchScreen();
			setHotelList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});

}

function setHotelList(data) {

	// 리스트 초기화
	$('#div-hotelList').empty();
	$('#paging').empty();

	// 호텔 리스트 표시
	var divHotelList = document.getElementById('div-hotelList');

	// 조회 목록이 없는 경우
	if(data['count'] == '0' || data['count'] == 0) {
		var divChild = document.createElement("div");

		divChild.setAttribute("class","col-md-8");
		divChild.setAttribute("style","margin-top: 5%; margin-bottom: 5%;");
		divChild.setAttribute("align","center");
		divChild.setAttribute("id","divChild");
		divChild.append("조회 하신 조건의 호텔이 없습니다.");

		divHotelList.appendChild(divChild);
		return;
	}
	for(var i = 1; i <= data['count']; i++ ) {
		var varKey = 'hotel' + i ;
		var geoCodeKey = 'geoCode' + i;
		if(data[varKey] == null) break;

		var divChild = document.createElement("div");
		divChild.setAttribute("align","left");
		divChild.setAttribute("class","col-md-8");
		divChild.setAttribute("style","height: 100%; width: 100%; ");
		divChild.setAttribute("style","margin-top: 5%; margin-bottom: 5%; min-width: 70%;");
		divChild.setAttribute("id","divChild");

		var divChild2 =  document.createElement("div");
		divChild2.setAttribute("style","height: 100%; width: 100%;");
		divChild2.setAttribute("class","d-lg-flex");

		var divImage = document.createElement("div");
		var hotelImage = document.createElement("img");
		hotelImage.setAttribute("src",data[varKey].imageLink);
		hotelImage.setAttribute("style","height: 400px; width: 400px; marign-top: 5%; marign-bottom: 5%;");
		divImage.appendChild(hotelImage);


		var divContent = document.createElement("div");

		divContent.setAttribute("class","col-md-6 hotelInfo1");
		divContent.setAttribute("style","margin-left: 3%; min-width: 100%;");

		var divContentH2 = document.createElement('h2');
		divContentH2.setAttribute("class","heading");
		var divContentA1 = document.createElement('a');
		divContentA1.setAttribute("href","#");
		divContentA1.append(data[varKey].hotelName);
		divContentH2.appendChild(divContentA1);
		divContent.appendChild(divContentH2);

		var divContentP1 = document.createElement("p");
		divContentP1.append(data[varKey].hotelTel);
		var divContentP2 = document.createElement("p");
		divContentP2.append(data[varKey].hotelAddress);

		var btn_mapModal = document.createElement("button");
		btn_mapModal.setAttribute("id","btn-modal");
		btn_mapModal.setAttribute("onclick","showMapModal('" + data[geoCodeKey] +"','"+ data[varKey].hotelName+"');");
		btn_mapModal.append("약도 보기");

		divContent.appendChild(divContentP1);
		divContent.appendChild(divContentP2);
		divContent.appendChild(btn_mapModal);

		var facilityUL = document.createElement("ul");
		facilityUL.setAttribute("class","d-flex flex-row flex-wrap");
		facilityUL.setAttribute("style","min-width: 90%; vertical-align:text-bottom");

		var facilityLI = document.createElement("li");;
		facilityLI.setAttribute("class", "d-flex flex-row align-items-center");
		if(data[varKey].hotelFacility.facilityParking == '1') {
			var facilityIMG = document.createElement("img");
			facilityIMG.setAttribute("style", "max-width: 40%; max-height: 40%;");
			facilityIMG.setAttribute("src", "resources/client/images/parking.png");
			facilityLI.appendChild(facilityIMG);
			facilityLI.append("주차장");
			facilityUL.appendChild(facilityLI);
		}
		if(data[varKey].hotelFacility.facilityPool == '1') {
			var facilityIMG = document.createElement("img");
			facilityIMG.setAttribute("style", "max-width: 40%; max-height: 40%;");
			facilityIMG.setAttribute("src","resources/client/images/pool.png");
			facilityLI.appendChild(facilityIMG);
			facilityLI.append("수영장");
			facilityUL.appendChild(facilityLI);
		}
		if(data[varKey].hotelFacility.facilityBreakfast == '1') {
			var facilityIMG = document.createElement("img");
			facilityIMG.setAttribute("style", "max-width: 40%; max-height: 40%;");
			facilityIMG.setAttribute("src","resources/client/images/breakfast.png");
			facilityLI.appendChild(facilityIMG);
			facilityLI.append("조식");
			facilityUL.appendChild(facilityLI);
		}
		if(data[varKey].hotelFacility.facilityFitness == '1') {
			var facilityIMG = document.createElement("img");
			facilityIMG.setAttribute("style", "max-width: 40%; max-height: 40%;");
			facilityIMG.setAttribute("src","resources/client/images/fitness.png");
			facilityLI.appendChild(facilityIMG);
			facilityLI.append("헬스장");
			facilityUL.appendChild(facilityLI);
		}
		if(data[varKey].hotelFacility.facilityWifi == '1') {
			var facilityIMG = document.createElement("img");
			facilityIMG.setAttribute("style", "max-width: 40%; max-height: 40%;");
			facilityIMG.setAttribute("src","resources/client/images/wifi.png");
			facilityLI.appendChild(facilityIMG);
			facilityLI.append("WIFI");
			facilityUL.appendChild(facilityLI);
		}
		if(data[varKey].hotelFacility.facilityPartyRoom == '1') {
			var facilityIMG = document.createElement("img");
			facilityIMG.setAttribute("style", "max-width: 40%; max-height: 40%;");
			facilityIMG.setAttribute("src","resources/client/images/party.png");
			facilityLI.appendChild(facilityIMG);
			facilityLI.append("파티룸");
			facilityUL.appendChild(facilityLI);
		}
		divContent.appendChild(facilityUL);

		var divContent2 = document.createElement("div");
		divContent2.setAttribute("class","col-md-4 hotelInfo2");
		divContent2.setAttribute("style","margin-left: 3%;");

		var divContent2P1 = document.createElement("p");
		divContent2P1.append("평점 : " + data[varKey].hotelStar);
		var divContent2P2 = document.createElement("p");
		divContent2P2.append("가격 : " + data[varKey].lowestPrice);
		var divContent2Button = document.createElement("button");
		divContent2Button.setAttribute("align","center");
		divContent2Button.setAttribute("style","background: #fd7792; color: #fff; min-width: 100%;");
		divContent2Button.setAttribute("onclick","showHotelRoom('" +  data[varKey].hotelId + "','" + data['reservationInDate'] + "','" + data['reservationOutDate']  + "');");
		divContent2Button.append("선택");
		divContent2.appendChild(divContent2P1);
		divContent2.appendChild(divContent2P2);
		divContent2.appendChild(divContent2Button);

		divChild2.appendChild(divImage);
		divChild2.appendChild(divContent);
		divChild2.appendChild(divContent2);
		divChild.appendChild(divChild2);
		divHotelList.appendChild(divChild);
	}

	// 페이징 처리
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


//로딩중 이미지 스위치
function switchScreen() {
	if(document.getElementById("divLoading").style.display =="none")
		document.getElementById("divLoading").style.display = 'block';
	else
		document.getElementById("divLoading").style.display = 'none';
}

function showHotelRoom(hotelId,reservationInDate,reservationOutDate) {
	alert(reservationOutDate);
	window.location.href= "searchRoom.do?hotelId=" + hotelId + "&reservationInDate=" + reservationInDate + "&reservationOutDate=" + reservationOutDate;
}

//오시는길 modal 출력
function showMapModal(jsonString,hotelName) {
	$("#modal-body").empty();
	$("#mapModal").modal();//모달 창 열기
	//모달 컨텐츠(지도)
	var jsonString = JSON.parse(jsonString);
	var address=jsonString.documents[0].address.address_name;
	var road_address=jsonString.documents[0].road_address.address_name;
	var addX=jsonString.documents[0].address.x;
	var addY=jsonString.documents[0].address.y;
	
	
	
	
	$(document).ready(function(){


		
		//모달 헤더 (호텔 이름)
		var HotelName=hotelName;
		$(".modal-header").empty();
		$(".modal-header").append("찾아오시는 길");
		$(".modal-header").append("<b>"+hotelName+"</b>");
		
		
		
	

		var mapContainer = document.getElementById('modal-body'); // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(addY, addX), // 지도의 중심좌표
			level : 3
			// 지도의 확대 레벨
		};

//		지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);

		var marker = new kakao.maps.Marker({
			// 지도 중심좌표에 마커를 생성합니다 
			position : map.getCenter()
		});
		// 지도에 마커를 표시합니다
		marker.setMap(map);
		
		// 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다
		map.relayout();

		// 지도의 너비가 변경될 때 지도중심을 입력받은 위치(position)로 설정합니다
		map.setCenter(marker.getPosition());
		
		
		
		//모달 푸터(주소)
		$(".modal-footer").empty();
		$(".modal-footer").append("지번 주소 : "+ address);
		$(".modal-footer").append("<br>"+"도로명 주소 : "+ road_address);
		$(".modal-footer").append('<b><a href=\"https:\/\/map.kakao.com\/link\/to\/'+HotelName+','+addY+','+addX+'\"'+'>오는 경로 찾기</a></b>');
		

		

	});


}




//--------------------------------------------------------- 필터 보이기,숨기기 --------------------------------------------------------- 
//필터(시설)
$(function() {
	$("#filter1-switch").click(function() {
		if(document.getElementById("filter-popular-contents").style.display =="none") {
			document.getElementById("filter-popular-contents").style.display = 'block';
			document.getElementById("img-filter1").setAttribute("src","resources/client/images/arrow-under.png");
		}
		else {
			document.getElementById("filter-popular-contents").style.display = 'none';
			document.getElementById("img-filter1").setAttribute("src","resources/client/images/arrow-upper.png");
		}

	})
})

//1박 비용
$(function() {
	$("#filter2-switch").click(function() {
		if(document.getElementById("filter-price-contents").style.display =="none") {
			document.getElementById("filter-price-contents").style.display = 'block';
			document.getElementById("img-filter2").setAttribute("src","resources/client/images/arrow-under.png");
		}
		else {
			document.getElementById("filter-price-contents").style.display = 'none';
			document.getElementById("img-filter2").setAttribute("src","resources/client/images/arrow-upper.png");
		}

	})
})

//별점
$(function() {
	$("#filter3-switch").click(function() {
		if(document.getElementById("filter-star-contents").style.display =="none") {
			document.getElementById("filter-star-contents").style.display = 'block';
			document.getElementById("img-filter3").setAttribute("src","resources/client/images/arrow-under.png");
		}
		else {
			document.getElementById("filter-star-contents").style.display = 'none';
			document.getElementById("img-filter3").setAttribute("src","resources/client/images/arrow-upper.png");
		}

	})
})

//테마
$(function() {
	$("#filter4-switch").click(function() {
		if(document.getElementById("filter-accommodation-type-contents").style.display =="none") {
			document.getElementById("filter-accommodation-type-contents").style.display = 'block';
			document.getElementById("img-filter4").setAttribute("src","resources/client/images/arrow-under.png");
		}
		else {
			document.getElementById("filter-accommodation-type-contents").style.display = 'none';
			document.getElementById("img-filter4").setAttribute("src","resources/client/images/arrow-upper.png");
		}

	})
})
//---------------------------------------------------------------------------------------------------------------------------------

