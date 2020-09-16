package com.spring.hotelspace.admin.management.user.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientResVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientRevVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

public interface AdminManageClientDAO {



	public List<AdminManageClientVO> getClientTable(AdminManageClientVO vo);
	public List<AdminManageClientVO> getSearchId(String user);
	public List<AdminManageClientVO> getSearchName(String user);
	public void getActiveState(ArrayList<AdminManageClientVO> arr);
	public void getBanState(ArrayList<AdminManageClientVO> Narr);

	public AdminManageClientVO getClientInfo(String id);

	public List<AdminManageClientRevVO> getClientRev(String id);

	public List<AdminManageClientResVO> getClientRes(String id);
	public void deleteReview(String id);
	
}
