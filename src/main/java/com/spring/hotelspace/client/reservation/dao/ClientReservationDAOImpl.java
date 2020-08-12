package com.spring.hotelspace.client.reservation.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientReservationDAOImpl implements ClientReservationDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.reservation.dao.ClientReservationDAO";
	
}
