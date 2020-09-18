package com.spring.hotelspace.admin.management.hotel.controller;

import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.admin.management.hotel.service.AdminHotelManagerService;

@Controller
public class AdminHotelManagerController {

	@Autowired
	private AdminHotelManagerService adminHotelManagerService;

	// 페이지 호텔 관리 view
	@RequestMapping(value = "/hotelManagementList.mdo", method =  RequestMethod.GET)
	public String showIndexPage(Model model) {

		return "management/hotel/hotelManagementView";
	}

	// 페이지 호텔 리스트 요청
	@RequestMapping(value = "/hotelList.mdo", method =  RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAdminHotelInfoView(@RequestBody String jsonParam) throws ParseException {
		System.out.println(jsonParam);
		return adminHotelManagerService.getAdminHotelList(jsonParam);
	}

	// 호텔 정보 view
	@RequestMapping(value = "/hotelInfoView.mdo", method =  RequestMethod.GET)
	public String getAdminHotelList(String hotelId,Model model) {
		
		model.addAttribute("hotelId", hotelId);
		return "management/hotel/hotelManagementHotelInfo";
	}

	// 호텔 정보 데이터 요청
	@RequestMapping(value = "/hotelInfo.mdo", method =  RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAdminHotelInfo(@RequestBody String hotelId) throws ParseException {
		Map<String, Object> resultMap = adminHotelManagerService.getAdminHotelInfo(hotelId);
		System.out.println(resultMap);
		return resultMap;
	}
	
	// 호텔 정보 업데이트 요청
	@RequestMapping(value = "/updateHotelInfo.mdo", method =  RequestMethod.POST)
	public @ResponseBody String updateHotelInfo(@RequestBody String jsonParam) throws ParseException {
		
		return "" + adminHotelManagerService.updateHotelInfo(jsonParam);
	}
	
	// 방 정보 업데이트 요청
	@RequestMapping(value = "/updateRoomInfo.mdo", method =  RequestMethod.POST)
	public @ResponseBody String updateRoomInfo(@RequestBody String jsonParam) throws ParseException {
		
		return "" + adminHotelManagerService.updateRoomInfo(jsonParam);
	}

}
