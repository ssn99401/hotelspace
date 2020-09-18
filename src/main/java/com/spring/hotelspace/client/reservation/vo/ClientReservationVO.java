package com.spring.hotelspace.client.reservation.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ClientReservationVO {

	private String hotelId;
	private String roomId;
	private String reservationInDate;
	private String reservationOutDate;
	private int reservationPayment;
	private String clientId;
	private int reservationPeople;
	
	public ClientReservationVO() {}
	public ClientReservationVO(String hotelId, String roomId, String reservationInDate, String reservationOutDate,
			int reservationPayment, String clientId, int reservationPeople) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.reservationInDate = reservationInDate;
		this.reservationOutDate = reservationOutDate;
		this.reservationPayment = reservationPayment;
		this.clientId = clientId;
		this.reservationPeople = reservationPeople;
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getReservationPeople() {
		return reservationPeople;
	}
	public void setReservationPeople(int reservationPeople) {
		this.reservationPeople = reservationPeople;
	}
	@Override
	public String toString() {
		return "ClientReservationVO [hotelId=" + hotelId + ", roomId=" + roomId + ", reservationInDate="
				+ reservationInDate + ", reservationOutDate=" + reservationOutDate + ", reservationPayment="
				+ reservationPayment + ", clientId=" + clientId + ", reservationPeople=" + reservationPeople + "]";
	}



}
