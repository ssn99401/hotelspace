package com.spring.hotelspace.client.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.hotelspace.client.mypage.service.ClientMyPageService;

@Controller
public class ClientMyPageController {

	@Autowired
	private ClientMyPageService clientMyPageService;
	
}
