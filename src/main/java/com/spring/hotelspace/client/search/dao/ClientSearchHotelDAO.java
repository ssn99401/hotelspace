package com.spring.hotelspace.client.search.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.hotelspace.client.search.vo.ClientHotelVO;

public interface ClientSearchHotelDAO {
	
	// 조회한 호텔리스트 총 갯수
	public int getCountToHotelList(HashMap<Object, Object> map);
	
	// 전체 호텔목록 조회
	public List<Object> searchHotelAll(HashMap<Object, Object> map);
	
	// 호텔 리스트 검색(index page)
	public List<Object> searchHotelToSearchBar(HashMap<Object, Object> map);
	
}
