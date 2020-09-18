package com.spring.hotelspace.client.reservation.dao;

import java.util.List;

import com.spring.hotelspace.client.reservation.vo.ClientReservationInfoVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;


public interface ClientReservationDAO {
	public List<ClientReservationInfoVO> revInfo(ClientReservationInfoVO clientReservationInfoVO);

	public void insertReserv(ClientReservationVO clientReservationVO);

	
}
