package com.spring.hotelspace.admin.management.user.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminManageClientResVO {

	private String reservationId;
	private String hotelId;
	private String roomId;
	private String clientId;
	private String reservationInDate;
	private String reservationOutDate;
	private int reservationPayment;
	private int reservationPeople;
	private String reserveDate;
	private int ReviewCheck;
	private String hotelName;
	private String roomName;
	
	public AdminManageClientResVO() {
		// TODO Auto-generated constructor stub
	}

	

	
	public AdminManageClientResVO(String reservationId, String hotelId, String roomId, String clientId,
			String reservationInDate, String reservationOutDate, int reservationPayment, int reservationPeople,
			String reserveDate, int reviewCheck, String hotelName, String roomName) {
		super();
		this.reservationId = reservationId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.clientId = clientId;
		this.reservationInDate = reservationInDate;
		this.reservationOutDate = reservationOutDate;
		this.reservationPayment = reservationPayment;
		this.reservationPeople = reservationPeople;
		this.reserveDate = reserveDate;
		ReviewCheck = reviewCheck;
		this.hotelName = hotelName;
		this.roomName = roomName;
	}




	public String getReserveDate() {
		return reserveDate;
	}




	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}




	public int getReviewCheck() {
		return ReviewCheck;
	}




	public void setReviewCheck(int reviewCheck) {
		ReviewCheck = reviewCheck;
	}




	public String getHotelName() {
		return hotelName;
	}




	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}




	public String getRoomName() {
		return roomName;
	}




	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}




	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getReservationInDate() {
		//9번째 자리 수 까지 출력
		return reservationInDate.substring(0, 10);
	}

	public void setReservationInDate(String reservationInDate) {
		this.reservationInDate = reservationInDate;
	}

	public String getReservationOutDate() {
		return reservationOutDate.substring(0, 10);
	}

	public void setReservationOutDate(String reservationOutDate) {
		this.reservationOutDate = reservationOutDate;
	}


	public int getReservationPayment() {
		return reservationPayment;
	}


	public void setReservationPayment(int reservationPayment) {
		this.reservationPayment = reservationPayment;
	}

	public int getReservationPeople() {
		return reservationPeople;
	}

	public void setReservationPeople(int reservationPeople) {
		this.reservationPeople = reservationPeople;
	}

	public String getReservationReserveDate() {
		return reserveDate;
	}

	public void setReservationReserveDate(String reservationReserveDate) {
		this.reserveDate = reservationReserveDate;
	}


	
}
