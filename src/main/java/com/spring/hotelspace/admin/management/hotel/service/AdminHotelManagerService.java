package com.spring.hotelspace.admin.management.hotel.service;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AdminHotelManagerService {

	// 관리자 호텔목록 조회  메서드
	public Map<String, Object> getAdminHotelList(String jsonParam) throws ParseException;

	// 관리자 호텔 정보 조회 메서드
	public Map<String, Object> getAdminHotelInfo(String hotelId) throws ParseException;

	// 호텔 정보 업데이트 요청처리 메서드
	public int updateHotelInfo(String jsonParam) throws ParseException ;

	// 방 정보 업데이트 요청처리 메서드
	public int updateRoomInfo(String jsonParam) throws ParseException ;

	// 호텔 파일 업로드 요청처리 메서드
	public String uploadHotelImage(MultipartHttpServletRequest files) throws IOException, Exception;

	// 호텔 등록 요청처리 메서드
	public int uploadHotel(String jsonParam) throws ParseException ;

	// 방 파일 업로드 요청처리 메서드
	public String uploadRoomImage(MultipartHttpServletRequest files) throws IOException, Exception;

	// 방 등록 요청처리 메서드
	public int uploadRoom(String jsonParam) throws ParseException;

	// 호텔 삭제 요청 처리 메서드
	public int deleteHotel(String jsonParam) throws ParseException;

	// 방 삭제 요청 처리 메서드
	public int deleteRoom(String jsonParam) throws ParseException;
}
