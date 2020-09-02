package com.spring.hotelspace.admin.management.user.service;

import java.util.List;

import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

public interface AdminManageClientService {

	public List<AdminManageClientVO> getClientList(AdminManageClientVO vo);
}
