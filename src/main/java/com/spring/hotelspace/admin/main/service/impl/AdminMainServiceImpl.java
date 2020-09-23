


package com.spring.hotelspace.admin.main.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.admin.main.dao.AdminMainDAO;
import com.spring.hotelspace.admin.main.service.AdminMainService;
import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.main.vo.AdminRecentResVO;
import com.spring.hotelspace.admin.main.vo.AdminRecentRevVO;
import com.spring.hotelspace.admin.main.vo.ReservationDataVO;

@Service
public class AdminMainServiceImpl implements AdminMainService {
	
	@Autowired
	private AdminMainDAO adminMainDAO;

	@Override
	public int gethotelCount() {//호텔 수
		int result=adminMainDAO.gethotelCount();
		System.out.println(result);
		return adminMainDAO.gethotelCount();
	}

	@Override
	public int getresCount() {//예약 건 수
		// TODO Auto-generated method stub
		return adminMainDAO.getresCount();
	}

	@Override
	public int getuserCount() {//유저 수
		// TODO Auto-generated method stub
		return adminMainDAO.getuserCount();
	}

	@Override
	public String getReservation(String month) {
		// TODO Auto-generated method stub
		return adminMainDAO.getReservation(month);
	}

	@Override
	public String getSales(String month) {
		// TODO Auto-generated method stub
		return adminMainDAO.getSales(month);
	}

	@Override
	public String getReservation2019(String month) {
		// TODO Auto-generated method stub
		return adminMainDAO.getReservation2019(month);
	}

	@Override
	public String getSales2019(String month) {
		// TODO Auto-generated method stub
		return adminMainDAO.getSales2019(month);
	}

	@Override
	public ArrayList<ReservationDataVO> getData() {
		// TODO Auto-generated method stub
		return adminMainDAO.getData();
	}

	@Override
	public ArrayList<AdminRecentResVO> getRecentRes() {
		// TODO Auto-generated method stub
		return adminMainDAO.getRecentRes();
	}

	@Override
	public ArrayList<AdminRecentRevVO> getRecentRev() {
		// TODO Auto-generated method stub
		return adminMainDAO.getRecentRev();
	}




	
}
