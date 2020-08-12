package com.spring.hotelspace.client.search.vo;

import org.springframework.stereotype.Component;

@Component
public class HotelFacilityVO {
	
	private String facilityParking;
	private String facilityPool;
	private String facilityBreakfast;
	private String facilityFitness;
	private String facilityWifi;
	private String facilityParty;
	
	public HotelFacilityVO() {}
	
	public HotelFacilityVO(String facilityParking, String facilityPool, String facilityBreakfast,
			String facilityFitness, String facilityWifi, String facilityParty) {
		super();
		this.facilityParking = facilityParking;
		this.facilityPool = facilityPool;
		this.facilityBreakfast = facilityBreakfast;
		this.facilityFitness = facilityFitness;
		this.facilityWifi = facilityWifi;
		this.facilityParty = facilityParty;
	}
	
	public String getFacilityParking() {
		return facilityParking;
	}
	public void setFacilityParking(String facilityParking) {
		this.facilityParking = facilityParking;
	}
	public String getFacilityPool() {
		return facilityPool;
	}
	public void setFacilityPool(String facilityPool) {
		this.facilityPool = facilityPool;
	}
	public String getFacilityBreakfast() {
		return facilityBreakfast;
	}
	public void setFacilityBreakfast(String facilityBreakfast) {
		this.facilityBreakfast = facilityBreakfast;
	}
	public String getFacilityFitness() {
		return facilityFitness;
	}
	public void setFacilityFitness(String facilityFitness) {
		this.facilityFitness = facilityFitness;
	}
	public String getFacilityWifi() {
		return facilityWifi;
	}
	public void setFacilityWifi(String facilityWifi) {
		this.facilityWifi = facilityWifi;
	}
	public String getFacilityParty() {
		return facilityParty;
	}
	public void setFacilityParty(String facilityParty) {
		this.facilityParty = facilityParty;
	}
	@Override
	public String toString() {
		return "MemberHotelsFacilityVO [facilityParking=" + facilityParking
				+ ", facilityPool=" + facilityPool + ", facilityBreakfast=" + facilityBreakfast + ", facilityFitness="
				+ facilityFitness + ", facilityWifi=" + facilityWifi + ", facilityParty=" + facilityParty + "]";
	}	
	
}
