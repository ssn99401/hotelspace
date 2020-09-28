package com.spring.hotelspace.client.search.vo;

public class ClientHotelReviewVO {
	private String reviewId;
	private String ClientId;
	private String hotelId;
	private String roomId;
	private String reviewContent;
	private Double reviewStar;
	private String reviewParentComment;
	private String reviewWriteDate;
	private String roomName;
	
	public ClientHotelReviewVO() {}

	public ClientHotelReviewVO(String reviewId, String clientId, String hotelId, String roomId, String reviewContent,
			Double reviewStar, String reviewParentComment, String reviewWriteDate, String roomName) {
		super();
		this.reviewId = reviewId;
		ClientId = clientId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.reviewContent = reviewContent;
		this.reviewStar = reviewStar;
		this.reviewParentComment = reviewParentComment;
		this.reviewWriteDate = reviewWriteDate;
		this.roomName = roomName;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getClientId() {
		return ClientId;
	}

	public void setClientId(String clientId) {
		ClientId = clientId;
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

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Double getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(Double reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getReviewParentComment() {
		return reviewParentComment;
	}

	public void setReviewParentComment(String reviewParentComment) {
		this.reviewParentComment = reviewParentComment;
	}

	public String getReviewWriteDate() {
		return reviewWriteDate;
	}

	public void setReviewWriteDate(String reviewWriteDate) {
		this.reviewWriteDate = reviewWriteDate;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "ClientHotelReviewVO [reviewId=" + reviewId + ", ClientId=" + ClientId + ", hotelId=" + hotelId
				+ ", roomId=" + roomId + ", reviewContent=" + reviewContent + ", reviewStar=" + reviewStar
				+ ", reviewParentComment=" + reviewParentComment + ", reviewWriteDate=" + reviewWriteDate
				+ ", roomName=" + roomName + "]";
	}

}
