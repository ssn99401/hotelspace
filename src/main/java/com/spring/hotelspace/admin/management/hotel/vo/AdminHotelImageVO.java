package com.spring.hotelspace.admin.management.hotel.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminHotelImageVO {
	private String hotelId;
	private String imageLink;
	private String imageType;
	
	public AdminHotelImageVO() {}

	public AdminHotelImageVO(String hotelId, String imageLink, String imageType) {
		super();
		this.hotelId = hotelId;
		this.imageLink = imageLink;
		this.imageType = imageType;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
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
		return "AdminHotelImageVO [hotelId=" + hotelId + ", imageLink=" + imageLink + ", imageType=" + imageType + "]";
	}
	
}
