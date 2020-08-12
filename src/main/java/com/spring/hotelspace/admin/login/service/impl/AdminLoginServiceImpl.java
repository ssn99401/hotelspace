package com.spring.hotelspace.admin.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.login.dao.AdminLoginDAO;
import com.spring.hotelspace.admin.login.vo.AdminLoginVO;
import com.spring.hotelspace.admin.login.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private AdminLoginDAO adminLoginDAO;
	
	@Override
	public int getAdminLoginResult(AdminLoginVO admin) {
		return adminLoginDAO.getAdminLoginResult(admin);
	}
}
