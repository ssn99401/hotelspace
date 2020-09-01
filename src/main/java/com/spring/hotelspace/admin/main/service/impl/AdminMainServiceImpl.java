package com.spring.hotelspace.admin.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.xs.LSInputList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.main.dao.AdminMainDAO;
import com.spring.hotelspace.admin.main.service.AdminMainService;
import com.spring.hotelspace.admin.main.vo.AdminMainVO;

@Service
public class AdminMainServiceImpl implements AdminMainService {
	
	@Autowired
	private AdminMainDAO adminMainDAO;
	
	public List<AdminMainVO> getClientList(AdminMainVO vo) {
		System.out.println("서비스 vo받음 " +vo);
		return adminMainDAO.getClientTable(vo);
		
	}
	
	
}
