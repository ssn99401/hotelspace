package com.spring.hotelspace.admin.management.page.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.admin.management.page.service.AdminPageManagerService;
import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

@Controller
public class AdminPageManagerController {
	
	@Autowired
	private AdminPageManagerService adminPageManagerService;
	
	@RequestMapping(value = "/pageManagement.mdo", method =  RequestMethod.GET)
	public String showIndexPage(Model model) {
		
		model.addAttribute("imageList",adminPageManagerService.getImageLinkList());
		
		return "menagement/webViews/managementWebView";
//		return "adminChart";
	}
	
	@RequestMapping(value = "/pageImageList.mdo", method =  RequestMethod.POST)
	public @ResponseBody List<AdminPageImageVO> getImageListToWebPage() {
		List<AdminPageImageVO> list = adminPageManagerService.getImageLinkList();
		System.out.println(list);
		return list;
//		return "adminChart";
	}
	
}
