package com.spring.hotelspace.client.reservation.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ClientReservationVO {
	private String reservationId;
	private String clientId;
	private String hotelId;
	private String roomId;
	private String reservationInDate;
	private String reservationOutDate;
	private int reservationPayment;
	private int reservationPeople;
	private String reserveDate;
	private String roomName;
	private int reviewCheck;

	public ClientReservationVO() {}

	public ClientReservationVO(String reservationId, String clientId, String hotelId, String roomId,
			String reservationInDate, String reservationOutDate, int reservationPayment, int reservationPeople,
			String reserveDate, String roomName, int reviewCheck) {
		super();
		this.reservationId = reservationId;
		this.clientId = clientId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.reservationInDate = reservationInDate;
		this.reservationOutDate = reservationOutDate;
		this.reservationPayment = reservationPayment;
		this.reservationPeople = reservationPeople;
		this.reserveDate = reserveDate;
		this.roomName = roomName;
		this.reviewCheck = reviewCheck;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getReviewCheck() {
		return reviewCheck;
	}

	public void setReviewCheck(int reviewCheck) {
		this.reviewCheck = reviewCheck;
	}

	@Override
	public String toString() {
		return "ClientReservationVO [reservationId=" + reservationId + ", clientId=" + clientId + ", hotelId=" + hotelId
				+ ", roomId=" + roomId + ", reservationInDate=" + reservationInDate + ", reservationOutDate="
				+ reservationOutDate + ", reservationPayment=" + reservationPayment + ", reservationPeople="
				+ reservationPeople + ", reserveDate=" + reserveDate + ", roomName=" + roomName + ", reviewCheck="
				+ reviewCheck + "]";
	}

}