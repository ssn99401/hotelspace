package com.spring.hotelspace.admin.main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMainDAOImpl implements AdminMainDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.admin.main.dao.AdminMainPageDAO";
}
