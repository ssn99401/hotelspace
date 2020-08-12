package com.spring.hotelspace.client.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.board.dao.ClientQNADAO;
import com.spring.hotelspace.client.board.service.ClientQNAService;

@Service
public class ClientQNAServiceImpl implements ClientQNAService {
	
	@Autowired
	private ClientQNADAO clientQNADAO;
	
}
