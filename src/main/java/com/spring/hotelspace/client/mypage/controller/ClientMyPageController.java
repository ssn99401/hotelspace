package com.spring.hotelspace.client.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.service.ClientMyPageService;

@Controller
public class ClientMyPageController {

	@Autowired
	private ClientMyPageService clientMyPageService;
	
	@RequestMapping (value="/myinfoupdate.do", method=RequestMethod.GET)
	public String mypageupdate(ClientLoginVO loginVO,HttpSession session,Model model) {
		
		
		
		return "mypage/myinfoupdate";
		
	}
	
}
