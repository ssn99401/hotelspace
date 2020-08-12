package com.spring.hotelspace.client.search.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.client.search.service.ClientSearchHotelService;

@Controller
public class ClientSearchHotelController {
	
	@Autowired
	private ClientSearchHotelService clientSearchHotelService;
	
	@RequestMapping(value = "testsearchhotel.do", method = RequestMethod.GET)
	public String test(HttpServletRequest request ,Model model) {
		
		HashMap<Object, Object> map = new HashMap<>();
		
		map.put("searchKeyword", request.getParameter("searchKeyword"));
		map.put("checkIdDate", request.getParameter("checkInDate"));
		map.put("checkOutDate", request.getParameter("checkOutDate"));
		map.put("people", request.getParameter("people"));
		
		model.addAttribute("hotelList",clientSearchHotelService.searchHotelToKeywordAndDate(map));
		return "hotel/clientHotel";
	}
	
	@RequestMapping(value = "searchHotelAll.do", method = RequestMethod.GET)
	public String searchHotelAll(Model model) {
		
		model.addAttribute("hotelList", clientSearchHotelService.searchHotelAll());
		
		return "hotel/clientHotel";
	}
	
}
