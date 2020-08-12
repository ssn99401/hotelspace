package com.spring.hotelspace.client.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.hotelspace.client.board.service.ClientFAQService;

@Controller
public class ClientFAQController {
	
	@Autowired
	private ClientFAQService clientFAQService;
	
}
