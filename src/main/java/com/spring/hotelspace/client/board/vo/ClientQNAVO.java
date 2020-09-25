package com.spring.hotelspace.client.board.vo;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class ClientQNAVO {

	private String clientId;
	private int claimNum;
	private String claimCategory;
	private String claimTitle;
	private String claimContent;
	private String claimPhoto;
	private MultipartFile file;
	private Date claimQdate;
	private String claimSecret;
	private Date claimAdate;
	private String clientName;
	private int listNum;
	private int listNum2;



	public ClientQNAVO() {}






	public String getClientId() {
		return clientId;
	}



	public void setClientId(String clientId) {
		this.clientId = clientId;
	}



	public int getClaimNum() {
		return claimNum;
	}



	public void setClaimNum(int claimNum) {
		this.claimNum = claimNum;
	}



	public String getClaimCategory() {
		return claimCategory;
	}



	public void setClaimCategory(String claimCategory) {
		this.claimCategory = claimCategory;
	}



	public String getClaimTitle() {
		return claimTitle;
	}



	public void setClaimTitle(String claimTitle) {
		this.claimTitle = claimTitle;
	}



	public String getClaimContent() {
		return claimContent;
	}



	public void setClaimContent(String claimContent) {
		this.claimContent = claimContent;
	}



	public String getClaimPhoto() {
		return claimPhoto;
	}



	public void setClaimPhoto(String claimPhoto) {
		this.claimPhoto = claimPhoto;
	}



	public MultipartFile getFile() {
		return file;
	}



	public void setFile(MultipartFile file) {
		this.file = file;
	}



	public Date getClaimQdate() {
		return claimQdate;
	}



	public void setClaimQdate(Date claimQdate) {
		this.claimQdate = claimQdate;
	}



	public String getClaimSecret() {
		return claimSecret;
	}



	public void setClaimSecret(String claimSecret) {
		this.claimSecret = claimSecret;
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public Date getclaimAdate() {
		return claimAdate;
	}



	public void setclaimAdate(Date claimAdate) {
		this.claimAdate = claimAdate;
	}



	public int getListNum() {
		return listNum;
	}



	public void setListNum(int listNum) {
		this.listNum = listNum;
	}



	public int getListNum2() {
		return listNum2;
	}



	public void setListNum2(int listNum2) {
		this.listNum2 = listNum2;
	}






	public ClientQNAVO(String clientId, int claimNum, String claimCategory, String claimTitle, String claimContent,
			String claimPhoto, MultipartFile file, Date claimQdate, String claimSecret, Date claimAdate,
			String clientName, int listNum, int listNum2) {
		super();
		this.clientId = clientId;
		this.claimNum = claimNum;
		this.claimCategory = claimCategory;
		this.claimTitle = claimTitle;
		this.claimContent = claimContent;
		this.claimPhoto = claimPhoto;
		this.file = file;
		this.claimQdate = claimQdate;
		this.claimSecret = claimSecret;
		this.claimAdate = claimAdate;
		this.clientName = clientName;
		this.listNum = listNum;
		this.listNum2 = listNum2;
	}






	@Override
	public String toString() {
		return "ClientQNAVO [clientId=" + clientId + ", claimNum=" + claimNum + ", claimCategory=" + claimCategory
				+ ", claimTitle=" + claimTitle + ", claimContent=" + claimContent + ", claimPhoto=" + claimPhoto
				+ ", file=" + file + ", claimQdate=" + claimQdate + ", claimSecret=" + claimSecret
				+ ", claimAdate=" + claimAdate + ", clientName=" + clientName + ", listNum=" + listNum
				+ ", listNum2=" + listNum2 + "]";
	}





}