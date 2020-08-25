package com.spring.hotelspace.admin.management.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.management.user.dao.AdminManageClientDAO;
import com.spring.hotelspace.admin.management.user.service.AdminManageClientService;

@Service
public class AdminManageClientServiceImpl implements AdminManageClientService {
	
	@Autowired
	private AdminManageClientDAO adminManageClientDAO;
	
	
	
}
