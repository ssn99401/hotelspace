package com.spring.hotelspace.client.search.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 호텔 방 조회관련
@Repository
public class ClientSearchRoomDAOImpl implements ClientSearchRoomDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.search.dao.ClientSearchRoomDAO";
	
}
