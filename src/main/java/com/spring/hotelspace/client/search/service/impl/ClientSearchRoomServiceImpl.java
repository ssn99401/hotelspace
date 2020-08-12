package com.spring.hotelspace.client.search.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.search.dao.ClientSearchRoomDAO;
import com.spring.hotelspace.client.search.service.ClientSearchRoomService;

@Service
public class ClientSearchRoomServiceImpl implements ClientSearchRoomService {
	
	@Autowired
	private ClientSearchRoomDAO clientSearchRoomDAO;
	
	
}
