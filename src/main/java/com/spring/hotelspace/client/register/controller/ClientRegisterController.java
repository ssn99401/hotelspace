package com.spring.hotelspace.client.register.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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

	//회원가입 폼
	@RequestMapping(value = "Register.do", method = { RequestMethod.GET, RequestMethod.POST})
	public String RegisterForm() {
		return "register/Register";
	}
	
	//회원가입 insert
	@RequestMapping(value = "RegisterInsert.do" , method ={ RequestMethod.GET, RequestMethod.POST})
	public String RegisterInsert(ClientRegisterVO vo , Model model) {
		clientRegisterService.RegisterInsert(vo);
		return "index";
	}
	
		
	//아이디 중복체크
	@RequestMapping(value = "checkId.do", method = { RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody int checkId(HttpServletRequest request, Model model) {
        //return clientRegisterService.checkId(regvo);
		
		
		ClientRegisterVO regvo1 = new ClientRegisterVO();
		
		regvo1.setClientId(request.getParameter("id"));
		System.out.println(regvo1.getClientId());
		int result = clientRegisterService.checkId(regvo1);
		return result;
    }//

}
