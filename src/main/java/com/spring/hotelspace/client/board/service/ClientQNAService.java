package com.spring.hotelspace.client.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring.hotelspace.client.board.vo.ClientQNAVO;

public interface ClientQNAService {

	public List<Object> AllQNA(ClientQNAVO qnaVO);
	public List<Object> MyQNA(ClientQNAVO qnavo);
	public List<Object> SearchQNA(ClientQNAVO qnavo);
	public void QNAInsert(ClientQNAVO QNAVO) throws Exception;
	public ClientQNAVO QNAread(int claimNum) throws Exception;
	public void QNAupdate(ClientQNAVO QNAVO) throws Exception;
	public void QNAdelete(int claimNum) throws Exception;
	public void QNAReadNumber(int claimNum,HttpSession session)throws Exception;



}
