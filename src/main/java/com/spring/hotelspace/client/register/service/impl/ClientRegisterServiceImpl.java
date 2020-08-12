package com.spring.hotelspace.client.register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.register.dao.ClientRegisterDAO;
import com.spring.hotelspace.client.register.service.ClientRegisterService;
import com.spring.hotelspace.client.register.vo.ClientRegisterVO;

@Service
public class ClientRegisterServiceImpl implements ClientRegisterService {
	
	@Autowired
	private ClientRegisterDAO dao;
	
	@Override
	public void RegisterInsert(ClientRegisterVO registerVO) {
		// TODO Auto-generated method stub
		dao.RegisterInsert(registerVO);
	}

	@Override
	public int checkId(ClientRegisterVO registerVO) {
		// TODO Auto-generated method stub
		 return dao.checkId(registerVO);
	}

}
