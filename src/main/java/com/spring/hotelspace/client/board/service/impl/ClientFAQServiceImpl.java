package com.spring.hotelspace.client.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.board.dao.ClientFAQDAO;
import com.spring.hotelspace.client.board.service.ClientFAQService;

@Service
public class ClientFAQServiceImpl implements ClientFAQService {

	@Autowired
	private ClientFAQDAO clientFAQDAO;
	
}
