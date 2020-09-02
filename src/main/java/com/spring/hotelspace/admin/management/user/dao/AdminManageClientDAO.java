package com.spring.hotelspace.admin.management.user.dao;

import java.util.List;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

public interface AdminManageClientDAO {

	public List<AdminManageClientVO> getClientTable(AdminManageClientVO vo);
}
