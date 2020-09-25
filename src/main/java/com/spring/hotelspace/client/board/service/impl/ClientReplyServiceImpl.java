package com.spring.hotelspace.client.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.board.dao.ClientQNADAO;
import com.spring.hotelspace.client.board.dao.ClientReplyDAO;
import com.spring.hotelspace.client.board.service.ClientReplyService;
import com.spring.hotelspace.client.board.vo.ClientQNAVO;
import com.spring.hotelspace.client.board.vo.ClientReplyVO;
@Service
public class ClientReplyServiceImpl implements ClientReplyService{
	
	@Autowired
	private ClientReplyDAO clientReplyDAO;

	@Override
	public List<ClientReplyVO> ReplyAll(ClientReplyVO RVO) throws Exception {
		
		return clientReplyDAO.ReplyAll(RVO);
	}

	@Override
	public void ReplyInsert(ClientReplyVO RVO) throws Exception {
		
		clientReplyDAO.ReplyInsert(RVO);
	}
	

	@Override
	public void ReplyUpdate(ClientReplyVO RVO) throws Exception {
		
		clientReplyDAO.ReplyUpdate(RVO);
		
	}

	@Override
	public void ReplyDelete(int replyNum) throws Exception {
		clientReplyDAO.ReplyDelete(replyNum);
		
	}
	
}
