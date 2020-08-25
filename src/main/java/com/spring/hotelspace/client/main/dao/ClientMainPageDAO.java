package com.spring.hotelspace.client.main.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.main.vo.MainVO;
import com.spring.hotelspace.client.main.vo.TopHotelVO;

@Repository
public interface ClientMainPageDAO {

	List<MainVO> getMainPageImage();

	List<TopHotelVO> getHotelImage();
	
}
