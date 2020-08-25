package com.spring.hotelspace.client.main.vo;


public class TopHotelVO {
	private String hotelId;
//	private String userId;
	private String hotelName;
//	private String hotelTel;
//	private String hotelArea;
//	private String hotelAddress;
//	private String hotelConcept;
	private Double hotelStar;
//	private String hotelRegDate;
//	private int lowestPrice;
	private String imageLink;
	private String imageType;
//	private HotelFacilityVO hotelFacility;
	private int revCnt;
	private int comCnt;
	
	
	public TopHotelVO() {
		// TODO Auto-generated constructor stub
	}


	public TopHotelVO(String hotelId, String hotelName, Double hotelStar, String imageLink, String imageType,
			int revCnt, int comCnt) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelStar = hotelStar;
		this.imageLink = imageLink;
		this.imageType = imageType;
		this.revCnt = revCnt;
		this.comCnt = comCnt;
	}


	public String getHotelId() {
		return hotelId;
	}


	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public Double getHotelStar() {
		return hotelStar;
	}


	public void setHotelStar(Double hotelStar) {
		this.hotelStar = hotelStar;
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


	public int getRevCnt() {
		return revCnt;
	}


	public void setRevCnt(int revCnt) {
		this.revCnt = revCnt;
	}


	public int getComCnt() {
		return comCnt;
	}


	public void setComCnt(int comCnt) {
		this.comCnt = comCnt;
	}


	@Override
	public String toString() {
		return "TopHotelVO [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelStar=" + hotelStar
				+ ", imageLink=" + imageLink + "]";
	}
	
	
}
