package com.spring.hotelspace.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMainController {
	
	@RequestMapping(value = "/index.mdo", method =  RequestMethod.GET)
	public String showIndexPage() {

		return "index";
	}
	
}
