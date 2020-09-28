package com.spring.hotelspace.client.search.vo;

public class ClientSearchHotelDTO {
	
	private String searchKeyword;
	private String checkInDate;
	private String checkOutDate;
	private Integer people;
	private String area;
	private String concept;
	
	public ClientSearchHotelDTO() {}

	public ClientSearchHotelDTO(String searchKeyword, String checkInDate, String checkOutDate, Integer people,
			String area, String concept) {
		super();
		this.searchKeyword = searchKeyword;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.people = people;
		this.area = area;
		this.concept = concept;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Integer getPeople() {
		return people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "ClientSearchHotelDTO [searchKeyword=" + searchKeyword + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", people=" + people + ", area=" + area + ", concept=" + concept
				+ "]";
	}
	
}
