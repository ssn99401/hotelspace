package com.spring.hotelspace.admin.management.page.dao;

import java.util.List;
import java.util.Map;

import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

public interface AdminPageManagerDAO {
	
	// 웹 화면 이미지 리스트 반환 메서드
	public List<AdminPageImageVO> getImageLinkList();
	public String getImageSeq();
	// 업로드 된 이미지 데이터베이스에 저장
	public int uploadPageImage(List<AdminPageImageVO> pageImageList);
	// 페이지 사진 변경
	public int changePageImage(Map<String, String> requestMap);
	// 페이지 사진 삭제
	public int deletePageImage(List<Map> arrJson);
}
