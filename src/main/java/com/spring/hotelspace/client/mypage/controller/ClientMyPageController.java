package com.spring.hotelspace.client.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.service.ClientMyPageService;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;

@Controller
public class ClientMyPageController {

	@Autowired
	private ClientMyPageService clientMyPageService;
	
	@RequestMapping (value="/myinfoUpdate.do", method=RequestMethod.POST)
	public String mypageupdate(ClientLoginVO loginVO,HttpSession session,Model model) {
		
		
		
		return "mypage/myinfoupdate";
		
	}
	
	@RequestMapping (value="/mypageUpdate.do", method=RequestMethod.POST)
	public String getpageupdate(ClientLoginVO loginVO,HttpSession session,Model model) {
		System.out.println(loginVO);
		int aa= clientMyPageService.updateAction(loginVO);
		System.out.println("update data count : "+ aa);
		session.setAttribute("login", loginVO);
		clientMyPageService.searchAll(loginVO);
		return "redirect:clientMypage.do";
		
	}
	
	   @RequestMapping(value = "/pwChangeForm.do", method= {RequestMethod.GET, RequestMethod.POST}) 
	      public String pwChangeForm(ClientMyPageVO client, HttpSession httpSession, Model model) {

	         return "mypage/pwChange";
	   }
	
	   @RequestMapping(value="/pwChange.do", method = RequestMethod.POST)
	      public String pwChange(ClientMyPageVO client, HttpSession httpSession, Model model) {
	      
	      //비밀번호 변경
	      int a = clientMyPageService.changePW(client);
	      
	      return "redirect:clientMypage.do";
	   }

	   //비밀번호 중복체크
	   @RequestMapping(value = "checkPw.do", method = { RequestMethod.GET, RequestMethod.POST})
	    public @ResponseBody int checkId(HttpServletRequest request, Model model) {
	        //return clientRegisterService.checkId(regvo);
	      
	      
	      ClientMyPageVO myPagevo1 = new ClientMyPageVO();
	      
	      myPagevo1.setClientPassword(request.getParameter("pw"));
	      System.out.println(myPagevo1.getClientPassword());
	      int result = clientMyPageService.checkPw(myPagevo1);
	      
	      return result;
	    }//
	
}
