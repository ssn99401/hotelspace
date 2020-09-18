package com.spring.hotelspace.client.reservation.vo;

public class ClientReservationInfoVO {
	private String roomId;
	private String hotelId;
	private String roomName;
	private String hotelName;
	private int roomPrice;
	private int roomAmount;
	private String roomServices;
	private String roomInfo;
	private int roomUsage;
	private int roomStandardPeople;
	private int roomMaxPeople;
	private String imageLink;
	private String reservationInDate;
	private String reservationOutDate;

	public ClientReservationInfoVO() {
	}

	public ClientReservationInfoVO(String roomId, String hotelId, String roomName, String hotelName, int roomPrice,
			int roomAmount, String roomServices, String roomInfo, int roomUsage, int roomStandardPeople,
			int roomMaxPeople, String imageLink, String reservationInDate, String reservationOutDate) {
		super();
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomName = roomName;
		this.hotelName = hotelName;
		this.roomPrice = roomPrice;
		this.roomAmount = roomAmount;
		this.roomServices = roomServices;
		this.roomInfo = roomInfo;
		this.roomUsage = roomUsage;
		this.roomStandardPeople = roomStandardPeople;
		this.roomMaxPeople = roomMaxPeople;
		this.imageLink = imageLink;
		this.reservationInDate = reservationInDate;
		this.reservationOutDate = reservationOutDate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getRoomStandardPeople() {
		return roomStandardPeople;
	}

	public void setRoomStandardPeople(int roomStandardPeople) {
		this.roomStandardPeople = roomStandardPeople;
	}

	public int getRoomMaxPeople() {
		return roomMaxPeople;
	}

	public void setRoomMaxPeople(int roomMaxPeople) {
		this.roomMaxPeople = roomMaxPeople;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getRoomAmount() {
		return roomAmount;
	}

	public void setRoomAmount(int roomAmount) {
		this.roomAmount = roomAmount;
	}

	public String getRoomServices() {
		return roomServices;
	}

	public void setRoomServices(String roomServices) {
		this.roomServices = roomServices;
	}

	public String getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}

	public int getRoomUsage() {
		return roomUsage;
	}

	public void setRoomUsage(int roomUsage) {
		this.roomUsage = roomUsage;
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

	@Override
	public String toString() {
		return "ClientReservationInfoVO [roomId=" + roomId + ", hotelId=" + hotelId + ", roomName=" + roomName
				+ ", hotelName=" + hotelName + ", roomPrice=" + roomPrice + ", roomAmount=" + roomAmount
				+ ", roomServices=" + roomServices + ", roomInfo=" + roomInfo + ", roomUsage=" + roomUsage
				+ ", roomStandardPeople=" + roomStandardPeople + ", roomMaxPeople=" + roomMaxPeople + ", imageLink="
				+ imageLink + ", reservationInDate=" + reservationInDate + ", reservationOutDate=" + reservationOutDate
				+ "]";
	}

}
