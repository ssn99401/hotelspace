package com.spring.hotelspace.client.search.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.hotelspace.client.search.vo.ClientHotelVO;

public interface ClientSearchHotelDAO {
	
	// 전체 호텔목록 조회
	public List<ClientHotelVO> searchHotelAll();
	
	// 검색바 호텔조회 - 호텔이름, 체크인, 아웃
	public List<Object> searchHotelToNameAndDate(HashMap<Object, Object> request);
}
