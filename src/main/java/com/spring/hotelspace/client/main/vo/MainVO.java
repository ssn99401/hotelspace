package com.spring.hotelspace.client.main.vo;

import org.springframework.stereotype.Component;

@Component
public class MainVO {
	private String hotelId;
	private int imageId;
	private String imageType;
	private String imageLink;
	
	public MainVO() {
		// TODO Auto-generated constructor stub
	}

	public MainVO(int imageId, String imageType, String imageLink) {
		this.imageId = imageId;
		this.imageType = imageType;
		this.imageLink = imageLink;
	}
	public String getHotelId() {
		return hotelId;
	}
	
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	@Override
	public String toString() {
		return "MainVO [imageType=" + imageType + ", imageLink=" + imageLink + "]";
	}
	
	
	
	
	
	
}
