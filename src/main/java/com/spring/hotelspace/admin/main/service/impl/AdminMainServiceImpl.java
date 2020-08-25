package com.spring.hotelspace.admin.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.main.dao.AdminMainDAO;
import com.spring.hotelspace.admin.main.service.AdminMainService;

@Service
public class AdminMainServiceImpl implements AdminMainService {
	
	@Autowired
	private AdminMainDAO adminMainDAO;
	
	
}
