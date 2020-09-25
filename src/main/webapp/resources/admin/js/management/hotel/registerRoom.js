var hotelId = null;

/*----------------------------------------------------- 이미지 등록 ------------------------------------------------------*/
var saveFileElement = null;
var uploadFileListDiv = null;
window.onload = function () {
	hotelId = document.getElementById('hidden-hotelId').value;
	uploadFileListDiv = document.getElementById('div-fileUpload-normal').cloneNode(true);
}

//사진 업로드 추가 버튼 클릭 이벤트
$(document).on("click","#btn-plus",function(event){
	plusFileDiv();
	return false;
})

//사진 업로드 삭제 버튼 클릭 이벤트
$(document).on("click","#btn-delete",function(event){
	deleteFileDiv(this);
	return false;
})

//업로드 사진 확장자 확인
$(document).on("change","#select_file-main, #select_file-normal",function(event){
	var flag = checkFileExtension(this);
	if(!flag) {
		alert(".png .jpg .gif 확장자만 등록할 수 있습니다.");
		this.replaceWith(saveFileElement);
	}
})

function saveElement(e) {

	saveFileElement = e.parentElement.firstElementChild.cloneNode(true);
}


function plusFileDiv() {
	var div_filebox = document.createElement('div');
	div_filebox.setAttribute("class","filebox");
	div_filebox.setAttribute("style","margin-left: 2%; margin-bottom: 1%;");

	var input_file = document.createElement('input');
	input_file.setAttribute("type","file");
	input_file.setAttribute("id","select_file-normal");
	input_file.setAttribute("name","select_file-normal");
	input_file.setAttribute("class","upload-hidden");
	input_file.setAttribute("accept",".png, .jpg, .gif");
	input_file.setAttribute("style","display: inline;");
	input_file.setAttribute("multiple","multiple");
	input_file.setAttribute("onclick","saveElement(this)");

	var span_file = document.createElement('span');
	span_file.setAttribute("style","margin-left: 60%;");

	var btn_plus = document.createElement('button');
	btn_plus.setAttribute("id","btn-plus");
	var btn_plus_img = document.createElement('img');
	btn_plus_img.setAttribute("src","resources/admin/images/plus.png");

	var span_file2 = document.createElement('span');
	span_file2.setAttribute("style","float: right;");
	var btn_delete = document.createElement('button');
	btn_delete.setAttribute("id","btn-delete");
	var btn_delete_img = document.createElement('img');
	btn_delete_img.setAttribute("src","resources/admin/images/cancle.png");

	btn_plus.appendChild(btn_plus_img);
	btn_delete.appendChild(btn_delete_img);

	span_file.appendChild(btn_plus);
	span_file2.appendChild(btn_delete);

	div_filebox.appendChild(input_file);
	div_filebox.appendChild(span_file);
	div_filebox.appendChild(span_file2);

	document.getElementById('div-fileUpload-normal').appendChild(div_filebox);
}

//사진 업로드 div 삭제
function deleteFileDiv(btn) {
	var btn_div = btn.parentElement.parentNode;
	btn.parentElement.parentNode.parentNode.removeChild(btn_div);
}

//확장자 검사 (.png .jpg .gif)
function checkFileExtension(tag_input) {
	var files = tag_input.parentElement.firstElementChild.files;
	var fileExtension = null;
	var file;
	for (var i = 0; i < files.length; i++) {
		file = files[i];
		fileExtension = file.name.slice(file.name.indexOf(".") + 1).toLowerCase();
		// 확장자 확인
		if(fileExtension != "jpg" && fileExtension != "gif" && fileExtension != "png") 
			return false;
	}
	return true;
}

//업로드 파일 목록 초기화
$(function() {
	$("#btn-reset").click(function() {
		document.getElementById('div-fileUpload-normal').replaceWith(uploadFileListDiv);
		uploadFileListDiv = document.getElementById('div-fileUpload-normal').cloneNode(true);
	})
})

//방 등록 요청
function requestRegisterRoom() {
	// 입력 유효성 검사
	if(!checkInputData()) return;

	// 파일 업로드
	var mainFilesInputTag = document.getElementsByName('select_file-main');
	var normalFilesInputTags = document.getElementsByName('select_file-normal');
	var form = new FormData();
	var index = 1;
	if(mainFilesInputTag == null) {
		return;
	}
	form.append(hotelId, mainFilesInputTag[0].files[0]);

	for(var i = 0; i < normalFilesInputTags.length; i++) {
		var files = normalFilesInputTags[i].files;
		if(files == null) {
			alert("파일을 선택해 주세요.");
			return;
		}
		for(var j = 0; j < files.length; j++) {
			form.append("file" + index++ , files[j]);
		}
	}

	ImageUploadRequest(form);

}

//서버로 사진 업로드 요청 Ajax
function ImageUploadRequest(sendData) {
	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url : "uploadRoomImage.mdo",
		contentType : false,
		processData : false,
		data : sendData,
		success : function(data) {
			roomUploadRequest(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//방 등록 요청 Ajax
function roomUploadRequest(data) {
	var idarray = data.split(',');
	var hotelId = idarray[1];
	var roomId = idarray[0];
	var roomName = $('#room-name').val();
	var roomPrice = $('#room-price').val();
	var roomAmount = $('#room-amount').val();
	var roomStandardPeople = $('#room-standardPeople').val();
	var roomMaxPeople = $('#room-maxPeople').val();
	var roomPricePeople = $('#room-price-people').val();
	var roomService = $('#room-service').val();
	var roomInfo = $('#room-info').val();

	var sendData = {
		hotelId : hotelId,
		roomId : roomId,
		roomName : roomName,
		roomPrice : roomPrice,
		roomAmount : roomAmount,
		roomStandardPeople : roomStandardPeople,
		roomMaxPeople : roomMaxPeople,
		roomPricePeople : roomPricePeople,
		roomPricePeople : roomPricePeople,
		roomService : roomService,
		roomInfo : roomInfo
	};
	$.ajax({
		type: "POST",
		url : "uploadRoom.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			alert("등록 되었습니다.");
			opener.parent.location.reload();
			windowClose();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}


//입력 유효성 검사
function checkInputData() {
	var mainFilesInputTag = document.getElementsByName('select_file-main');
	var roomName = $('#room-name').val();
	var roomPrice = $('#room-price').val();
	var roomAmount = $('#room-amount').val();
	var roomStandardPeople = $('#room-standardPeople').val();
	var roomMaxPeople = $('#room-maxPeople').val();
	var roomPricePeople = $('#room-price-people').val();
	var roomService = $('#room-service').val();
	var roomInfo = $('#room-info').val();

	if(mainFilesInputTag.length == 0) {
		alert('메인 이미지를 지정해 주세요');
		return false;
	}
	if(roomName == '' || roomName == null) {
		alert('방 이름을 입력해 주세요');
		return false;
	}
	if(roomPrice == '' || roomPrice == null) {
		alert('1박 요금을 입력해 주세요');
		return false;
	}
	if(roomAmount == '' || roomAmount == null) {
		alert('방 갯수를 입력해 주세요');
		return false;
	}
	if(roomStandardPeople == '' || roomStandardPeople == null) {
		alert('적정 인원을 입력해 주세요');
		return false;
	}
	if(roomMaxPeople == '' || roomMaxPeople == null) {
		alert('최대 인원을 입력해 주세요');
		return false;
	}
	if(roomPricePeople == '' || roomPricePeople == null) {
		alert('인당 추가 요금을 입력해 주세요');
		return false;
	}
	if(roomService == '' || roomService == null) {
		alert('서비스를 입력해 주세요');
		return false;
	}
	if(roomInfo == '' || roomInfo == null) {
		alert('방 정보를 입력해 주세요');
		return false;
	}
	return true;
}
function resetInput() {
	$('#room-name').val('');
	$('#room-price').val('');
	$('#room-amount').val('');
	$('#room-standardPeople').val('');
	$('#room-maxPeople').val('');
	$('#room-price-people').val('');
	$('#room-service').val('');
	$('#room-info').val('');
}

function windowClose() {
	self.close();
}