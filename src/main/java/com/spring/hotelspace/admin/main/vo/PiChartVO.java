package com.spring.hotelspace.admin.main.vo;

public class PiChartVO {
	private String hotelConcept;
	private int reshotelcount;
	


	public String getHotelConcept() {
		return hotelConcept;
	}



	public void setHotelConcept(String hotelConcept) {
		this.hotelConcept = hotelConcept;
	}



	public int getReshotelcount() {
		return reshotelcount;
	}



	public void setReshotelcount(int reshotelcount) {
		this.reshotelcount = reshotelcount;
	}



	public PiChartVO(String hotelConcept, int reshotelcount) {
		super();
		this.hotelConcept = hotelConcept;
		this.reshotelcount = reshotelcount;
	}



	public PiChartVO() {
		// TODO Auto-generated constructor stub
	}
	
}
