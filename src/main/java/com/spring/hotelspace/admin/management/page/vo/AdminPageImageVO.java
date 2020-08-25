package com.spring.hotelspace.admin.management.page.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminPageImageVO {
	
	private String imageId;
	private String imageType;
	private String imageLink;
	
	public AdminPageImageVO() {}

	public AdminPageImageVO(String imageId, String imageType, String imageLink) {
		this.imageId = imageId;
		this.imageType = imageType;
		this.imageLink = imageLink;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
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
		return "AdminMainPageImageVO [imageId=" + imageId + ", imageType=" + imageType + ", imageLink=" + imageLink
				+ "]";
	}
	
}
