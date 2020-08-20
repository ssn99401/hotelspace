package com.spring.hotelspace.client.search.vo;

import org.springframework.stereotype.Component;

@Component
public class HotelFacilityVO {
	
	private int facilityParking;
	private int facilityPool;
	private int facilityBreakfast;
	private int facilityFitness;
	private int facilityWifi;
	private int facilityPartyRoom;
	
	public HotelFacilityVO() {}

	public HotelFacilityVO(int facilityParking, int facilityPool, int facilityBreakfast, int facilityFitness,
			int facilityWifi, int facilityPartyRoom) {
		super();
		this.facilityParking = facilityParking;
		this.facilityPool = facilityPool;
		this.facilityBreakfast = facilityBreakfast;
		this.facilityFitness = facilityFitness;
		this.facilityWifi = facilityWifi;
		this.facilityPartyRoom = facilityPartyRoom;
	}

	public int getFacilityParking() {
		return facilityParking;
	}

	public void setFacilityParking(int facilityParking) {
		this.facilityParking = facilityParking;
	}

	public int getFacilityPool() {
		return facilityPool;
	}

	public void setFacilityPool(int facilityPool) {
		this.facilityPool = facilityPool;
	}

	public int getFacilityBreakfast() {
		return facilityBreakfast;
	}

	public void setFacilityBreakfast(int facilityBreakfast) {
		this.facilityBreakfast = facilityBreakfast;
	}

	public int getFacilityFitness() {
		return facilityFitness;
	}

	public void setFacilityFitness(int facilityFitness) {
		this.facilityFitness = facilityFitness;
	}

	public int getFacilityWifi() {
		return facilityWifi;
	}

	public void setFacilityWifi(int facilityWifi) {
		this.facilityWifi = facilityWifi;
	}

	public int getFacilityPartyRoom() {
		return facilityPartyRoom;
	}

	public void setFacilityPartyRoom(int facilityPartyRoom) {
		this.facilityPartyRoom = facilityPartyRoom;
	}

	@Override
	public String toString() {
		return "HotelFacilityVO [facilityParking=" + facilityParking + ", facilityPool=" + facilityPool
				+ ", facilityBreakfast=" + facilityBreakfast + ", facilityFitness=" + facilityFitness
				+ ", facilityWifi=" + facilityWifi + ", facilityPartyRoom=" + facilityPartyRoom + "]";
	}
	
}
