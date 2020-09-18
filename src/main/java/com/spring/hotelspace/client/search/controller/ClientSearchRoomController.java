package com.spring.hotelspace.client.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.client.search.service.ClientSearchRoomService;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;

@Controller
public class ClientSearchRoomController {

	@Autowired
	private ClientSearchRoomService clientSearchRoomService;

	@RequestMapping(value = "searchRoom.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchRoom(ClientRoomVO vo, Model model , HttpServletRequest http, HttpSession httpSession) {
		//Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(http.getParameter("hotelId"));
		System.out.println(http.getParameter("reservationInDate"));
		httpSession.getAttribute("clientId");
		
		//List<ClientRoomVO> roomImage;
		//roomImage = (List<ClientRoomVO>) map.put("roomImage", clientSearchRoomService.selectImage(vo));
		//System.out.println(roomImage+"roomImage");
		vo.setReservationInDate(http.getParameter("reservationInDate"));
		vo.setReservationOutDate(http.getParameter("reservationOutDate"));
		System.out.println(vo.getHotelId());
		System.out.println(vo);
		System.out.println(vo.getReservationInDate());
		System.out.println(vo.getImageLink());
		//model.addAttribute("roomImage",roomImage);
		model.addAttribute("roomList", clientSearchRoomService.searchRoom(vo));
		
	
		return "room/roomInfo";
	}
	
	
	

}
