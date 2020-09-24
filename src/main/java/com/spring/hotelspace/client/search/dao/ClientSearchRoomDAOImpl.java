package com.spring.hotelspace.client.search.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.search.vo.ClientRoomVO;

// 호텔 방 조회관련
@Repository
public class ClientSearchRoomDAOImpl implements ClientSearchRoomDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.client.search.dao.ClientSearchRoomDAO";

	@Override
	public List<ClientRoomVO> searchRoom(ClientRoomVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace + ".searchRoom", vo);
	}
	
	@Override
	public List<ClientRoomVO> searchRoomImage(List<ClientRoomVO> voList) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace + ".getRoomImageList", voList);
	}
	

}
