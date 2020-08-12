package com.spring.hotelspace.client.search.service;

import java.util.HashMap;
import java.util.List;

import com.spring.hotelspace.client.search.vo.ClientHotelVO;

public interface ClientSearchHotelService {
	
	public List<ClientHotelVO> searchHotelAll();
	public List<Object> searchHotelToKeywordAndDate(HashMap<Object, Object> request);
}
