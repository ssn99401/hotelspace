package com.spring.hotelspace.client.search.dao;

import java.util.List;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;

public interface ClientSearchRoomDAO {
	public List<ClientRoomVO> searchRoom(ClientRoomVO vo);
	
}
