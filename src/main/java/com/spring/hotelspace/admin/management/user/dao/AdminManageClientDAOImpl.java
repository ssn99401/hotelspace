package com.spring.hotelspace.admin.management.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientResVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientRevVO;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

@Repository
public class AdminManageClientDAOImpl implements AdminManageClientDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.admin.management.user.dao.AdminManageClientDAO";

	public List<AdminManageClientVO> getClientTable(AdminManageClientVO vo) {

		// System.out.println("dao 넘어왔음");
		// 전체 테이블 조회 리스트
		List<AdminManageClientVO> array = sqlSessionTemplate.selectList(namespace + ".getClientTable", vo);

		/*
		 * System.out.println("dao에서 sql동작완료"+ vo + " \n array size :"+array.size() );
		 */

		return array;

	}

	public void getActiveState(ArrayList<AdminManageClientVO> arr) {
		System.out.println("active dao");
	  System.out.println(arr.size());
	HashMap hm= new HashMap();
	hm.put("alist", arr);
		sqlSessionTemplate.update(namespace + ".activeClientState", hm);
	
		
		

	}

	public void getBanState(ArrayList<AdminManageClientVO> Narr ) {
		System.out.println("ban dao");
	
		HashMap hm= new HashMap();
		hm.put("blist", Narr);
		
		sqlSessionTemplate.update(namespace + ".banClientState",hm);

	}

	@Override
	public AdminManageClientVO getClientInfo(String id) {
		return sqlSessionTemplate.selectOne(namespace + ".getClientInfo",id);
	}

	@Override
	public AdminManageClientRevVO getClientRev(String id) {
		return sqlSessionTemplate.selectOne(namespace + ".getClientRev",id);
	}

	@Override
	public AdminManageClientResVO getClientRes(String id) {
		return sqlSessionTemplate.selectOne(namespace + ".getClientRes",id);
	}

}
