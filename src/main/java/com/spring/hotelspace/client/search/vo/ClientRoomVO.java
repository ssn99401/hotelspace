package com.spring.hotelspace.client.search.vo;

public class ClientRoomVO {
	
	private String roomId;
	private String hotelId;
	private String roomName;
	private int roomPrice;
	private int roomAmount;
	private String roomServices;
	private String roomInfo;
	private int roomUsage;
	
	public ClientRoomVO() {}

	public ClientRoomVO(String roomId, String hotelId, String roomName, int roomPrice, int roomAmount,
			String roomServices, String roomInfo, int roomUsage) {
		super();
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomAmount = roomAmount;
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

	@Override
	public String toString() {
		return "ClientRoomVO [roomId=" + roomId + ", hotelId=" + hotelId + ", roomName=" + roomName + ", roomPrice="
				+ roomPrice + ", roomAmount=" + roomAmount + ", roomServices=" + roomServices + ", roomInfo=" + roomInfo
				+ ", roomUsage=" + roomUsage + "]";
	}
	
}
