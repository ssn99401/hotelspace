var user_function = null;

var modalHotelInfo = null;
var modalMainImagesArray = new Array();
var modalNormalImagesArray = new Array();
var modalRoomList = new Array();

//--------------------------------- modal ---------------------------------------//
//------------------------------------- 모달에 사용할 정보 Setter -----------------------------------
function setModalMainImage(mainImageArray) {
	modalMainImagesArray = mainImageArray;
}

//모달에 사용할 업체 정보 저장
function setModalNormalImages(normalImageArray) {
	modalNormalImagesArray = normalImageArray
}

//모달에 사용할 업체 정보 저장
function setModalHotelInfo(hotelInfo) {
	modalHotelInfo = hotelInfo;
}

//모달에 사용할 방 목록 정보 저장
function setModalRoomInfos(roomList) {
	modalRoomList[index] = roomList;
}
//---------------------------------------------------------------------------------------------------

//이미지 수정 모달 출력
function showEditImageModal(targetId, index) {
	var modal_title = document.getElementById('myModalLabel');
	var modal_body = document.getElementById('modal-body');

	var html_title = "";
	var html_body = "";

	if(index == '0') { // 호텔 이미지 
		html_title = modalHotelInfo.hotelName + " 이미지 목록";
	} else { // 방 이미지 수정
		html_title = modalRoomList[index].roomName + " 이미지 목록";
	}
	modal_title.innerHTML = html_title;
	modal_body.innerHTML = html_body;
}
//이미지 추가 모달 출력
function showAddImageModal(targetId, index) {

	if(index == '0') { // 호텔 이미지 추가
		html_title = modalHotelInfo.hotelName + " 이미지 등록";
	} else { // 방 이미지 추가
		html_title = modalRoomList[index].roomName + " 이미지 등록";
	}
}


//--------------------------------- Ajax ---------------------------------------//
//호텔 이미지 추가 요청
function requestAddHotelImage() {

}

//호텔 이미지 변경 요청
function requestUpdateHotelImage() {

}

//호텔 이미지 삭제 요청
function requestDeleteHotelImage() {

}

//방 이미지 추가 요청
function requestAddRoomImage() {

}

//방 이미지 변경 요청
function requestUpdateRoomImage() {

}

//방 이미지 삭제 요청
function requestDeleteRoomImage() {

}