package com.spring.hotelspace.client.mypage.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;

@Repository
public class ClientMyPageDAOImpl implements ClientMyPageDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.mypage.dao.ClientMyPageDAO";

	@Override
	public int updateAction(ClientLoginVO loginVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace + ".updateMyInfo", loginVO);
	}

	@Override
	public ClientLoginVO selectAll(ClientLoginVO loginVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".selectAll", loginVO);
	}
	
}
