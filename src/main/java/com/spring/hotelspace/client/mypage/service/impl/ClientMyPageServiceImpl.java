package com.spring.hotelspace.client.mypage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.dao.ClientMyPageDAO;
import com.spring.hotelspace.client.mypage.service.ClientMyPageService;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;

@Service
public class ClientMyPageServiceImpl implements ClientMyPageService {
	
	@Autowired
	private ClientMyPageDAO clientMyPageDAO;

	@Override
	public int updateAction(ClientLoginVO loginVO) {
		
		return clientMyPageDAO.updateAction(loginVO);
	}

	@Override
	public ClientLoginVO searchAll(ClientLoginVO loginVO) {
		// TODO Auto-generated method stub
		return clientMyPageDAO.selectAll(loginVO);
	}

	
	   @Override
	   public int changePW(ClientMyPageVO client) {
	      // TODO Auto-generated method stub
	      return clientMyPageDAO.changePW(client);
	   }

	   @Override
	   public int checkPw(ClientMyPageVO myPagevo1) {
	      // TODO Auto-generated method stub
	      return clientMyPageDAO.checkPw(myPagevo1);
	   }
	
	
}
