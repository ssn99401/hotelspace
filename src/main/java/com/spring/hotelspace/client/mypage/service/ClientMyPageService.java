package com.spring.hotelspace.client.mypage.service;

import java.util.List;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;
import com.spring.hotelspace.client.mypage.vo.ClientReviewVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;

public interface ClientMyPageService {
	
	public int updateAction(ClientLoginVO loginVO);

	public ClientLoginVO searchAll(ClientLoginVO loginVO);

	int changePW(ClientMyPageVO client);

	int checkPw(ClientMyPageVO myPagevo1);

	public ClientMyPageVO withdrawal(ClientLoginVO object);

	public List<ClientReservationVO> myReservation(String id);

	public String mypageReview(ClientReviewVO client);

	public String avgReview(String review);

}
