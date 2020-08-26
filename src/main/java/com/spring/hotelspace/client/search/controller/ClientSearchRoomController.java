package com.spring.hotelspace.client.search.controller;

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
	public String searchRoom(ClientRoomVO vo, Model model) {
		System.out.println(vo.getHotelId());
		model.addAttribute("roomList", clientSearchRoomService.searchRoom(vo));
		return "room/roomInfo";
	}

}
