package com.spring.hotelspace.admin.management.page.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

@Repository
public class AdminPageManagerDAOImpl implements AdminPageManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.spring.hotelspace.admin.management.page.dao.AdminPageManagerDAO";

	// 웹 화면 이미지 리스트 반환 메서드
	@Override
	public List<AdminPageImageVO> getImageLinkList() {
		return sqlSessionTemplate.selectList(namespace + ".getImageLinksList");
	}
	
	// 이미지 ID 얻기
	@Override
	public String getImageSeq() {
		return sqlSessionTemplate.selectOne(namespace + ".getPageSeq");
	}
	
	// 업로드 된 이미지 데이터베이스에 저장
	@Override
	public int uploadPageImage(List<AdminPageImageVO> pageImageList) {
		return sqlSessionTemplate.insert(namespace + ".pageImageInsert", pageImageList);
	}

	@Override
	public int changePageImage(Map<String, String> requestMap) {
		return sqlSessionTemplate.update(namespace + ".pageImageUpdate", requestMap);
	}
	
	// 페이지 사진 삭제
	@Override
	public int deletePageImage(List<Map> arrJson) {
		return sqlSessionTemplate.update(namespace + ".pageImageDelete", arrJson);
	}
}
