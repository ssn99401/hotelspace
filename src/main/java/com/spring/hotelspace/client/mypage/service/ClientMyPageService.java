package com.spring.hotelspace.client.mypage.service;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;

public interface ClientMyPageService {
	
	public int updateAction(ClientLoginVO loginVO);

	public ClientLoginVO searchAll(ClientLoginVO loginVO);

	int changePW(ClientMyPageVO client);

	int checkPw(ClientMyPageVO myPagevo1);
}
