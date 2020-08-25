package com.spring.hotelspace.admin.management.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.hotelspace.admin.management.user.service.AdminManageClientService;

@Controller
public class AdminManageClientController {
	
	@Autowired
	private AdminManageClientService adminManageClientService;
	
	
	
}
