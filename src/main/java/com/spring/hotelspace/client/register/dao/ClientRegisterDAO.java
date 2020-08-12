package com.spring.hotelspace.client.register.dao;

import com.spring.hotelspace.client.register.vo.ClientRegisterVO;

public interface ClientRegisterDAO {
	public void RegisterInsert(ClientRegisterVO registerVO);
	public int checkId(ClientRegisterVO registerVO);

}
