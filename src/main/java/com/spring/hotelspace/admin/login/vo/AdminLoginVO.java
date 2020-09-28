package com.spring.hotelspace.admin.login.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminLoginVO {
	
	private String id;
	private String password;
	
	public AdminLoginVO() {}

	public AdminLoginVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLoginVO [id=" + id + ", password=" + password + "]";
	}

	
	
}
