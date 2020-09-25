package com.spring.hotelspace.client.board.vo;

import org.springframework.stereotype.Component;

@Component
public class ClientReplyVO {
	private int claimNum; //게시글번호
	private int replyNum; //댓글번호
	private String replyContent; //댓글내용
	private String clientId;	//작성자아이디
	private String clientName; //작성자
	private String replyDate;  //작성날짜
	private String replyAdate; //수정날짜

	public ClientReplyVO(){}
	
	

	public ClientReplyVO(int claimNum, int replyNum, String replyContent, String clientId, String clientName,
			String replyDate, String replyAdate) {
		super();
		this.claimNum = claimNum;
		this.replyNum = replyNum;
		this.replyContent = replyContent;
		this.clientId = clientId;
		this.clientName = clientName;
		this.replyDate = replyDate;
		this.replyAdate = replyAdate;
	}



	public int getClaimNum() {
		return claimNum;
	}
	public void setClaimNum(int claimNum) {
		this.claimNum = claimNum;
	}
	public String getreplyAdate() {
		return replyAdate;
	}

	public void setreplyAdate(String replyAdate) {
		this.replyAdate = replyAdate;
	}

	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}



	@Override
	public String toString() {
		return "ClientReplyVO [claimNum=" + claimNum + ", replyNum=" + replyNum + ", replyContent=" + replyContent
				+ ", clientId=" + clientId + ", clientName=" + clientName + ", replyDate=" + replyDate
				+ ", replyAdate=" + replyAdate + "]";
	}
	
}
