package com.spring.hotelspace.client.register.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.register.vo.ClientRegisterVO;


@Repository
public class ClientRegisterDAOImpl implements ClientRegisterDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.register.dao.ClientRegisterDAO";

	@Override
	public void RegisterInsert(ClientRegisterVO registerVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkId(ClientRegisterVO registerVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
