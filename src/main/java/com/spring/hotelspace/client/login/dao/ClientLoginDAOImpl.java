package com.spring.hotelspace.client.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;

@Repository
public class ClientLoginDAOImpl implements ClientLoginDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.login.dao.ClientLoginDAO";
	
	// 유저 조회 결과 반환
	public ClientLoginVO getClientLoginResult(ClientLoginVO client) {
		
		return (ClientLoginVO)sqlSessionTemplate.selectOne(namespace + ".selectClient",client);
		
		
	}

	public ClientLoginVO selectKakaoId(String id) {
		// TODO Auto-generated method stub
		return (ClientLoginVO)sqlSessionTemplate.selectOne(namespace + ".selectKakaoId",id);
	}
}
