package com.spring.hotelspace.client.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.reservation.dao.ClientReservationDAO;
import com.spring.hotelspace.client.reservation.service.ClientReservationService;

@Service
public class ClientReservationServiceImpl implements ClientReservationService {
	
	@Autowired
	ClientReservationDAO clientReservationDAO;
	
	
	
}
