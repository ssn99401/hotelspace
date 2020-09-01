package com.spring.hotelspace.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMainController {
	
	@RequestMapping(value = "/index.mdo", method =  RequestMethod.GET)
	public String showIndexPage() {

		return "adminIndex";
	}
	
	@RequestMapping(value = "/main.mdo", method =  RequestMethod.GET)
	public String getMainPage(Model model) {
		
		return "main";
	}
	
	@RequestMapping(value = "/navbar.mdo", method =  RequestMethod.GET)
	public String getNavBar(Model model) {
		
		return "adminNavBar";
	}
	
	@RequestMapping(value = "/sidebar.mdo", method =  RequestMethod.GET)
	public String getsideBar(Model model) {
		
		return "adminSideBar";
	}
	
	@RequestMapping(value = "/footer.mdo", method =  RequestMethod.GET)
	public String getFooter(Model model) {
		
		return "adminFooter";
	}
}
