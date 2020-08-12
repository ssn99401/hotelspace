package com.spring.hotelspace.client.search.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.search.vo.ClientHotelVO;

@Repository
// 호텔 목록 조회, 검색
public class ClientSearchHotelDAOImpl implements ClientSearchHotelDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.search.dao.ClientSearchHotelDAO";
	
	// 전체 호텔목록 조회
	public List<ClientHotelVO> searchHotelAll()  {
		return sqlSessionTemplate.selectList(namespace + ".selectHotelListAll", null);
	}
	
	
	// 검색바 호텔조회 - 호텔이름, 체크인, 아웃
	public List<Object> searchHotelToNameAndDate(HashMap<Object, Object> request) {
		return sqlSessionTemplate.selectList(namespace + ".selectHotelToNameAndDateList", request);
	}
}
