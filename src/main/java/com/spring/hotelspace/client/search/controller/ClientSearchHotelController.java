package com.spring.hotelspace.client.search.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.client.search.service.ClientSearchHotelService;
import com.spring.hotelspace.client.search.vo.ClientHotelFilterDTO;
import com.spring.hotelspace.client.search.vo.ClientSearchHotelDTO;

@Controller
public class ClientSearchHotelController {

	@Autowired
	private ClientSearchHotelService clientSearchHotelService;

	// 메인 화면 호텔 리스트 조회
	@RequestMapping(value = "searchHotelToIndex.do", method = RequestMethod.GET)
	public String searchHotelToIndex(ClientSearchHotelDTO requestDTO, HttpSession httpSession, Model model) {

		// 쿼리 내용 저장
		httpSession.setAttribute("hotelSearchMethod", requestDTO);


		return "hotel/clientHotel";
	}

	// 메인화면 호텔 전체 리스트 조회
	@RequestMapping(value = "searchHotelAll.do", method = RequestMethod.GET)
	public String searchHotelAll(ClientSearchHotelDTO requestDTO, HttpSession httpSession, Model model) {

		// 쿼리 내용 저장	
		httpSession.setAttribute("hotelSearchMethod", "hotelListAll");

		return "hotel/clientHotel";
	}

	// 호텔 컨셉별 조회
	@RequestMapping(value = "searchHotelToConcept.do", method = RequestMethod.POST)
	public String searchHotelToConcept(@RequestBody ClientHotelFilterDTO hotelFillter, HttpSession httpSession) {

		// 쿼리 내용 저장	
		httpSession.setAttribute("hotelSearchMethod", "hotelListAll");
		return "hotel/clientHotel";

	}


	// 호텔 리스트 검색바로 호텔 조회
	@RequestMapping(value = "searhHotelToBar.do", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> searchHotelToSearchBar(@RequestBody ClientSearchHotelDTO requestDTO, HttpSession httpSession) {

		// 쿼리 내용 저장
		httpSession.setAttribute("hotelSearchMethod", requestDTO);

		// 필터 설정 no
		httpSession.setAttribute("filter", "no");
		HashMap<String, Object> map = clientSearchHotelService.searchHotelToSearchBar(requestDTO);

		return map;

	}

	// 호텔 리스트 조회
	@RequestMapping(value = "searchHotelList.do", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> fillteringToHotelList(@RequestBody ClientHotelFilterDTO hotelFillter,  HttpSession httpSession) {

		// 필터 적용
		httpSession.setAttribute("filter", "yes");
		HashMap<String, Object> map = clientSearchHotelService.searchHotelList(hotelFillter, httpSession.getAttribute("hotelSearchMethod"));
		return map;

	}

	// 호텔 리스트 페이지 이동
	@RequestMapping(value = "movePage.do", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> movePageToHotelList(@RequestBody ClientHotelFilterDTO hotelFilter, HttpSession httpSession) {

		HashMap<String, Object> map = clientSearchHotelService.movePageToHotelList(hotelFilter, httpSession.getAttribute("hotelSearchMethod"), (String)httpSession.getAttribute("filter"));
		return map;
	}

}
