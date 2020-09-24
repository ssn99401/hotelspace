package com.spring.hotelspace.admin.management.hotel.dao;

import java.util.List;
import java.util.Map;

import com.spring.hotelspace.admin.management.hotel.vo.AdminHotelImageVO;
import com.spring.hotelspace.admin.management.hotel.vo.AdminHotelVO;
import com.spring.hotelspace.admin.management.hotel.vo.AdminRoomVO;

public interface AdminHotelManagerDAO {
	// 관리자 호텔목록 조회  메서드
	public List<AdminHotelVO> getAdminHotelList(Map<String, String> requestMap);
	// 관리자 호텔 리스트 count 반환 메서드
	public int getAdminHotelListCount(Map<String, String> requestMap);

	// 호텔 정보 조회
	public AdminHotelVO getAdminHotelInfo(String hotelId);
	// 호텔 이미지 조회
	public List<AdminHotelImageVO> getAdminHotelImageList(String hotelId);
	// 호텔 방 조회
	public List<AdminRoomVO> getAdminRoomList(String hotelId);
	// 호텔 방 이미지 조회
	public List<AdminHotelImageVO> getAdminRoomImageList(List<AdminRoomVO> roomList);

	// 호텔 정보 업데이트 요청
	public int updateHotelInfo(Map<String, String> requestMap);

	// 방 정보 업데이트 요청
	public int updateRoomInfo(Map<String, String> requestMap);

	// 업로드 된 호텔 이미지 데이터베이스에 저장
	public int uploadHotelImage(List<AdminHotelImageVO> pageImageList);

	// 서버에 호텔 등록
	public int uploadHotel(Map<String, String> requestMap);

	// 업로드 된 방 이미지 데이터베이스에 저장
	public int uploadRoomImage(List<AdminHotelImageVO> pageImageList);

	// 서버에 방 등록
	public int uploadRoom(Map<String, String> requestMap);

	// 호텔 삭제
	public int deleteHotel(String hotelId);

	// 방 삭제
	public int deleteRoom(String roomId);

}
