package com.spring.hotelspace.client.mypage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.mypage.dao.ClientMyPageDAO;
import com.spring.hotelspace.client.mypage.service.ClientMyPageService;

@Service
public class ClientMyPageServiceImpl implements ClientMyPageService {
	
	@Autowired
	private ClientMyPageDAO clientMyPageDAO;
	
	
	
}
