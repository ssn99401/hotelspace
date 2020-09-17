package com.spring.hotelspace.client.mypage.vo;

import org.springframework.stereotype.Component;

@Component
public class ClientMyPageVO {
	
	private String clientId;
	   private String clientPassword;
	   private String clientName;
	   private String clientTel;
	   private String clientEmail;
	   private String clientBirth;
	   private String clientRegDate;
	   private int clientMilage;
	   private String clientState;
	   
	   public ClientMyPageVO() {}
	   
	   public ClientMyPageVO(String clientId, String clientPassword, String clientName, String clientTel,
			String clientEmail, String clientBirth, String clientRegDate, int clientMilage, String clientState) {
		super();
		this.clientId = clientId;
		this.clientPassword = clientPassword;
		this.clientName = clientName;
		this.clientTel = clientTel;
		this.clientEmail = clientEmail;
		this.clientBirth = clientBirth;
		this.clientRegDate = clientRegDate;
		this.clientMilage = clientMilage;
		this.clientState = clientState;
	}



	public String getClientId() {
	      return clientId;
	   }



	   public void setClientId(String clientId) {
	      this.clientId = clientId;
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

	   public String getClientBirth() {
	      return clientBirth;
	   }

	   public void setClientBirth(String clientBirth) {
	      this.clientBirth = clientBirth;
	   }

	   public String getClientRegDate() {
	      return clientRegDate;
	   }

	   public void setClientRegDate(String clientRegDate) {
	      this.clientRegDate = clientRegDate;
	   }

	   public int getClientMilage() {
	      return clientMilage;
	   }

	   public void setClientMilage(int clientMilage) {
	      this.clientMilage = clientMilage;
	   }
	   
	   public String getClientState() {
	      return clientState;
	   }

	   public void setClientState(String clientState) {
	      this.clientState = clientState;
	   }


	   @Override
	   public String toString() {
	      return clientName;
	   }
	   
}
