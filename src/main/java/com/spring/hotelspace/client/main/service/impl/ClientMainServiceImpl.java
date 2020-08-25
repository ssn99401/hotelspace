package com.spring.hotelspace.client.main.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.main.dao.ClientMainPageDAO;
import com.spring.hotelspace.client.main.service.ClientMainService;
import com.spring.hotelspace.client.main.vo.MainVO;
import com.spring.hotelspace.client.main.vo.TopHotelVO;

@Service
public class ClientMainServiceImpl implements ClientMainService {
	
	@Autowired
	private ClientMainPageDAO clientMainPageDAO;

	public List<MainVO> getMainPageImage() {

		return clientMainPageDAO.getMainPageImage();
	}

	@Override
	public List<TopHotelVO> getHotelImage() {
		// TODO Auto-generated method stub
		return clientMainPageDAO.getHotelImage();
	}
	
	
	
}
