package com.spring.hotelspace.client.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.hotelspace.client.reservation.service.ClientReservationService;

@Controller
public class ClientReservationController {
	
	@Autowired
	ClientReservationService clientReservationService;
	
	
}
