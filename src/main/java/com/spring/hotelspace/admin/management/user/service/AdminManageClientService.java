package com.spring.hotelspace.admin.management.user.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

public interface AdminManageClientService {

	public List<AdminManageClientVO> getClientList(AdminManageClientVO vo);
	
	/*public void getActiveState(ArrayList<AdminManageClientVO> arr);

	public void getBanState(ArrayList<AdminManageClientVO> arr);*/

	public void getState(ArrayList<AdminManageClientVO> arr, ArrayList<AdminManageClientVO> Narr,AdminManageClientVO vo);
}
