package com.spring.hotelspace.admin.main.dao;

import java.util.List;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;

public interface AdminMainDAO {

	public List<AdminMainVO> getClientTable(AdminMainVO vo);
}
