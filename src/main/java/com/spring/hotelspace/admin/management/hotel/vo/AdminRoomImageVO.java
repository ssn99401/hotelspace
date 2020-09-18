package com.spring.hotelspace.admin.management.hotel.vo;


public class AdminRoomImageVO {
	private String roomId;
	private String imageLink;
	private String imageType;
	
	public AdminRoomImageVO() {}

	public AdminRoomImageVO(String roomId, String imageLink, String imageType) {
		super();
		this.roomId = roomId;
		this.imageLink = imageLink;
		this.imageType = imageType;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Override
	public String toString() {
		return "AdminRoomImageVO [roomId=" + roomId + ", imageLink=" + imageLink + ", imageType=" + imageType + "]";
	}

}
