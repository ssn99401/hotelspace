package com.spring.hotelspace.admin.management.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.hotelspace.admin.management.user.vo.AdminManageClientResVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientRevVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

public interface AdminManageClientService {

	public List<AdminManageClientVO> getClientList(AdminManageClientVO vo);

	public void getState(ArrayList<AdminManageClientVO> arr, ArrayList<AdminManageClientVO> Narr,AdminManageClientVO vo);

	public AdminManageClientVO getClientInfo(String id);

	public List<AdminManageClientRevVO> getClientRev(String id);
	
	public List<AdminManageClientResVO> getClientRes(String id);
	
	public List<AdminManageClientVO> getSearchIdList(String user);
	public List<AdminManageClientVO> getSearchNameList(String user);

	public void deleteReivew(String id);
}
