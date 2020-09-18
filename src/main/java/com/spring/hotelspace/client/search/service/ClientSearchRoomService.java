package com.spring.hotelspace.client.search.service;

import java.util.List;

import com.spring.hotelspace.client.search.vo.ClientRoomVO;

public interface ClientSearchRoomService {
	public List<ClientRoomVO> searchRoom(ClientRoomVO vo);
	
}
