package com.spring.hotelspace.admin.management.page.service.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.hotelspace.admin.management.page.dao.AdminPageManagerDAO;
import com.spring.hotelspace.admin.management.page.service.AdminPageManagerService;
import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;
import com.spring.hotelspace.common.file.FileService;
import com.spring.hotelspace.common.file.FileVO;

@Service
public class AdminPageManagerServiceImpl implements AdminPageManagerService {

	@Autowired
	private AdminPageManagerDAO adminPageManagerDAO;

	@Autowired
	private FileService fileService;


	private String pageImagePath = "pageImage";

	// 웹 화면 이미지 리스트 반환 메서드
	public List<AdminPageImageVO> getImageLinkList() {
		List<AdminPageImageVO> list = adminPageManagerDAO.getImageLinkList();

		return list;
	}

	// 사진 업로드
	@Transactional
	public int uploadImageToServer(MultipartHttpServletRequest files) throws IOException, Exception {
		// 이미지 파일 서버 업로드
		List<FileVO> fileList =  fileService.uploadFilesToIterator(pageImagePath, files);
		List<AdminPageImageVO> pageImageList = new ArrayList<AdminPageImageVO>();
		for(FileVO file : fileList) {
			AdminPageImageVO pageImage = new AdminPageImageVO(null, "NORMAL", file.getSavePath() + file.getFileName());
			pageImageList.add(pageImage);
		}
		return adminPageManagerDAO.uploadPageImage(pageImageList);
		// 이미지 파일 데이터베이스 등록
	}
	
	// 사진 변경(업데이트)
	public int changePageImage(String jsonParam) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("newImageId", (String) jsonObject.get("newImageId"));
		requestMap.put("oldImageType", (String) jsonObject.get("oldImageType"));
		
		return adminPageManagerDAO.changePageImage(requestMap);
	}
	
	// 사진 삭제
	public int deletePageImage(List<Map> arrJson) throws ParseException {

		return adminPageManagerDAO.deletePageImage(arrJson);
	}
}
