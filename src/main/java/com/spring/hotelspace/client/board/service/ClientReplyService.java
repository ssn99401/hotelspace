package com.spring.hotelspace.client.board.service;

import java.util.List;

import com.spring.hotelspace.client.board.vo.ClientReplyVO;

public interface ClientReplyService {
	// 댓글 목록
    public List<ClientReplyVO> ReplyAll(ClientReplyVO RVO) throws Exception;
 
    // 댓글 작성
    public void ReplyInsert(ClientReplyVO clientReplyVO) throws Exception;
    
    // 댓글 수정
    public void ReplyUpdate(ClientReplyVO RVO) throws Exception;
 
    // 댓글 삭제
    public void ReplyDelete(int replyNum) throws Exception;
	
}

