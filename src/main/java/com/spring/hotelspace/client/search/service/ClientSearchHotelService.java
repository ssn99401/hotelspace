package com.spring.hotelspace.client.search.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.hotelspace.client.search.vo.ClientHotelFilterDTO;
import com.spring.hotelspace.client.search.vo.ClientHotelVO;
import com.spring.hotelspace.client.search.vo.ClientSearchHotelDTO;

public interface ClientSearchHotelService {
	
	public HashMap<String, Object> searchHotelToSearchBar(ClientSearchHotelDTO requestDTO);
	public HashMap<String, Object> searchHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod);
	public HashMap<String, Object> movePageToHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod, String filter);
}
