package com.spring.hotelspace.client.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.reservation.dao.ClientReservationDAO;
import com.spring.hotelspace.client.reservation.service.ClientReservationService;
import com.spring.hotelspace.client.reservation.vo.ClientReservationInfoVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;


@Service
public class ClientReservationServiceImpl implements ClientReservationService {

	@Autowired
	ClientReservationDAO clientReservationDAO;

	@Override
	public void insertReserv(ClientReservationVO clientReservationVO) {
		// TODO Auto-generated method stub
		clientReservationDAO.insertReserv(clientReservationVO);
	}

	@Override
	public List<ClientReservationInfoVO> revInfo(ClientReservationInfoVO clientReservationInfoVO) {
		// TODO Auto-generated method stub
		List<ClientReservationInfoVO> o = clientReservationDAO.revInfo(clientReservationInfoVO);
		System.out.println("serviceImpl"+o);
		return o;
	}

	

}
