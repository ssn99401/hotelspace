package com.spring.hotelspace.client.main.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hotelspace.client.main.service.ClientMainService;
import com.spring.hotelspace.client.main.vo.MainVO;
import com.spring.hotelspace.client.main.vo.TopHotelVO;

@Controller
public class ClientMainPageController {

	@Autowired
	private ClientMainService clientMainService;

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String showIndexPage(Model model) {
		List<MainVO> list = clientMainService.getMainPageImage();
		HashMap<String , String> image = new HashMap<String, String>();
		for(MainVO e : list) {
			image.put(e.getImageType(), e.getImageLink());
		}
		
		List<TopHotelVO> hotelimage = clientMainService.getHotelImage();
		model.addAttribute("image", image);
		model.addAttribute("hotel", hotelimage);
		
		return "index";
	}

	@RequestMapping(value = "/clientFAQServices.do", method = RequestMethod.GET)
	public String blog_detailsPage() {
		return "board/clientFAQServices";
	}

	@RequestMapping(value = "/clientHeader.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String clientHeader() {
		return "clientHeader";
	}

	@RequestMapping(value = "/clientFooter.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String clientFooter() {
		return "clientFooter";
	}
}
