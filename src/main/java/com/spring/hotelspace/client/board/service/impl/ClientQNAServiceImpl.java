package com.spring.hotelspace.client.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.board.dao.ClientQNADAO;
import com.spring.hotelspace.client.board.service.ClientQNAService;
import com.spring.hotelspace.client.board.vo.ClientQNAVO;

@Service
public class ClientQNAServiceImpl implements ClientQNAService {

	@Autowired
	private ClientQNADAO clientQNADAO;

	@Override
	   public List<Object> AllQNA(ClientQNAVO qnaVO) {
	      // TODO Auto-generated method stub
	      return clientQNADAO.AllQNA(qnaVO);
	   }

	   @Override
	   public List<Object> MyQNA(ClientQNAVO qnavo) {
	      // TODO Auto-generated method stub
	      return clientQNADAO.MyQNA(qnavo);
	   }

	   @Override
	   public List<Object> SearchQNA(ClientQNAVO qnavo) {
	      // TODO Auto-generated method stub
	      return clientQNADAO.SearchQNA(qnavo);
	   }

	@Override
	public void QNAInsert(ClientQNAVO QNAVO) throws Exception {
		
		clientQNADAO.QNAInsert(QNAVO);
	}
	
	@Override
	public ClientQNAVO QNAread(int claimNum) throws Exception{

		return clientQNADAO.QNAread(claimNum);
	}

	@Override
	public void QNAupdate(ClientQNAVO QNAVO) throws Exception {
		clientQNADAO.QNAupdate(QNAVO);
		
	}

	@Override
	public void QNAdelete(int claimNum) throws Exception {
		clientQNADAO.QNAdelete(claimNum);
		
	}

	@Override
	public void QNAReadNumber(int claimNum, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	/*
	 * @Override public void QNAReadNumber(int claimNum, HttpSession session) throws
	 * Exception { long update_time = 0;
	 * 
	 * if(session.getAttribute("update_time_"+claimNum) != null) { update_time =
	 * (long)session.getAttribute("update_time_"+claimNum); } long current_time =
	 * System.currentTimeMillis(); if(current_time - update_time > 5*1000) {
	 * clientQNADAO.QNAReadNumber(claimNum, session);
	 * session.setAttribute("update_time_"+claimNum, current_time); } }
	 */
}
