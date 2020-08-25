package com.spring.hotelspace.admin.management.page.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

public interface AdminPageManagerService {
	
	// 웹 화면 이미지 리스트 반환 메서드
	public List<AdminPageImageVO> getImageLinkList();
	
}
