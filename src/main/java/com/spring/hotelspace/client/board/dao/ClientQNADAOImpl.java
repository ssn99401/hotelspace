package com.spring.hotelspace.client.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.board.vo.ClientQNAVO;

@Repository
public class ClientQNADAOImpl implements ClientQNADAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.client.board.dao.ClientQNADAO";

	@Override
	   public List<Object> AllQNA(ClientQNAVO qnaVO) {
	      List<Object> QNAList =  sqlSessionTemplate.selectList(namespace + ".AllQNA", qnaVO);
	     
	      return QNAList;
	   }

	   @Override
	   public List<Object> MyQNA(ClientQNAVO qnavo) {
	      // TODO Auto-generated method stub
	      List<Object> MyQNAList =  sqlSessionTemplate.selectList(namespace + ".MyQNA", qnavo);
	      /*System.out.println(MyQNAList);*/
	      return MyQNAList;
	   }

	   @Override
	   public List<Object> SearchQNA(ClientQNAVO qnavo) {
	      // TODO Auto-generated method stub
	      List<Object> SearchQNAList = sqlSessionTemplate.selectList(namespace + ".SearchQNA", qnavo);
	      
	      return SearchQNAList;
	   }

	@Override
	public void QNAInsert(ClientQNAVO QNAVO) throws Exception	{
		sqlSessionTemplate.insert(namespace+".QNAInsert",QNAVO);
	}

	@Override
	public ClientQNAVO QNAread(int claimNum) throws Exception	{

		return sqlSessionTemplate.selectOne(namespace+".QNAread", claimNum);
	}

	@Override
	public void QNAupdate(ClientQNAVO QNAVO) throws Exception {
		sqlSessionTemplate.update(namespace+".QNAupdate",QNAVO);
		
	}

	@Override
	public void QNAdelete(int claimNum) throws Exception {
		sqlSessionTemplate.delete(namespace+".QNAdelete",claimNum);
		
	}

	@Override
	public void QNAReadNumber(int claimNum, HttpSession session) throws Exception {
		sqlSessionTemplate.delete(namespace+".QNAreadnumber",claimNum);
		
	}
	


}
