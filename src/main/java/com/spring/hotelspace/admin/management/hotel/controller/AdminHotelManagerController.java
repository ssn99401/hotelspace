package com.spring.hotelspace.admin.management.hotel.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	// 호텔 등록 view
	@RequestMapping(value = "/hotelRegisterView.mdo", method =  RequestMethod.GET)
	public String getAdminHotelRegisterView() {

		return "management/hotel/hotelRegisterView";
	}

	// 호텔 이미지 업로드 처리
	@RequestMapping(value = "/uploadHotelImage.mdo", method =  RequestMethod.POST)
	public @ResponseBody String uploadHotelImage(MultipartHttpServletRequest files) throws IOException, Exception {

		return adminHotelManagerService.uploadHotelImage(files);
	}

	// 호텔 등록 요청 처리
	@RequestMapping(value = "/uploadHotel.mdo", method =  RequestMethod.POST)
	public @ResponseBody int uploadHotel(@RequestBody String jsonParam) throws ParseException {

		return adminHotelManagerService.uploadHotel(jsonParam);
	}


	// 방 등록 view
	@RequestMapping(value = "/roomRegisterView.mdo", method =  RequestMethod.GET)
	public String getAdminRoomRegisterView(Model model, HttpServletRequest request) {
		model.addAttribute("hotelId", request.getParameter("hotelId"));
		return "management/hotel/roomRegisterView";
	}

	// 방 이미지 업로드 처리
	@RequestMapping(value = "/uploadRoomImage.mdo", method =  RequestMethod.POST)
	public @ResponseBody String uploadRoomImage(MultipartHttpServletRequest files) throws IOException, Exception {
		
		return adminHotelManagerService.uploadRoomImage(files);
	}

	// 방 등록 요청 처리
	@RequestMapping(value = "/uploadRoom.mdo", method =  RequestMethod.POST)
	public @ResponseBody int uploadRoom(@RequestBody String jsonParam) throws ParseException {

		return adminHotelManagerService.uploadRoom(jsonParam);
	}
	
	// 호텔 삭제 요청 처리 컨트롤러
	@RequestMapping(value = "/deleteHotel.mdo", method =  RequestMethod.POST)
	public @ResponseBody int deleteHotel(@RequestBody String jsonParam) throws ParseException {

		return adminHotelManagerService.deleteHotel(jsonParam);
	}
	
	// 방 삭제 요청 처리 컨트롤러
	@RequestMapping(value = "/deleteRoom.mdo", method =  RequestMethod.POST)
	public @ResponseBody int deleteRoom(@RequestBody String jsonParam) throws ParseException {

		return adminHotelManagerService.deleteRoom(jsonParam);
	}
	
}
