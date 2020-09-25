function checkInputDate() {
	
	var checkInDate = document.getElementById("checkInDate").value;        
	var checkInDate_arr = checkInDate.split("-");
	var checkOutDate = document.getElementById("checkOutDate").value;    
	var checkOutDate_arr = checkOutDate.split("-");
	
	if(checkInDate == "" || checkOutDate == "") {
		alert("날짜를 선택해 주세요");
		return false;
	}

	var checkInDate_obj = new Date(checkInDate_arr[0], Number(checkInDate_arr[1])-1, checkInDate_arr[2]);
	var checkOutDate_obj = new Date(checkOutDate_arr[0], Number(checkOutDate_arr[1])-1, checkOutDate_arr[2]);

	var betweenDay = (checkOutDate_obj.getTime() - checkInDate_obj.getTime());

	if(betweenDay <= 0) {
		alert("날짜를 확인해 주세요");
		return false;
	}

}

