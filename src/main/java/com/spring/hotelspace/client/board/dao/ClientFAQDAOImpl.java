package com.spring.hotelspace.client.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientFAQDAOImpl implements ClientFAQDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.board.dao.ClientFAQDAO";
	
	
}
