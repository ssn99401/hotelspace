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
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.client.search.dao.ClientSearchHotelDAO";
	
	// 조회한 호텔리스트 총 갯수
	public int getCountToHotelList(HashMap<Object, Object> map) {
		return sqlSessionTemplate.selectOne(namespace + ".getHotelCount", map);
	}
	
	// 전체 호텔목록 조회
	public List<Object> searchHotelAll(HashMap<Object, Object> map)  {
		return sqlSessionTemplate.selectList(namespace + ".selectHotelListAll", map);
	}
	
	
	// 호텔 리스트 검색(index page)
	public List<Object> searchHotelToSearchBar(HashMap<Object, Object> map) {
		
		return sqlSessionTemplate.selectList(namespace + ".selectHotelToSearchBar", map);
	}

}
