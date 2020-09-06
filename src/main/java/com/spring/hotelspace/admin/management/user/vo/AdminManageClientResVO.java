package com.spring.hotelspace.admin.management.user.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminManageClientResVO {
	private String reservationId;
	private String hotelId;
	private String roomId;
	private String reservationInDate;
	private String reservationOutDate;
	private int payment;
	private int people;
	private String reservationReserveDate;
	private int reservationReviewCheck;
	
	public AdminManageClientResVO() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminManageClientResVO(String reservationId, String hotelId, String roomId, String reservationInDate,
			String reservationOutDate, int payment, int people, String reservationReserveDate,
			int reservationReviewCheck) {
		this.reservationId = reservationId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.reservationInDate = reservationInDate;
		this.reservationOutDate = reservationOutDate;
		this.payment = payment;
		this.people = people;
		this.reservationReserveDate = reservationReserveDate;
		this.reservationReviewCheck = reservationReviewCheck;
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
		return reservationInDate;
	}

	public void setReservationInDate(String reservationInDate) {
		this.reservationInDate = reservationInDate;
	}

	public String getReservationOutDate() {
		return reservationOutDate;
	}

	public void setReservationOutDate(String reservationOutDate) {
		this.reservationOutDate = reservationOutDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getReservationReserveDate() {
		return reservationReserveDate;
	}

	public void setReservationReserveDate(String reservationReserveDate) {
		this.reservationReserveDate = reservationReserveDate;
	}

	public int getReservationReviewCheck() {
		return reservationReviewCheck;
	}

	public void setReservationReviewCheck(int reservationReviewCheck) {
		this.reservationReviewCheck = reservationReviewCheck;
	}
	
}
