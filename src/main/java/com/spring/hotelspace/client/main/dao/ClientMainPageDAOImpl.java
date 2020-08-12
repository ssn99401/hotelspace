package com.spring.hotelspace.client.main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientMainPageDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.main.dao.ClientMainPageDAO";
}
