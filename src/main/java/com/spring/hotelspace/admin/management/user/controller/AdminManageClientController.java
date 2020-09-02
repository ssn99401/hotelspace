package com.spring.hotelspace.admin.management.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.management.user.service.AdminManageClientService;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

@Controller
public class AdminManageClientController {
	
	@Autowired
	private AdminManageClientService adminManageClientService;
	

	
	
	@RequestMapping(value = "/clientManagement.mdo" , method = RequestMethod.GET)
	public String clientTable(AdminManageClientVO vo,Model model) {
		
		List<AdminManageClientVO>clientList= adminManageClientService.getClientList(vo);
		
		model.addAttribute("clientList", clientList);
		System.out.println("list적재완료" + "list size : "+clientList.size());
		
		return "adminTable";
		
	}
	
}
