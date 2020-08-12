package com.spring.hotelspace.client.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;

@Repository
public interface ClientLoginDAO {
	
	// 유저 조회 결과 반환
	public ClientLoginVO getClientLoginResult(ClientLoginVO client);
	public ClientLoginVO selectKakaoId(String id);
}