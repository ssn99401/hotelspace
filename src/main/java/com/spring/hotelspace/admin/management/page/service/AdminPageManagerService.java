package com.spring.hotelspace.admin.management.page.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

public interface AdminPageManagerService {
	
	// 웹 화면 이미지 리스트 반환 메서드
	public List<AdminPageImageVO> getImageLinkList();
	//사진 업로드
	public int uploadImageToServer(MultipartHttpServletRequest files) throws IOException, Exception ;
	
	// 사진 변경(업데이트)
	public int changePageImage(String jsonParam) throws ParseException;
	// 사진 삭제
	public int deletePageImage(List<Map> arrJson) throws ParseException;
}
