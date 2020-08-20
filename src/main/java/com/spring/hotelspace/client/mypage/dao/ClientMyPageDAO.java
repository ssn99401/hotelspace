package com.spring.hotelspace.client.mypage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;

@Repository
public interface ClientMyPageDAO {
	
	//업데이트만
	public int updateAction(ClientLoginVO loginVO);

	public ClientLoginVO selectAll(ClientLoginVO loginVO);

	int changePW(ClientMyPageVO client);

	public int checkPw(ClientMyPageVO myPagevo1);
	
	
}
