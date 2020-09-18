package com.spring.hotelspace.admin.management.hotel.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminHotelVO {
	private String hotelId;
	private String userId;
	private String hotelName;
	private String hotelTel;
	private String hotelArea;
	private String hotelAddress;
	private String hotelConcept;
	private Double hotelStar;
	private String hotelRegDate;
	
	public AdminHotelVO() {}

	public AdminHotelVO(String hotelId, String userId, String hotelName, String hotelTel, String hotelArea,
			String hotelAddress, String hotelConcept, Double hotelStar, String hotelRegDate) {
		super();
		this.hotelId = hotelId;
		this.userId = userId;
		this.hotelName = hotelName;
		this.hotelTel = hotelTel;
		this.hotelArea = hotelArea;
		this.hotelAddress = hotelAddress;
		this.hotelConcept = hotelConcept;
		this.hotelStar = hotelStar;
		this.hotelRegDate = hotelRegDate;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelTel() {
		return hotelTel;
	}

	public void setHotelTel(String hotelTel) {
		this.hotelTel = hotelTel;
	}

	public String getHotelArea() {
		return hotelArea;
	}

	public void setHotelArea(String hotelArea) {
		this.hotelArea = hotelArea;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelConcept() {
		return hotelConcept;
	}

	public void setHotelConcept(String hotelConcept) {
		this.hotelConcept = hotelConcept;
	}

	public Double getHotelStar() {
		return hotelStar;
	}

	public void setHotelStar(Double hotelStar) {
		this.hotelStar = hotelStar;
	}

	public String getHotelRegDate() {
		return hotelRegDate;
	}

	public void setHotelRegDate(String hotelRegDate) {
		this.hotelRegDate = hotelRegDate;
	}

	@Override
	public String toString() {
		return "AdminHotelVO [hotelId=" + hotelId + ", userId=" + userId + ", hotelName=" + hotelName + ", hotelTel="
				+ hotelTel + ", hotelArea=" + hotelArea + ", hotelAddress=" + hotelAddress + ", hotelConcept="
				+ hotelConcept + ", hotelStar=" + hotelStar + ", hotelRegDate=" + hotelRegDate + "]";
	}

}
