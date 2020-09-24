package com.spring.hotelspace.client.mypage.vo;

public class ClientReviewVO {
	private String reviewId;
	private String clientId;
	private String hotelId;
	private String roomId;
	private String reviewContent;
	private int reviewStar;
	private String reviewParentComment;
	private String reviewWriteDate;
	
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
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
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
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
	
	@Override
	public String toString() {
		return "ClientReviewVO [reviewId=" + reviewId + ", clientId=" + clientId + ", hotelId=" + hotelId + ", roomId="
				+ roomId + ", reviewContent=" + reviewContent + ", reviewStar=" + reviewStar + ", reviewParentComment="
				+ reviewParentComment + ", reviewWriteDate=" + reviewWriteDate + "]";
	}

	
}
