package com.spring.hotelspace.client.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.client.reservation.service.ClientReservationService;
import com.spring.hotelspace.client.reservation.vo.ClientReservationInfoVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;

@Controller
public class ClientReservationController {

	@Autowired
	ClientReservationService clientReservationService;

	@RequestMapping(value = "revInfo.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String revInfo(ClientReservationInfoVO clientReservationInfoVO, Model model) {
		model.addAttribute("revList", clientReservationService.revInfo(clientReservationInfoVO));
		System.out.println("컨트롤러"+model.getAttribute("revList"));
		return "reservation/reservationInfo";

	}

	@RequestMapping(value = "insertReserv.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertRev(ClientReservationVO clientReservationVO) {
		clientReservationService.insertReserv(clientReservationVO);
		return "index";
	}

}
