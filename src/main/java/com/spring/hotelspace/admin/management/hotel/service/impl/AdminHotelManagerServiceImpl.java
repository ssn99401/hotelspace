package com.spring.hotelspace.admin.management.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hotelspace.admin.management.hotel.dao.AdminHotelManagerDAO;
import com.spring.hotelspace.admin.management.hotel.service.AdminHotelManagerService;
import com.spring.hotelspace.admin.management.hotel.vo.AdminHotelVO;
import com.spring.hotelspace.admin.management.hotel.vo.AdminRoomVO;

@Service
public class AdminHotelManagerServiceImpl implements AdminHotelManagerService {

	@Autowired
	private AdminHotelManagerDAO adminHotelManagerDAO;

	private final static int pageBlock = 2;

	// 관리자 호텔목록 조회  메서드
	@Transactional
	public Map<String, Object> getAdminHotelList(String jsonParam) throws ParseException {

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);

		int pageNum = Integer.parseInt((String)jsonObject.get("pageNum"));
		int pageSize = Integer.parseInt((String)jsonObject.get("pageSize"));
		Map<String, String> requestMap = new HashMap<String, String>();

		requestMap.put("hotelName", jsonObject.get("hotelName") != null ? (String) jsonObject.get("hotelName") : null );
		requestMap.put("hotelAddress", jsonObject.get("hotelAddress") != null ? (String) jsonObject.get("hotelAddress") : null );
		requestMap.put("hotelClientId", jsonObject.get("hotelClientId") != null ? (String) jsonObject.get("hotelClientId") : null );
		requestMap.put("orderbyOption", jsonObject.get("orderbyOption") != null ? (String) jsonObject.get("orderbyOption") : null );
		requestMap.put("orderbyId", jsonObject.get("orderbyId") != null ? (String) jsonObject.get("orderbyId") : null );
		requestMap.put("orderbyArea", jsonObject.get("orderbyArea") != null ? (String) jsonObject.get("orderbyArea") : null );
		requestMap.put("orderbyStar", jsonObject.get("orderbyStar") != null ? (String) jsonObject.get("orderbyStar") : null );
		requestMap.put("start", ""+ (pageSize * (pageNum - 1) + 1));
		requestMap.put("end", "" + (pageSize * pageNum));

		System.out.println("requestMap : " + requestMap);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("hotelList", adminHotelManagerDAO.getAdminHotelList(requestMap));
		resultMap.put("count", adminHotelManagerDAO.getAdminHotelListCount(requestMap));
		resultMap.put("pageBlock",pageBlock);
		resultMap.put("pageNum", pageNum);
		resultMap.put("pageSize", pageSize);
		resultMap.put("pageBlock", pageBlock);
		System.out.println(resultMap);
		return resultMap;
	}

	// 관리자 호텔 정보 조회 메서드
	@Transactional
	public Map<String, Object> getAdminHotelInfo(String jsonParam) throws ParseException {

		String hotelId = (String)((JSONObject) new JSONParser().parse(jsonParam)).get("hotelId");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AdminRoomVO> hotelRoomList = null;

		resultMap.put("hotelInfo", adminHotelManagerDAO.getAdminHotelInfo(hotelId));
		resultMap.put("hotelPictures", adminHotelManagerDAO.getAdminHotelImageList(hotelId));
		
		hotelRoomList = adminHotelManagerDAO.getAdminRoomList(hotelId);
		
		resultMap.put("hotelRoomList", hotelRoomList);
		resultMap.put("roomPictures", adminHotelManagerDAO.getAdminRoomImageList(hotelRoomList));
		return resultMap;
	}

	// 호텔 정보 업데이트 요청
	public int updateHotelInfo(String jsonParam) throws ParseException  {
		System.out.println(jsonParam);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("hotelId", jsonObject.get("hotelId") != null ? (String) jsonObject.get("hotelId") : null );
		requestMap.put("target", jsonObject.get("target") != null ? (String) jsonObject.get("target") : null );
		requestMap.put("newValue", jsonObject.get("newValue") != null ? (String) jsonObject.get("newValue") : null );
		
		return adminHotelManagerDAO.updateHotelInfo(requestMap);
	}

	// 방 정보 업데이트 요청
	public int updateRoomInfo(String jsonParam) throws ParseException  {
		System.out.println(jsonParam);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("roomId", jsonObject.get("roomId") != null ? (String) jsonObject.get("roomId") : null );
		requestMap.put("target", jsonObject.get("target") != null ? (String) jsonObject.get("target") : null );
		requestMap.put("newValue", jsonObject.get("newValue") != null ? (String) jsonObject.get("newValue") : null );
		
		return adminHotelManagerDAO.updateRoomInfo(requestMap);
	}

}
