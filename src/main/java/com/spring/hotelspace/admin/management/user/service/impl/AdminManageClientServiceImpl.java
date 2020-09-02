package com.spring.hotelspace.admin.management.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.management.user.dao.AdminManageClientDAO;
import com.spring.hotelspace.admin.management.user.service.AdminManageClientService;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

@Service
public class AdminManageClientServiceImpl implements AdminManageClientService {
	
	@Autowired
	private AdminManageClientDAO adminManageClientDAO;
	
	public List<AdminManageClientVO> getClientList(AdminManageClientVO vo) {
		System.out.println("서비스 vo받음 " +vo);
		return adminManageClientDAO.getClientTable(vo);
		
	}
	
}
