package com.spring.hotelspace.admin.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.admin.login.vo.AdminLoginVO;
import com.spring.hotelspace.admin.login.service.AdminLoginService;


@Controller
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	@RequestMapping(value = "adminLogin.mdo", method = RequestMethod.GET)
	public String getloginPaget(AdminLoginVO admin, Model model) {
		return "adminLogin";
	}

	@RequestMapping(value = "adminLogin.mdo", method = RequestMethod.POST)
	public String loginToClient(AdminLoginVO admin, Model model) {

		int result = adminLoginService.getAdminLoginResult(admin);
		model.addAttribute("result",  result);

		return "adminMain";
	}
}
