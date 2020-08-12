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
	public int getAdminLoginResult(AdminLoginVO admin) {
		String pw =  (String)sqlSessionTemplate.selectOne(namespace + ".getAdminLoginResult",admin);
		
		if(pw != null) {
			if(pw.equals(admin.getPw())) {
				return 1;	// 로그인 성공
			} else {
				return -1;	// 비밀번호 오류
			}
		} else {
			return -2;	// 아이디 오류
		}
	}
}
