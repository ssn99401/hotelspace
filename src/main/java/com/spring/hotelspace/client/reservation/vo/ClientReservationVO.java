package com.spring.hotelspace.client.reservation.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ClientReservationVO {
	private int reservationId;
	private String hotelId;
	private String roomId;
	private String userId;
	private Date reservationInDate;
	private Date reservationOutDate;
	private Date reservationReserveDate;
	private int reservationPayment;
	private int reservationReviewCheck;
	
	
	
	public ClientReservationVO() {}
	
	public ClientReservationVO(int reservationId, String hotelId, String roomId, String userId, Date reservationInDate,
			Date reservationOutDate, Date reservationReserveDate, int reservationPayment, int reservationReviewCheck) {
		super();
		this.reservationId = reservationId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.reservationInDate = reservationInDate;
		this.reservationOutDate = reservationOutDate;
		this.reservationReserveDate = reservationReserveDate;
		this.reservationPayment = reservationPayment;
		this.reservationReviewCheck = reservationReviewCheck;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getReservationInDate() {
		return reservationInDate;
	}
	public void setReservationInDate(Date reservationInDate) {
		this.reservationInDate = reservationInDate;
	}
	public Date getReservationOutDate() {
		return reservationOutDate;
	}
	public void setReservationOutDate(Date reservationOutDate) {
		this.reservationOutDate = reservationOutDate;
	}
	public Date getReservationReserveDate() {
		return reservationReserveDate;
	}
	public void setReservationReserveDate(Date reservationReserveDate) {
		this.reservationReserveDate = reservationReserveDate;
	}
	public int getReservationPayment() {
		return reservationPayment;
	}
	public void setReservationPayment(int reservationPayment) {
		this.reservationPayment = reservationPayment;
	}
	public int getReservationReviewCheck() {
		return reservationReviewCheck;
	}
	public void setReservationReviewCheck(int reservationReviewCheck) {
		this.reservationReviewCheck = reservationReviewCheck;
	}
	@Override
	public String toString() {
		return "ClientReservationVO [reservationId=" + reservationId + ", hotelId=" + hotelId + ", roomId=" + roomId
				+ ", userId=" + userId + ", reservationInDate=" + reservationInDate + ", reservationOutDate="
				+ reservationOutDate + ", reservationReserveDate=" + reservationReserveDate + ", reservationPayment="
				+ reservationPayment + ", reservationReviewCheck=" + reservationReviewCheck + "]";
	}
	
	
	
	
}
