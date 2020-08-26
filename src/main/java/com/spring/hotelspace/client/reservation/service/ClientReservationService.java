package com.spring.hotelspace.client.reservation.service;

import java.util.List;

import com.spring.hotelspace.client.reservation.vo.ClientReservationInfoVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;


public interface ClientReservationService {
	public List<ClientReservationInfoVO> revInfo(ClientReservationInfoVO clientReservationInfoVO);
	public void insertReserv(ClientReservationVO clientReservationVO);
}
