package com.spring.hotelspace.admin.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.login.vo.AdminLoginVO;

@Repository
public class AdminLoginDAOImpl implements AdminLoginDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.admin.login.dao.AdminLoginDAO";
	
	// 로그인 결과 반환 메서드
	@Override
	public AdminLoginVO getAdminLoginResult(AdminLoginVO admin) {
		return (AdminLoginVO)sqlSessionTemplate.selectOne(namespace + ".getAdminLoginResult",admin);
	}
}
