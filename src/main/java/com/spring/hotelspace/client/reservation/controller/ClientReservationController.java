package com.spring.hotelspace.client.reservation.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String revInfo(ClientReservationInfoVO clientReservationInfoVO, Model model, HttpServletRequest http,
			HttpSession httpSession) {
		http.getParameter("reservationInDate");
		http.getParameter("reservationOutDate");
		httpSession.getAttribute("login");

		clientReservationInfoVO.setReservationInDate(http.getParameter("reservationInDate"));
		clientReservationInfoVO.setReservationOutDate(http.getParameter("reservationOutDate"));
		model.addAttribute("revList", clientReservationService.revInfo(clientReservationInfoVO));
		System.out.println("컨트롤러" + model.getAttribute("revList"));
		return "reservation/reservationInfo";

	}

	@RequestMapping(value = "insertReserv.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertReserv(ClientReservationVO clientReservationVO, HttpServletRequest http,
			HttpSession httpSession, HttpServletRequest request) {
System.out.println("ddddddddddddddddddddddddddddd");
		Map<String, Object> map = getParameterMap2(request);
		String clientId = (String) map.get("clientId");
		String roomId = (String) map.get("roomId");
		String hotelId = (String) map.get("hotelId");
		String reservationInDate = (String) map.get("reservationInDate");
		String reservationOutDate = (String) map.get("reservationOutDate");
		String reservationPayment2 = (String) map.get("reservationPayment");
		int reservationPayment = Integer.parseInt(reservationPayment2);
		String reservationPeople2 = (String) map.get("reservationPeople");
		int reservationPeople = Integer.parseInt(reservationPeople2);

		System.out.println(clientId);
		System.out.println(roomId);
		System.out.println(hotelId);
		System.out.println(reservationInDate);
		System.out.println(reservationOutDate);
		System.out.println(reservationPayment);
		System.out.println(reservationPeople);
		clientReservationVO.setClientId(clientId);
		clientReservationVO.setRoomId(roomId);
		clientReservationVO.setHotelId(hotelId);
		clientReservationVO.setReservationInDate(reservationInDate);
		clientReservationVO.setReservationOutDate(reservationOutDate);
		clientReservationVO.setReservationPayment(reservationPayment);
		clientReservationVO.setReservationPeople(reservationPeople);
		System.out.println(clientReservationVO);

		clientReservationService.insertReserv(clientReservationVO);
		System.out.println("ddddddddddd");
		return "redirect:index.do";
	}
	
	
	

	protected Map<String, Object> getParameterMap2(HttpServletRequest req) {
		Map<String, Object> map = new HashMap();

		Enumeration enm = req.getParameterNames();

		String name = null;
		String value = null;
		String[] arr = null;

		while (enm.hasMoreElements()) {
			name = (String) enm.nextElement();
			arr = req.getParameterValues(name);

			if (name.startsWith("arr")) {
				map.put(name, arr);
			} else {
				if (arr != null && arr.length > 0) {
					value = arr[0];
				} else {
					value = req.getParameter(name);
				}

				map.put(name, value);
			}
		}

		return map;
	}

}
