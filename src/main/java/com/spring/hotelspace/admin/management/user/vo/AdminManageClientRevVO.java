package com.spring.hotelspace.admin.management.user.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AdminManageClientRevVO {
	private String reviewId;
	private String clientId;
	private String hotelId;
	private String roomId;
	private String reviewContent;
	private int reviewStar;
	private String reviewParentComment;
	private String reviewWriteDate;
	private String hotelName;
	private String roomName;
	
	public AdminManageClientRevVO() {
		// TODO Auto-generated constructor stub
	}

	

	public AdminManageClientRevVO(String reviewId, String clientId, String hotelId, String roomId, String reviewContent,
			int reviewStar, String reviewParentComment, String reviewWriteDate, String hotelName, String roomName) {
		super();
		this.reviewId = reviewId;
		this.clientId = clientId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.reviewContent = reviewContent;
		this.reviewStar = reviewStar;
		this.reviewParentComment = reviewParentComment;
		this.reviewWriteDate = reviewWriteDate;
		this.hotelName = hotelName;
		this.roomName = roomName;
	}



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



	public String getHotelName() {
		return hotelName;
	}



	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}



	public String getRoomName() {
		return roomName;
	}



	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
	
}
