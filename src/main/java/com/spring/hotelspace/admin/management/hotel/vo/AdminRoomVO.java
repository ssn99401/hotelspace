package com.spring.hotelspace.admin.management.hotel.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminRoomVO {
	private String roomId;
	private String hotelId;
	private String roomName;
	private String roomPrice;
	private String roomAmount;
	private String roomStandardPeople;
	private String roomMaxPeople;
	private String roomPricePeople;
	private String roomServices;
	private String roomInfo;
	private String roomUsage;
	
	public AdminRoomVO() {}

	public AdminRoomVO(String roomId, String hotelId, String roomName, String roomPrice, String roomAmount,
			String roomStandardPeople, String roomMaxPeople, String roomPricePeople, String roomServices,
			String roomInfo, String roomUsage) {
		super();
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomAmount = roomAmount;
		this.roomStandardPeople = roomStandardPeople;
		this.roomMaxPeople = roomMaxPeople;
		this.roomPricePeople = roomPricePeople;
		this.roomServices = roomServices;
		this.roomInfo = roomInfo;
		this.roomUsage = roomUsage;
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

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomAmount() {
		return roomAmount;
	}

	public void setRoomAmount(String roomAmount) {
		this.roomAmount = roomAmount;
	}

	public String getRoomStandardPeople() {
		return roomStandardPeople;
	}

	public void setRoomStandardPeople(String roomStandardPeople) {
		this.roomStandardPeople = roomStandardPeople;
	}

	public String getRoomMaxPeople() {
		return roomMaxPeople;
	}

	public void setRoomMaxPeople(String roomMaxPeople) {
		this.roomMaxPeople = roomMaxPeople;
	}

	public String getRoomPricePeople() {
		return roomPricePeople;
	}

	public void setRoomPricePeople(String roomPricePeople) {
		this.roomPricePeople = roomPricePeople;
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

	public String getRoomUsage() {
		return roomUsage;
	}

	public void setRoomUsage(String roomUsage) {
		this.roomUsage = roomUsage;
	}

	@Override
	public String toString() {
		return "AdminRoomVO [roomId=" + roomId + ", hotelId=" + hotelId + ", roomName=" + roomName + ", roomPrice="
				+ roomPrice + ", roomAmount=" + roomAmount + ", roomStandardPeople=" + roomStandardPeople
				+ ", roomMaxPeople=" + roomMaxPeople + ", roomPricePeople=" + roomPricePeople + ", roomServices="
				+ roomServices + ", roomInfo=" + roomInfo + ", roomUsage=" + roomUsage + "]";
	}
}
