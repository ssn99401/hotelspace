window.onload = function () {
	loadingImageList();
}

function loadingImageList() {
	$.ajax({
		type: "POST",
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

$(function() {
    $("#_mainhome").click(function() {
    	$("#imageModal").modal();
    	setImage(this.getAttribute("id"), null);
        return false;
    })
})
$(function() {
    $("#_seoul").click(function() {
    	$("#imageModal").modal();
    	setImage(this.getAttribute("id"), null);
        return false;
    })
})
$(function() {
    $("#_busan").click(function() {
    	$("#imageModal").modal();
    	setImage(this.getAttribute("id"), null);
        return false;
    })
})
$(function() {
    $("#_jeju").click(function() {
    	$("#imageModal").modal();
    	setImage(this.getAttribute("id"), null);
         return false;
    })
})
function setImage(divId, imageLink) {
	var imgTagId = 'img' + divId;
	var imageNode = document.getElementById(imgTagId);
//	imageNode.setAttribute("src",imageLink);
};

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
	}
	setModalImage(data);
};


function setModalImage(data) {
	$('#modal-body').empty();
	var modal_body = document.getElementById("modal-body");
	
	var div_modalRow = document.createElement("div");
	var i = 1;
	for(let mapKey in data) {
		
		var div_modalRow1 = document.createElement("div");
		div_modalRow1.setAttribute("class", "col-md-4 col-lg-3 mb-4 mb-lg-0");
		var div_modalRowImage = document.createElement("img");
		div_modalRowImage.setAttribute("class", "img-fluid");
		div_modalRowImage.setAttribute("id", "img-" + i );
		div_modalRowImage.setAttribute("src", data[mapKey].imageLink );
		div_modalRow1.appendChild(div_modalRowImage);
		div_modalRow.appendChild(div_modalRow1);
		if(i % 4 == 0) {
			modal_body.appendChild(div_modalRow);
			div_modalRow = document.createElement("div");
			div_modalRow.setAttribute("class", "row");
			div_modalRow.setAttribute("style", "width: 100%;");
		}
		i++;
	}
	
};
