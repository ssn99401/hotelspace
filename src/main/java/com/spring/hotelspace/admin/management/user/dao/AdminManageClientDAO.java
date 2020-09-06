package com.spring.hotelspace.admin.management.user.dao;

import java.util.ArrayList;
import java.util.List;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientResVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientRevVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

public interface AdminManageClientDAO {

	public List<AdminManageClientVO> getClientTable(AdminManageClientVO vo);
	
	public void getActiveState(ArrayList<AdminManageClientVO> arr);
	public void getBanState(ArrayList<AdminManageClientVO> Narr);

	public AdminManageClientVO getClientInfo(String id);

	public AdminManageClientRevVO getClientRev(String id);

	public AdminManageClientResVO getClientRes(String id);
}
