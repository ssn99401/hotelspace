window.onload = function () {
	loadingImageList();
	uploadFileListDiv = document.getElementById('div-fileUpload').cloneNode(true);
}

function loadingImageList() {
	$.ajax({
		type: "GET",
		url : "pageImageList.mdo",
		contentType : 'charset=utf-8;',
		success : function(data) {
			setImageList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}
//----------------------- 페이지 관리 모달창 띄우기 -----------------------

var selectedImageType = null;
var imageMultiCheck = false;

$(function() {
	$("#_mainhome").click(function() {
		selectedImageType = 'MAINPAGE';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_seoul").click(function() {
		selectedImageType = 'SEOUL';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_busan").click(function() {
		selectedImageType = 'BUSAN';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_jeju").click(function() {
		selectedImageType = 'JEJU';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_sea").click(function() {
		selectedImageType = '바다 낭만';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_healing").click(function() {
		selectedImageType = '도심 속 힐링';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_glamping").click(function() {
		selectedImageType = '글렘핑';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#_login").click(function() {
		selectedImageType = 'LOGIN';
		modalcontentSet(true);
		$("#imageModal").modal();
		return false;
	})
})
$(function() {
	$("#btn-showImage").click(function() {
		modalcontentSet(false);
		$("#imageModal").modal();
	})
})

// 모달 초기화
function modalcontentSet(val) {
	var imageDivs = document.getElementsByName('img-page');
	for(var i = 0; i < imageDivs.length; i++) {
		imageDivs[i].style.opacity = "1";
	}
	if(val) {
		document.getElementById('btn-modal-cancle').style.display = "";
		document.getElementById('btn-modal-updatePageImage').style.display = "";
		document.getElementById('btn-modal-delete').style.display = "none";
		document.getElementById('btn-modal-confirm').style.display = "none";
		imageMultiCheck = false;
	} else {
		document.getElementById('btn-modal-cancle').style.display = "none";
		document.getElementById('btn-modal-updatePageImage').style.display = "none";
		document.getElementById('btn-modal-delete').style.display = "";
		document.getElementById('btn-modal-confirm').style.display = "";
		imageMultiCheck = true;
	}

}

//페이지 이미지 셋팅
function setImageList(data) {
	for(let mapKey in data) {
		if(data[mapKey].imageType == 'MAINPAGE') {
			document.getElementById('img_mainhome').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == 'SEOUL') {
			document.getElementById('img_seoul').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == 'BUSAN') {
			document.getElementById('img_busan').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == 'JEJU') {
			document.getElementById('img_jeju').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == '바다 낭만') {
			document.getElementById('img_sea').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == '도심 속 힐링') {
			document.getElementById('img_healing').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == '글렘핑') {
			document.getElementById('img_glamping').setAttribute("src",data[mapKey].imageLink);
		}
		if(data[mapKey].imageType == 'LOGIN') {
			document.getElementById('img_login').setAttribute("src",data[mapKey].imageLink);
		}
	}
	setModalImage(data);
};

//모달창 이미지 셋팅
function setModalImage(data) {
	$('#modal-body').empty();
	var modal_body = document.getElementById("modal-body");

	var i = 1;
	for(let mapKey in data) {
		if(data[mapKey].imageType != 'MAINPAGE' && data[mapKey].imageType != 'SEOUL' && data[mapKey].imageType != 'BUSAN' && data[mapKey].imageType != 'JEJU' &&
				data[mapKey].imageType != '바다 낭만' && data[mapKey].imageType != '도심 속 힐링' && data[mapKey].imageType != '글렘핑' && data[mapKey].imageType != 'LOGIN') {
			
			var div_modalContentWraper =  document.createElement("div");
			div_modalContentWraper.setAttribute("style", "min-width: 240px; height: 250px; padding: 3%; margin-top: 2%; text-align: center;" );
			div_modalContentWraper.setAttribute("class", "col-md-4 col-lg-3 mb-4 mb-lg-0");
			
			var div_modalContent = document.createElement("div");
			div_modalContent.setAttribute("class", "position: absolute; top:0; left: 0; width: 100%; height: 100%;" );
			div_modalContent.setAttribute("id", "pageImage-" + data[mapKey].imageId);
			var div_modalRowImage = document.createElement("img");
			div_modalRowImage.setAttribute("class", "img-fluid");
			div_modalRowImage.setAttribute("id", "img-" + i );
			div_modalRowImage.setAttribute("name", "img-page");
			div_modalRowImage.setAttribute("style", "position: absolute; top:0; left: 0; width: 90%; height: 220px;" );
			div_modalRowImage.setAttribute("src", data[mapKey].imageLink );
			div_modalRowImage.setAttribute("onClick", "setFocusToImageDiv(this)");
			
			var div_modalContent2 = document.createElement("div");
			div_modalContent2.setAttribute("style", "position: absolute; width: 100%; height: 10%; margin-top: 200px; margin-left: -15%; margin-bottom: 20px;" );
			
			var p_modalImageName = document.createElement("p");
			p_modalImageName.append(data[mapKey].imageLink.slice(data[mapKey].imageLink.lastIndexOf("/")+1).slice(32));
			
			div_modalContent.appendChild(div_modalRowImage);
			div_modalContent2.appendChild(p_modalImageName);
			div_modalContentWraper.appendChild(div_modalContent);
			div_modalContentWraper.appendChild(div_modalContent2);
			modal_body.appendChild(div_modalContentWraper);
//			if(i % 3 == 0) {
//			modal_body.appendChild(div_modalRow);
//			div_modalRow = document.createElement("div");
//			div_modalRow.setAttribute("align", "center" );
//			}
			i++;
		}
	}
};

//---------------------- 사진 변경 -----------------------
//사진 클릭 시 포커스
function setFocusToImageDiv(div) {
	var imageDivs = document.getElementsByName('img-page');
	if(imageMultiCheck) {
		if(div.style.opacity == "0.5")
			div.style.opacity = "1";
		else
			div.style.opacity = "0.5";
	} else {
		for(var i = 0; i < imageDivs.length; i++) {
			imageDivs[i].style.opacity = "1";
		}
		div.style.opacity ="0.5";
	}
}

//사진 변경버튼 클릭 이벤트
$(document).on("click","#btn-modal-updatePageImage",function(event){
	var imageDivs = document.getElementsByName('img-page');
	var selectedImageId = null;
	for(var i = 0; i < imageDivs.length; i++) {
		if(imageDivs[i].style.opacity == "0.5") {
			selectedImageId = imageDivs[i].parentElement.getAttribute("id").split('-')[1];
		}
	}
	if(selectedImageId == null)
		alert('변경할 사진을 선택해 주세요');
	else {
		updatePageImageRequest(selectedImageId);
	}
})

//사진 삭제버튼 클릭 이벤트
$(document).on("click","#btn-modal-delete",function(event){
	var imageDivs = document.getElementsByName('img-page');
	var selectedImageId = null;
	for(var i = 0; i < imageDivs.length; i++) {
		if(imageDivs[i].style.opacity == "0.5") {
			selectedImageId = imageDivs[i].parentElement.getAttribute("id").split('-')[1];
		}
	}
	if(selectedImageId == null)
		alert('삭제할 사진을 선택해 주세요');
	else {
		deletePageImageRequest(selectedImageId);
	}
})


//사진 변경 요청
function updatePageImageRequest(selectedImageId) {
	if (confirm("이미지를 교체하시겠습니까?") != true){    //확인
		return
	}
	var sendData = {
			newImageId : selectedImageId,
			oldImageType : selectedImageType
	};
	$.ajax({
		type: "POST",
		url : "changeImage.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(sendData),
		success : function(data) {
			selectedImageId = null;
			alert("사진이 변경 되었습니다.");
			setImageList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//사진 삭제 요청
function deletePageImageRequest(selectedImageId) {
	if (confirm("정말 삭제하시겠습니까?") != true){    //확인
		return
	}
	
	var imageDivs = document.getElementsByName('img-page');
	var arrJson = new Array();
	
	for(var i = 0; i < imageDivs.length; i++) {
		if(imageDivs[i].style.opacity == "0.5") { // 체크된 이미지일 경우
			var jsonData = {
				imageId : imageDivs[i].parentElement.getAttribute("id").split('-')[1]
			};
			arrJson.push(jsonData);
		}
	}
	$.ajax({
		type: "POST",
		url : "deleteImage.mdo",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(arrJson),
		success : function(data) {
			alert("사진이 삭제 되었습니다.");
			setImageList(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//----------------------- 사진 등록 -----------------------
//사진 업로드 추가 버튼 클릭 이벤트

var saveFileElement = null;
var uploadFileListDiv = null;

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
$(document).on("change","#select_file",function(event){
	var flag = checkFileExtension(this);
	if(!flag) {
		alert(".png .jpg .gif 확장자만 등록할 수 있습니다.");
		this.replaceWith(saveFileElement);
	}
})

function saveElement(e) {
	saveFileElement = e.parentElement.firstElementChild.cloneNode(true);
}

//사진 업로드 div 추가
function plusFileDiv() {
	var div_filebox = document.createElement('div');
	div_filebox.setAttribute("class","filebox");
	div_filebox.setAttribute("style","margin-left: 2%; margin-bottom: 1%;");

	var input_file = document.createElement('input');
	input_file.setAttribute("type","file");
	input_file.setAttribute("id","select_file");
	input_file.setAttribute("name","select_file");
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
	span_file2.setAttribute("style","margin-left: 2%;");
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

	document.getElementById('div-fileUpload').appendChild(div_filebox);
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


//사진 업로드 클릭 이벤트
$(function() {
	$("#btn-upload").click(function() {
		event.preventDefault();
		var filesInputTags = document.getElementsByName('select_file');
		var form = new FormData();
		var index = 1;
		for(var i = 0; i < filesInputTags.length; i++) {
			var files = filesInputTags[i].files;
			if(files == null) {
				alert("파을을 선택해 주세요.");
				return;
			}
			for(var j = 0; j < files.length; j++) {
				form.append("file" + index++ , files[j]);
			}
		}
		for (var pair of form.entries()) { 
			console.log(pair[0]+ ', ' + pair[1].name); 
		}
		ImageUploadRequest(form);
	})
})

//서버로 사진 업로드 요청
function ImageUploadRequest(sendData) {
	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url : "uploadPageImage.mdo",
		contentType : false,
		processData : false,
		data : sendData,
		success : function(data) {
			setImageList(data);
			alert("사진이 등록되었습니다.");
			document.getElementById('div-fileUpload').replaceWith(uploadFileListDiv);
			uploadFileListDiv = document.getElementById('div-fileUpload').cloneNode(true);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("error : " + jqXHR.responseText);
		}
	});
}

//업로드 파일 목록 초기화
$(function() {
	$("#btn-reset").click(function() {
		document.getElementById('div-fileUpload').replaceWith(uploadFileListDiv);
		uploadFileListDiv = document.getElementById('div-fileUpload').cloneNode(true);
	})
})


//업로드된 사진 리스트 확인
$(function() {
	$("#btn-showImage").click(function() {
		var files = document.getElementsByName('select_file');
//		ImageUploadRequest();
	})
})


//----------------------- ------- -----------------------