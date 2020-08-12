package com.spring.hotelspace.client.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.hotelspace.client.board.service.ClientQNAService;

@Controller
public class ClientQNAController {
	
	@Autowired
	private ClientQNAService clientQNAService;
	
}
