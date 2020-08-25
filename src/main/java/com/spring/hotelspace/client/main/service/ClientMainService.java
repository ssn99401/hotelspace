package com.spring.hotelspace.client.main.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.main.vo.MainVO;
import com.spring.hotelspace.client.main.vo.TopHotelVO;

public interface ClientMainService {
	public List<MainVO> getMainPageImage();

	public List<TopHotelVO> getHotelImage();
}
