package com.spring.hotelspace.client.main.dao;

import java.util.List;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.main.vo.MainVO;
import com.spring.hotelspace.client.main.vo.TopHotelVO;

@Repository
public class ClientMainPageDAOImpl implements ClientMainPageDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.main.dao.ClientMainPageDAO";

	public List<MainVO> getMainPageImage() {
		// TODO Auto-generated method stub
	
		return sqlSessionTemplate.selectList(namespace + ".getAll");
	}

	@Override
	public List<TopHotelVO> getHotelImage() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace + ".getHotelImage");
	}


}
