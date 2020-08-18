package com.spring.hotelspace.client.mypage.service;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;

public interface ClientMyPageService {
	
	public int updateAction(ClientLoginVO loginVO);

	public ClientLoginVO searchAll(ClientLoginVO loginVO);
}
