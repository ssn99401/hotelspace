package com.spring.hotelspace.client.search.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.search.dao.ClientSearchHotelDAOImpl;
import com.spring.hotelspace.client.search.service.ClientSearchHotelService;
import com.spring.hotelspace.client.search.vo.ClientHotelVO;

@Service
public class ClientSearchHotelServiceImpl implements ClientSearchHotelService {
	
	@Autowired
	private ClientSearchHotelDAOImpl clientSearchHotelDAO;
	
	@Override
	public List<ClientHotelVO> searchHotelAll() {
		
		return clientSearchHotelDAO.searchHotelAll();
	}
	
	@Override
	public List<Object> searchHotelToKeywordAndDate(HashMap<Object, Object> request) {
		return clientSearchHotelDAO.searchHotelToNameAndDate(request);
	}
}
