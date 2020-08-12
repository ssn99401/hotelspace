package com.spring.hotelspace.client.login.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.spring.hotelspace.client.login.dao.ClientLoginDAO;
import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.login.service.ClientLoginService;

@Service
public class ClientLoginServiceImpl implements ClientLoginService {
	
	@Autowired
	private ClientLoginDAO clientLoginDAO;
	
	@Override
	public ClientLoginVO getClientLoginResult(ClientLoginVO client) {
		
		return clientLoginDAO.getClientLoginResult(client);
	}

	@Override
	public ClientLoginVO compareKakaoId(String id) {
		// TODO Auto-generated method stub
		return clientLoginDAO.selectKakaoId(id);
	}
}