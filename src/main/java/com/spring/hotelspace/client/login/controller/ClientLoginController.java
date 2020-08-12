package com.spring.hotelspace.client.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.common.kakao.KakaoAPI;
import com.fasterxml.jackson.databind.JsonNode;
import com.spring.hotelspace.client.login.service.ClientLoginService;

@Controller
public class ClientLoginController {

	@Autowired
	private ClientLoginService clientLoginService;
	
	@Autowired
    private KakaoAPI kakao;

	@RequestMapping(value = "/clientLogin.do", method = RequestMethod.GET)
	public String getloginPaget(ClientLoginVO client, HttpSession httpSession, Model model) {
		System.out.println("ge");
		httpSession.setAttribute("kakaoURI", "https://kauth.kakao.com/oauth/authorize?client_id=7fe2ea8fb8719474f5388f06fbf3f3ca&redirect_uri=http://localhost:8088/web/kakaoLogin.do&response_type=code");
		return "login/clientLogin";
	}

	@RequestMapping(value = "/clientLogin.do", method = RequestMethod.POST)
	public String loginToClient(ClientLoginVO client, HttpSession httpSession, Model model) {

		System.out.println(client);

		ClientLoginVO resultClient = clientLoginService.getClientLoginResult(client);

		Object destination = httpSession.getAttribute("destination");

		if (resultClient != null) {
			if (resultClient.getClientPassword().equals(client.getClientPassword())) {
				
				httpSession.setAttribute("login", resultClient); // 로그인 성공
			} else {
				model.addAttribute("message", "비밀번호가 맞지 않습니다");// 비밀번호 오류 처리
				return "login/clientLogin";
			}
		} else {
			model.addAttribute("message", "아이디를 확인해 주세요");// 아이디 오류 처리
			return "login/clientLogin";
		}

		return "redirect:" + (destination != null ? (String) destination : "index.do");
	}
	
	
	
	
	
	@RequestMapping(value = "/kakaoLogin.do", method = RequestMethod.GET)
	public String loginToClientbyKakao(@RequestParam("code") String code, HttpSession httpSession, Model model) {
		
		Object destination = httpSession.getAttribute("destination");
		
		System.out.println("code : " + code);
		
		String access_Token = kakao.getAccessToken(code);
		
		System.out.println("controller access_token : " + access_Token);
		
		String id = kakao.getKakaoId(access_Token);
		
		ClientLoginVO resultClient = clientLoginService.compareKakaoId(id);
		
		httpSession.setAttribute("login", resultClient);
		
		return "redirect:" + (destination != null ? (String) destination : "index.do");
	}
	

}