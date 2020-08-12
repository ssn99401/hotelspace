package com.spring.hotelspace.client.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientMainPageController {

	@RequestMapping(value = "/index.do", method =  RequestMethod.GET)
	public String showIndexPage() {

		return "index";
	}

	@RequestMapping(value = "/clientFAQServices.do", method = RequestMethod.GET)
	public String blog_detailsPage() {
		return "board/clientFAQServices";
	}
	@RequestMapping(value = "/clientHeader.do", method = RequestMethod.GET)
	public String clientHeader() {
		return "clientHeader";
	}
	@RequestMapping(value = "/clientFooter.do", method = RequestMethod.GET)
	public String clientFooter() {
		return "clientFooter";
	}
}
