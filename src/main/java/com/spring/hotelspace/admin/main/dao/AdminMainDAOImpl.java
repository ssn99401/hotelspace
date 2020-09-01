package com.spring.hotelspace.admin.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;

@Repository
public class AdminMainDAOImpl implements AdminMainDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.admin.main.dao.AdminMainDAO";
	
	public List<AdminMainVO> getClientTable(AdminMainVO vo) {
		
		System.out.println("dao 넘어왔음");
		//전체 테이블 조회 리스트
		List<AdminMainVO> array=sqlSessionTemplate.selectList(namespace+".getClientTable",vo);
		
		System.out.println("dao에서 sql동작완료"+ vo + " \n array size :"+array.size() );

		
		return array;
		
		
		
		
	}
}
