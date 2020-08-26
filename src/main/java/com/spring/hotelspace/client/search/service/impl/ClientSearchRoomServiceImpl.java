package com.spring.hotelspace.client.search.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.search.dao.ClientSearchRoomDAO;
import com.spring.hotelspace.client.search.service.ClientSearchRoomService;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;

@Service
public class ClientSearchRoomServiceImpl implements ClientSearchRoomService {

	@Autowired
	private ClientSearchRoomDAO clientSearchRoomDAO;

	@Override
	public List<ClientRoomVO> searchRoom(ClientRoomVO vo) {
		List<ClientRoomVO> o = clientSearchRoomDAO.searchRoom(vo);
		System.out.println(o);
		return o;
	}

}
