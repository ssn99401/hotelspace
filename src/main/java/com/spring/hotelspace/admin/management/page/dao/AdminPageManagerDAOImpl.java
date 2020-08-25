package com.spring.hotelspace.admin.management.page.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

@Repository
public class AdminPageManagerDAOImpl implements AdminPageManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.admin.management.page.dao.AdminPageManagerDAO";

	// 웹 화면 이미지 리스트 반환 메서드
	@Override
	public List<AdminPageImageVO> getImageLinkList() {
		return sqlSessionTemplate.selectList(namespace + ".getImageLinksList");
	}
	
	
	
}
