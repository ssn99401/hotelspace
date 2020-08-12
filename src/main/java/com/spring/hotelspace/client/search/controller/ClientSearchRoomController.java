package com.spring.hotelspace.client.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.hotelspace.client.search.service.ClientSearchRoomService;

@Controller
public class ClientSearchRoomController {
	
	@Autowired
	private ClientSearchRoomService clientSearchRoomService;
	
	
	
}
