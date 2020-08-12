package com.spring.hotelspace.client.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.client.register.service.ClientRegisterService;
import com.spring.hotelspace.client.register.vo.ClientRegisterVO;

@Controller
public class ClientRegisterController {
	
	@Autowired
	private ClientRegisterService clientRegisterService;
	@Autowired
	public ClientRegisterService service;
	
	@RequestMapping(value = "/Register.do", method = RequestMethod.GET)
	public String RegisterForm() {
		return "register/Register";
	}
	@RequestMapping(value = "/RegisterInsert.do" , method =RequestMethod.GET)
	public String RegisterInsert(ClientRegisterVO vo) {
		service.RegisterInsert(vo);
		return "index";
	}
	@RequestMapping(value = "checkId.do", method = { RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody int idCheck(ClientRegisterVO regvo, Model model) {
        return service.checkId(regvo);
    }//

}
