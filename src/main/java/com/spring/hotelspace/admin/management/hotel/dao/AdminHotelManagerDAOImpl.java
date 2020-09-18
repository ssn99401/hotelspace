package com.spring.hotelspace.admin.management.hotel.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.management.hotel.vo.AdminHotelImageVO;
import com.spring.hotelspace.admin.management.hotel.vo.AdminHotelVO;
import com.spring.hotelspace.admin.management.hotel.vo.AdminRoomVO;

@Repository
public class AdminHotelManagerDAOImpl implements AdminHotelManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.admin.management.hotel.dao.AdminHotelManagerDAO";

	// 관리자 호텔목록 조회  메서드
	public List<AdminHotelVO> getAdminHotelList(Map<String, String> requestMap) {
		return sqlSessionTemplate.selectList(namespace + ".getHotelList", requestMap);
	}

	// 관리자 호텔 리스트 count 반환 메서드
	public int getAdminHotelListCount(Map<String, String> requestMap) {
		return sqlSessionTemplate.selectOne(namespace + ".getHotelListCount", requestMap);
	}

	// 호텔 정보 조회
	public AdminHotelVO getAdminHotelInfo(String hotelId) {
		return sqlSessionTemplate.selectOne(namespace + ".getHotelInfo", hotelId);
	}
	// 호텔 이미지 조회
	public List<AdminHotelImageVO> getAdminHotelImageList(String hotelId) {
		return sqlSessionTemplate.selectList(namespace + ".getHotelImageList", hotelId);
	}
	// 호텔 방 조회
	public List<AdminRoomVO> getAdminRoomList(String hotelId) {
		return sqlSessionTemplate.selectList(namespace + ".getRoomList", hotelId);
	}
	// 호텔 방 이미지 조회
	public List<AdminHotelImageVO> getAdminRoomImageList(List<AdminRoomVO> roomList) {
		return sqlSessionTemplate.selectList(namespace + ".getRoomImageList", roomList);
	}
	
	// 호텔 정보 업데이트 요청
	public int updateHotelInfo(Map<String, String> requestMap) {
		return sqlSessionTemplate.update(namespace + ".updateHotelInfo", requestMap);
	}

	// 방 정보 업데이트 요청
	public int updateRoomInfo(Map<String, String> requestMap) {
		return sqlSessionTemplate.update(namespace + ".updateRoomInfo", requestMap);
	}
}
