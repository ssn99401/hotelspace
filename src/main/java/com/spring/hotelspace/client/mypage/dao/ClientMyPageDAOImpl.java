package com.spring.hotelspace.client.mypage.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;
import com.spring.hotelspace.client.mypage.vo.ClientReviewVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;

@Repository
public class ClientMyPageDAOImpl implements ClientMyPageDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.client.mypage.dao.ClientMyPageDAO";

	@Override
	public int updateAction(ClientLoginVO loginVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace + ".updateMyInfo", loginVO);
	}

	@Override
	public ClientLoginVO selectAll(ClientLoginVO loginVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".selectAll", loginVO);
	}

	@Override
	public int changePW(ClientMyPageVO client) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace+".updatePW", client);
	}

	@Override
	public int checkPw(ClientMyPageVO myPagevo1) {
		int result1 = sqlSessionTemplate.selectOne(namespace + ".checkPw",myPagevo1);
		return result1;
	}

	@Override
	public ClientMyPageVO withdrawal(ClientLoginVO client) {
		
		return sqlSessionTemplate.selectOne(namespace+".withdrawal", client);
	}

	@Override
	public List<ClientReservationVO> myReservation(String client) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+".myReservation", client);
	}

	@Override
	public String mypageReview(ClientReviewVO client) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+".mypageReview", client);
	}

	@Override
	public String avgReview(String review) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+".avgReview", review);
	}

	@Override
	public String reservCheck(ClientReservationVO reservVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+".reservCheck", reservVO);
	}

}
