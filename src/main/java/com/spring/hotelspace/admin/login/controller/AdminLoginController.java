package com.spring.hotelspace.admin.login.controller;

import javax.servlet.http.HttpSession;

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
		return "login/adminLogin";
	}

	@RequestMapping(value = "adminLogin.mdo", method = RequestMethod.POST)
	public String loginToClient(AdminLoginVO admin, HttpSession httpSession, Model model) {

		AdminLoginVO resultVO = adminLoginService.getAdminLoginResult(admin);
		System.out.println("admin : "+admin);
		System.out.println("res" + resultVO);
		Object destination = httpSession.getAttribute("adminDestination");

		if (resultVO != null) {
			if (resultVO.getPassword().equals(admin.getPassword())) {
				resultVO.setPassword("");
				httpSession.setAttribute("adminLogin", resultVO); // 로그인 성공
			} else {
				model.addAttribute("message", "아이디 혹은 비밀번호가 틀렸습니다.");// 아이디 오류 처리 // 비밀번호 오류 처리
				return "login/adminLogin";
			}
		} else {
			model.addAttribute("message", "아이디 혹은 비밀번호가 틀렸습니다.");// 아이디 오류 처리 // 비밀번호 오류 처리
			return "login/adminLogin";
		}

		return "redirect:" + (destination != null ? (String) destination : "index.mdo");
	}
	
	
}
