$(document).ready(function(){
	var hotelId = document.getElementById('hidden-hotelId').value;
	requestHotelInfo(hotelId);
});

// 호텔 관련 정보 서버 요청
function requestHotelInfo(hotelId) {
	var sendData = {
			hotelId: hotelId
	};

	$.ajax({
		type: "POST",
		url : "hotelInfo.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			setHotelInfo(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

// 호텔 정보 업데이트 요청
function requestUpdateHotelInfo(hotelId, target, newValue) {
	var sendData = {
			hotelId: hotelId,
			target: target,
			newValue: newValue
	};

	$.ajax({
		type: "POST",
		url : "updateHotelInfo.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			requestHotelInfo(hotelId);
			alert('정보가 변경 되었습니다');
			opener.parent.reloadTable();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

// 방 정보 업데이트 요청
function requestUpdateRoomInfo(roomId, target, newValue) {
	var hotelId = document.getElementById('hidden-hotelId').value;
	var sendData = {
			roomId: roomId,
			target: target,
			newValue: newValue
	};

	$.ajax({
		type: "POST",
		url : "updateRoomInfo.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			requestHotelInfo(hotelId);
			alert('정보가 변경 되었습니다');
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//호텔 정보  표시
function setHotelInfo(data) {
	var hotelInfo = data['hotelInfo'];
	var hotelMainPicture = null;
	var hotelNormalPictures = new Array();
	var html = "";

	// 이미지 분류
	for(var i = 0; i < data['hotelPictures'].length; i++) {
		if(data['hotelPictures'][i].imageType == 'MAIN')
			hotelMainPicture = data['hotelPictures'][i];
		else
			hotelNormalPictures.push(data['hotelPictures'][i]);
	}

	// 호텔 정보 표시
	html += '<div class="image" style="padding:0;">';
	html += setImageSlide(0, hotelMainPicture, hotelNormalPictures);
	html += '</div>';
	html+='<div class="text">';
	html+='<h2 class="heading">'+ hotelInfo.hotelName +'</h2>';
	html+='<button onClick="showUpdateHotelInfoPrompt(' + "'" + document.getElementById('hidden-hotelId').value + "'"+  ', ' + "'호텔명'" + ' , ' + "'str'" + ');">변경</button>';
	html+='<ul class="specs mb-5">';
	html+='<li><strong>호텔아이디 : </strong>' + hotelInfo.hotelId + '</li>';
	html+='<li><strong>호텔주 : </strong>' + hotelInfo.userId + '</li>';
	html+='<li><strong>TEL : </strong>' + hotelInfo.hotelTel +'&nbsp;&nbsp;';
	html+='<button onClick="showUpdateHotelInfoPrompt(' + "'" + document.getElementById('hidden-hotelId').value + "'"+  ', ' + "'전화번호'" + ' , ' + "'str'" + ');">변경</button></li>';
	html+='<li><strong>지역 : </strong>' + hotelInfo.hotelArea +'&nbsp;&nbsp;';
	html+='<button onClick="showUpdateHotelInfoPrompt(' + "'" + document.getElementById('hidden-hotelId').value + "'"+  ', ' + "'지역'" + ' , ' + "'str'" + ');">변경</button></li>';
	html+='<li><strong>주소 : </strong>' + hotelInfo.hotelAddress +'&nbsp;&nbsp;';
	html+='<button onClick="showUpdateHotelInfoPrompt(' + "'" + document.getElementById('hidden-hotelId').value + "'"+  ', ' + "'주소'" + ' , ' + "'str'" + ');">변경</button></li>';
	html+='<li><strong>테마 : </strong>' + hotelInfo.hotelConcept +'&nbsp;&nbsp;';
	html+='<button onClick="showUpdateHotelInfoPrompt(' + "'" + document.getElementById('hidden-hotelId').value + "'"+  ', ' + "'테마'" + ' , ' + "'str'" + ');">변경</button></li>';
	html+='<li><strong>평점  : </strong>' + hotelInfo.hotelStar + '</li>';
	html+='<li><strong>등록일  : </strong>' + hotelInfo.hotelRegDate + '</li>';
	html+='</ul>';
	html+='<p><a href="#" class="btn btn-primary py-3 px-5">Read More</a></p>';
	html+='</div>';
	document.getElementById('div-hotelInfo').innerHTML = html;
	setRoomInfo(data['hotelRoomList'], data['roomPictures']);
	setModalHotelInfo(hotelInfo);
	
}

//호텔 방 정보 표시
function setRoomInfo(roomList, roomPictures) {
	var roomMainPictureList = new Array();
	var roomNormalPictureList = new Array();
	
	var html = "";
	
	// 이미지 분류
	for(var i = 0; i < roomPictures.length; i++) {
		if(roomPictures[i].imageType == 'MAIN')
			roomMainPictureList.push(roomPictures[i]);
		else
			roomNormalPictureList.push(roomPictures[i]);
	}

	// 방 정보 표시
	for(var i = 0; i < roomList.length; i++) {
		var roomMainPicture = null;
		var roomNormalPictures = new Array();
		for(var j = 0; j < roomMainPictureList.length; j++) {
			if(roomMainPictureList[j].roomId == roomList[i].roomId)
				roomMainPicture = roomMainPictureList[j];
		}
		for(var j = 0; j < roomNormalPictureList.length; j++) {
			if(roomNormalPictureList[j].roomId == roomList[i].roomId)
				roomNormalPictures.push(roomNormalPictureList[j]);
		}



		
		html += '<div class="col-md-12 mb-5">';
		html += '<div class="block-3 d-md-flex">';
		if(i % 2 == 0) {
			html +='<div class="image" style="padding:0;">';
			html += setImageSlide(i + 1, roomMainPicture, roomNormalPictures);
			html +='</div>';
			html+='<div class="text">';
		} else {
			html +='<div class="image order-2" style="padding:0;">';
			html += setImageSlide(i + 1, roomMainPicture, roomNormalPictures);
			html +='</div>';
			html+='<div class="text order-1">';
		}

		html+='<h2 class="heading">'+ roomList[i].roomName +'</h2>';
		html+='<ul class="specs mb-5">';
		html+='<li><strong>룸 아이디 : </strong>' + roomList[i].roomId + '</li>';
		html+='<li><strong>1박 요금 : </strong>' + roomList[i].roomPrice +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'1박 요금'" + ' , ' + "'num'" + ');">변경</button></li>';
		html+='<li><strong>방 갯수 : </strong>' + roomList[i].roomAmount +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'방 갯수'" + ' , ' + "'num'" + ');">변경</button></li>';
		html+='<li><strong>적정 인원 : </strong>' + roomList[i].roomStandardPeople +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'적정 인원'" + ' , ' + "'num'" + ');">변경</button></li>';
		html+='<li><strong>최대 인원 : </strong>' + roomList[i].roomMaxPeople +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'최대 인원'" + ' , ' + "'num'" + ');">변경</button></li>';
		html+='<li><strong>추가인원 당 금액  : </strong>' + roomList[i].roomPricePeople +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'1인당 추가 금액'" + ' , ' + "'num'" + ');">변경</button></li>';
		html+='<li><strong>부가 서비스 : </strong>' + roomList[i].roomServices +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'부가 서비스'" + ' , ' + "'str'" + ');">변경</button></li>';
		html+='<li><strong>총 예약 횟수 : </strong>' + roomList[i].roomUsage + '</li>';
		html+='<li><strong>방 정보 : </strong>' + roomList[i].roomInfo +'&nbsp;&nbsp;';
		html+='<button onClick="showUpdateRoomInfoPrompt(' + "'" + roomList[i].roomId + "'"+  ', ' + "'방 정보'" + ' , ' + "'str'" + ');">변경</button></li>';
		html+='</ul>';
		html+='<p><a href="#" class="btn btn-primary py-3 px-5">Read More</a></p>';
		html+='</div>';
		html+='</div>';
		html+='</div>';

		document.getElementById('div-roomInfo').innerHTML = html;
		setModalRoomInfos(roomList);
		setModalMainImage(roomMainPictureList);
		setModalNormalImages(roomNormalPictureList);
	}
}

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

	html +='</div>';

	html +='<a class="carousel-control-prev" href="#carouselExampleIndicators' + index + '" role="button" data-slide="prev" style="left: 5%;"> <span class="carousel-control-prev-icon" ></a>';
	html +='<a class="carousel-control-next" href="#carouselExampleIndicators' + index + '" role="button" data-slide="next" style="right: 5%;"> <span class="carousel-control-next-icon" ></a>';
	html +='</div>';
	
	setModalImages(mainPicture, normalPictures ,index - 1);
	
	return html;
}

function showUpdateHotelInfoPrompt(hotelId, target, valueType) {
	var userInput = prompt("변경할 " + target +"값을 입력해 주세요"+"");
	if(userInput != null) {
		if(dataInputCheck(userInput, valueType)) {
			requestUpdateHotelInfo(hotelId, target, userInput);
		} else {
			alert('입력을 확인해 주세요');
		}
	}

}

function showUpdateRoomInfoPrompt(roomId, target, valueType) {
	var userInput = prompt("변경할 " + target +"값을 입력해 주세요"+"");
	if(userInput != null) {
		if(dataInputCheck(userInput, valueType)) {
			requestUpdateRoomInfo(roomId, target, userInput);
		} else {
			alert('입력을 확인해 주세요');
			showUpdateRoomInfoPrompt(roomId, target, valueType);
		}
	}
}

// 업데이트 입력 유효성 검사
function dataInputCheck(userInput, valueType) {
	if(valueType == 'num') {
		if(isNaN(userInput) == false) {
			return true;
		} else {
			return false;
		}
	} else if(valueType == 'str') {
		if(isNaN(userInput) == true) {
			return true;
		} else {
			return false;
		}
	}
}