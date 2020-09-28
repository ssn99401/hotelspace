package com.spring.hotelspace.client.utils.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ClientInterceptor extends HandlerInterceptorAdapter {
	
	// 요청 페이지 정보 저장
	private void saveDestination(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		String query = request.getQueryString();
		if(query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		uri = uri.substring(index + 1, uri.length());
		if (request.getMethod().equals("GET")) {
			
			request.getSession().setAttribute("destination", uri + query);
		}
	}
	
	@Override
	// 로그인 여부 확인
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		
		// 로그인하지 않은 경우
		if(httpSession.getAttribute("login") == null) {
			
			request.setAttribute("message", "로그인이 필요한 서비스입니다.");
			saveDestination(request);
			RequestDispatcher rd = request.getRequestDispatcher("clientLogin.do");
			rd.forward(request, response);
			return false;
		}
		httpSession.setMaxInactiveInterval(3*60*60);
		return true;
 	}
	

}
