/*----------------------------------------------------- 이미지 등록 ------------------------------------------------------*/
var saveFileElement = null;
var uploadFileListDiv = null;
window.onload = function () {
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

// 호텔 등록 요청
function requestRegisterHotel() {
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
	form.append("file" + 0 , mainFilesInputTag[0].files[0]);
	
	for(var i = 0; i < normalFilesInputTags.length; i++) {
		var files = normalFilesInputTags[i].files;
		if(files == null) {
			alert("파을을 선택해 주세요.");
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
		url : "uploadHotelImage.mdo",
		contentType : false,
		processData : false,
		data : sendData,
		success : function(data) {
			hotelUploadRequest(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

// 호텔 등록 요청 Ajax
function hotelUploadRequest(hotelId) {
	// 호텔 정보 등록
	var hotelName = $('#hotel-name').val();
	var hotelClientId = $('#hotel-clientId').val();
	var hotelTel = $('#hotel-tel').val();
	var hotelArea = $('#hotel-area').val();
	var hotelAddress = $('#hotel-address').val();
	var hotelConcept = $('#hotel-concept').val();
	
	var facility_parking = null;
	var facility_pool = null;
	var facility_breakfast = null;
	var facility_fitness = null;
	var facility_wifi = null;
	var facility_partyRoom = null;
	
	if(document.getElementById('facility-parking').checked == true) {
		facility_parking = '1';
	} else {
		facility_parking = '0';
	}
	if(document.getElementById('facility-pool').checked == true) {
		facility_pool = '1';
	} else {
		facility_pool = '0';
	}
	if(document.getElementById('facility-breakfast').checked == true) {
		facility_breakfast = '1';
	} else {
		facility_breakfast = '0';
	}
	if(document.getElementById('facility-fitness').checked == true) {
		facility_fitness = '1';
	} else {
		facility_fitness = '0';
	}
	if(document.getElementById('facility-wifi').checked == true) {
		facility_wifi = '1';
	} else {
		facility_wifi = '0';
	}
	if(document.getElementById('facility-partyRoom').checked == true) {
		facility_partyRoom = '1';
	} else {
		facility_partyRoom = '0';
	}

	var sendData = {
		hotelId : hotelId,
		hotelName : hotelName,
		hotelClientId : hotelClientId,
		hotelTel : hotelTel,
		hotelArea : hotelArea,
		hotelAddress : hotelAddress,
		hotelConcept : hotelConcept,
		facility_parking : facility_parking,
		facility_pool : facility_pool,
		facility_breakfast : facility_breakfast,
		facility_fitness : facility_fitness,
		facility_wifi : facility_wifi,
		facility_partyRoom : facility_partyRoom
	};
	$.ajax({
		type: "POST",
		url : "uploadHotel.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			alert("호텔이 등록되었습니다.");
			windowClose();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}


// 입력 유효성 검사
function checkInputData() {
	var mainFilesInputTag = document.getElementsByName('select_file-main');
	var hotelName = $('#hotel-name').val();
	var hotelClientId = $('#hotel-clientId').val();
	var hotelTel = $('#hotel-tel').val();
	var hotelArea = $('#hotel-area').val();
	var hotelAddress = $('#hotel-address').val();
	var hotelConcept = $('#hotel-concept').val();
	
	if(mainFilesInputTag.length == 0) {
		alert('메인 이미지를 지정해 주세요');
		return false;
	}
	if(hotelName == '' || hotelName == null) {
		alert('호텔명을 입력해 주세요');
		return false;
	}
	if(hotelClientId == '' || hotelClientId == null) {
		alert('등록자 ID를 입력해 주세요');
		return false;
	}
	if(hotelTel == '' || hotelTel == null) {
		alert('전화번호를 입력해 주세요');
		return false;
	}
	if(hotelArea == '' || hotelArea == null) {
		alert('지역을 입력해 주세요');
		return false;
	}
	if(hotelAddress == '' || hotelAddress == null) {
		alert('주소를 입력해 주세요');
		return false;
	}
	if(hotelConcept == '' || hotelConcept == null) {
		alert('테마를 입력해 주세요');
		return false;
	}
	return true;
}

function resetInput() {
	$('#hotel-name').val('');
	$('#hotel-clientId').val('');
	$('#hotel-tel').val('');
	$('#hotel-area').val('');
	$('#hotel-address').val('');
	$('#hotel-concept').val('');
	var facilities = document.getElementsByName('facilities');
	for(var i=0; i<facilities.length; i++){
		facilities[i].checked = false;
	}
}

function windowClose() {
	self.close();
}