package com.spring.hotelspace.client.login.service;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;

public interface ClientLoginService {
	public ClientLoginVO getClientLoginResult(ClientLoginVO client);

	public ClientLoginVO compareKakaoId(String id);
}