package com.spring.hotelspace.admin.main.service;

import java.util.List;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;

public interface AdminMainService {
	
	public List<AdminMainVO> getClientList(AdminMainVO vo);
}
