package com.spring.hotelspace.admin.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.admin.main.service.AdminMainService;
import com.spring.hotelspace.admin.main.vo.AdminMainVO;

@Controller
public class AdminMainController {

	@Autowired
	AdminMainService adminmainservice;
	
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
	
	
	
	@RequestMapping(value = "/clientManagement.mdo" , method = RequestMethod.GET)
	public String clientTable(AdminMainVO vo,Model model) {
		
		List<AdminMainVO>clientList= adminmainservice.getClientList(vo);
		
		model.addAttribute("clientList", clientList);
		System.out.println("list적재완료" + "list size : "+clientList.size());
		
		return "adminTable";
		
	}
	
}
