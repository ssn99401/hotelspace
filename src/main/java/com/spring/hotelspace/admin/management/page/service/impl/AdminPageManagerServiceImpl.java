package com.spring.hotelspace.admin.management.page.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.management.page.dao.AdminPageManagerDAO;
import com.spring.hotelspace.admin.management.page.service.AdminPageManagerService;
import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

@Service
public class AdminPageManagerServiceImpl implements AdminPageManagerService {
	
	@Autowired
	private AdminPageManagerDAO adminPageManagerDAO;
	
	// 웹 화면 이미지 리스트 반환 메서드
	public List<AdminPageImageVO> getImageLinkList() {
		List<AdminPageImageVO> list = adminPageManagerDAO.getImageLinkList();
			
		return list;
	}

	
}
