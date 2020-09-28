//금액 컴마

	function comma(num) {
		var len, point, str;

		num = num + "";
		point = num.length % 3;
		len = num.length;

		str = num.substring(0, point);
		while (point < len) {
			if (str != "")
				str += ",";
			str += num.substring(point, point + 3);
			point += 3;
		}

		return str;
	}
	//인원감소
	function peopleMinus() {
		var reservationPeople = $('#reservationPeople').val();
		var sPeople = $('#sPeople').val();
		var mPeople = $('#mPeople').val();
		if (sPeople == reservationPeople) {
			return false;
		}
		reservationPeople--
		var totalPrice = $('#hPrice').val();
		var afterPrice = parseInt(totalPrice) - 30000;
		var param = comma(afterPrice);
		$('#price').html("");
		var th1 = $('<input type = "hidden" id = "hPrice" value = "'
				+ parseInt(afterPrice) + '"> <label>' + param + '￦</label>');
		/* var th1 = $('<td  style="text-align: center;"> <input type = "hidden" id = "hPrice" value = "'
				+ parseInt(afterPrice)
				+ '">'
				+ parseInt(afterPrice)
				+ ' ￦</td>'); */

		th1.appendTo('#price');
		$('#reservationPeople').val(reservationPeople);
		console.log(totalPrice + "totalPrice");
		console.log(afterPrice + "afterPrice");
	}
	//인원증가
	function peoplePlus() {
		var reservationPeople = $('#reservationPeople').val();
		var sPeople = $('#sPeople').val();
		var mPeople = $('#mPeople').val();
		if (mPeople == reservationPeople) {
			return false;
		}
		reservationPeople++
		var totalPrice = $('#hPrice').val();
		var afterPrice = parseInt(totalPrice) + 30000;

		var param = comma(afterPrice);
		$('#price').html("");
		var th1 = $('<input type = "hidden" id = "hPrice" value = "'
				+ parseInt(afterPrice) + '"> <label>' + param + '￦</label>');
		/* var th1 = $('<td  style="text-align: center;"> <input type = "hidden" id = "hPrice" value = "'
				+ parseInt(afterPrice)
				+ '">'
				+ parseInt(afterPrice)
				+ ' ￦</td>'); */

		th1.appendTo('#price');
		$('#reservationPeople').val(reservationPeople);
		console.log(totalPrice + "totalPrice");
		console.log(afterPrice + "afterPrice");
	}

	//카카오 결제 api
	$(document).ready(function() {
		console.log("dhdhdhdhdhdhdh");
		/* <c:set var='status1' value = '1'/> */

		$(document).on('click', '#pay', pay);

	});
	function pay() {
		var IMP = window.IMP; // 생략가능
		IMP.init('imp68739289'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		var msg;
		var clientId = $('#clientId').val();
		var hotelId = $('#hotelId').val();
		var roomId = $('#roomId').val();

		var reservationInDate = $('#reservationInDate').val();
		var reservationOutDate = $('#reservationOutDate').val();

		var reservationPayment = $('#hPrice').val();
		var reservationPeople = $('#sPeople').val();
		console.log(clientId);
		console.log(reservationPayment);

		IMP.request_pay({
			pg : 'kakaopay',
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : 'Room 결제',
			amount : reservationPayment,
			buyer_name : clientId

		}, function(rsp) {
			if (rsp.success) {

				//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
				jQuery.ajax({
					url : "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
					type : 'POST',
					dataType : 'json',
					data : {
						imp_uid : rsp.imp_uid
					//기타 필요한 데이터가 있으면 추가 전달
					}
				}).done(function(data) {
					//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
					if (everythings_fine) {
						msg = '결제가 완료되었습니다.';
						msg += '\n고유ID : ' + rsp.imp_uid;
						msg += '\n상점 거래ID : ' + rsp.merchant_uid;
						msg += '\결제 금액 : ' + rsp.paid_amount;
						msg += '카드 승인번호 : ' + rsp.apply_num;

						alert(msg);
					} else {
						//[3] 아직 제대로 결제가 되지 않았습니다.
						//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
					}	
				});
				//성공시 이동할 페이지
				location.href = "insertReserv.do?clientId=" + clientId
						+ "&hotelId=" + hotelId + "&roomId=" + roomId
						+ "&reservationInDate=" + reservationInDate
						+ "&reservationOutDate=" + reservationOutDate
						+ "&reservationPayment=" + reservationPayment
						+ "&reservationPeople=" + reservationPeople;
			} else {
				msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				//실패시 이동할 페이지

				alert(msg);
			}
		});

	}