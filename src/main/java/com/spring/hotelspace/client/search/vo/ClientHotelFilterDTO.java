package com.spring.hotelspace.client.search.vo;

public class ClientHotelFilterDTO {
	private String checkedKeyword;
	private String parking;
	private String pool;
	private String breakfast;
	private String fitness;
	private String wifi;
	private String partyRoom;
	private int minPrice;
	private int maxPrice;
	private int minStar;
	private int maxStar;
	private String checkedConcept;
	private int pageNum;
	
	public ClientHotelFilterDTO() {}

	public ClientHotelFilterDTO(String checkedKeyword, String parking, String pool, String breakfast, String fitness,
			String wifi, String partyRoom, int minPrice, int maxPrice, int minStar, int maxStar, String checkedConcept,
			int pageNum) {
		super();
		this.checkedKeyword = checkedKeyword;
		this.parking = parking;
		this.pool = pool;
		this.breakfast = breakfast;
		this.fitness = fitness;
		this.wifi = wifi;
		this.partyRoom = partyRoom;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.minStar = minStar;
		this.maxStar = maxStar;
		this.checkedConcept = checkedConcept;
		this.pageNum = pageNum;
	}

	public String getCheckedKeyword() {
		return checkedKeyword;
	}

	public void setCheckedKeyword(String checkedKeyword) {
		this.checkedKeyword = checkedKeyword;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getFitness() {
		return fitness;
	}

	public void setFitness(String fitness) {
		this.fitness = fitness;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getPartyRoom() {
		return partyRoom;
	}

	public void setPartyRoom(String partyRoom) {
		this.partyRoom = partyRoom;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinStar() {
		return minStar;
	}

	public void setMinStar(int minStar) {
		this.minStar = minStar;
	}

	public int getMaxStar() {
		return maxStar;
	}

	public void setMaxStar(int maxStar) {
		this.maxStar = maxStar;
	}

	public String getCheckedConcept() {
		return checkedConcept;
	}

	public void setCheckedConcept(String checkedConcept) {
		this.checkedConcept = checkedConcept;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "ClientHotelFilterDTO [checkedKeyword=" + checkedKeyword + ", parking=" + parking + ", pool=" + pool
				+ ", breakfast=" + breakfast + ", fitness=" + fitness + ", wifi=" + wifi + ", partyRoom=" + partyRoom
				+ ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", minStar=" + minStar + ", maxStar=" + maxStar
				+ ", checkedConcept=" + checkedConcept + ", pageNum=" + pageNum + "]";
	}
	
	
	
}
