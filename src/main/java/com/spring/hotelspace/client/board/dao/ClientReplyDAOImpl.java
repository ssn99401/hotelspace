package com.spring.hotelspace.client.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.board.vo.ClientQNAVO;
import com.spring.hotelspace.client.board.vo.ClientReplyVO;

@Repository
public class ClientReplyDAOImpl implements ClientReplyDAO{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.client.board.dao.ClientReplyDAO";

	@Override
	public List<ClientReplyVO> ReplyAll(ClientReplyVO RVO) {

		List<ClientReplyVO> ReplyList =  sqlSessionTemplate.selectList(namespace + ".ReplyAll", RVO);
		return ReplyList;
	}
	@Override
	public void ReplyInsert(ClientReplyVO RVO) throws Exception	{
		sqlSessionTemplate.insert(namespace+".ReplyInsert",RVO);
	}
	@Override
	public void ReplyUpdate(ClientReplyVO RVO) throws Exception {
		sqlSessionTemplate.update(namespace+".ReplyUpdate",RVO);
	}
	@Override
	public void ReplyDelete(int replyNum) throws Exception {
		sqlSessionTemplate.delete(namespace+".ReplyDelete",replyNum);
		
	}
	

}
