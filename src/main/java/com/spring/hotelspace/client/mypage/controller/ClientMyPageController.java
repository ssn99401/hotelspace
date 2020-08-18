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
	
	@RequestMapping (value="/updateaction.do", method=RequestMethod.POST)
	public String getpageupdate(ClientLoginVO loginVO,HttpSession session,Model model) {
		System.out.println(loginVO);
		int aa= clientMyPageService.updateAction(loginVO);
		System.out.println("update data count : "+ aa);
		session.setAttribute("login", loginVO);
		clientMyPageService.searchAll(loginVO);
		return "mypage/mypage";
		
	}
	
}
