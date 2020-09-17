package com.spring.hotelspace.admin.management.user.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AdminManageClientVO {
	private String clientID;
	private String clientPassword;
	private String clientName;
	private String clientTel;
	private String clientEmail;
	private Date clientBirth;
	private Date clientRegDate;
	private int clientMilage;
	private int clientState;
	
	public AdminManageClientVO() {}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientTel() {
		return clientTel;
	}

	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public Date getClientBirth() {
		return clientBirth;
	}

	public void setClientBirth(Date clientBirth) {
		this.clientBirth = clientBirth;
	}

	public Date getClientRegDate() {
		return clientRegDate;
	}

	public void setClientRegDate(Date clientRegDate) {
		this.clientRegDate = clientRegDate;
	}

	public int getClientMilage() {
		return clientMilage;
	}

	public void setClientMilage(int clientMilage) {
		this.clientMilage = clientMilage;
	}

	public int getClientState() {
		return clientState;
	}

	public void setClientState(int clientState) {
		this.clientState = clientState;
	}

	public AdminManageClientVO(String clientID, String clientPassword, String clientName, String clientTel,
			String clientEmail, Date clientBirth, Date clientRegDate, int clientMilage, int clientState) {
		super();
		this.clientID = clientID;
		this.clientPassword = clientPassword;
		this.clientName = clientName;
		this.clientTel = clientTel;
		this.clientEmail = clientEmail;
		this.clientBirth = clientBirth;
		this.clientRegDate = clientRegDate;
		this.clientMilage = clientMilage;
		this.clientState = clientState;
	}
	
	
}
