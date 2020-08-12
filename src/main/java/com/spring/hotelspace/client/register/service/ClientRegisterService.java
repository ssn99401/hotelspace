package com.spring.hotelspace.client.register.service;

import com.spring.hotelspace.client.register.vo.ClientRegisterVO;

public interface ClientRegisterService {
	public void RegisterInsert(ClientRegisterVO registerVO);

	public int checkId(ClientRegisterVO registerVO);
}
