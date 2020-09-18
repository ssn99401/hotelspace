package com.spring.hotelspace.admin.management.hotel.service;

import java.util.Map;

import org.json.simple.parser.ParseException;

public interface AdminHotelManagerService {
	
	// 관리자 호텔목록 조회  메서드
	public Map<String, Object> getAdminHotelList(String jsonParam) throws ParseException;
	
	// 관리자 호텔 정보 조회 메서드
	public Map<String, Object> getAdminHotelInfo(String hotelId) throws ParseException;
	
	// 호텔 정보 업데이트 요청
	public int updateHotelInfo(String jsonParam) throws ParseException ;
	
	// 방 정보 업데이트 요청
	public int updateRoomInfo(String jsonParam) throws ParseException ;
}
