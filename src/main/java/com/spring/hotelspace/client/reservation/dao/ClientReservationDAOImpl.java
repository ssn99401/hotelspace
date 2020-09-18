package com.spring.hotelspace.client.reservation.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.client.reservation.vo.ClientReservationInfoVO;
import com.spring.hotelspace.client.reservation.vo.ClientReservationVO;
import com.spring.hotelspace.client.search.vo.ClientRoomVO;

@Repository
public class ClientReservationDAOImpl implements ClientReservationDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.client.reservation.dao.ClientReservationDAO";

	@Override
	public void insertReserv(ClientReservationVO clientReservationVO) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.selectOne(namespace + ".insertReserv", clientReservationVO);
	}

	public List<ClientReservationInfoVO> revInfo(ClientReservationInfoVO clientReservationInfoVO) {
		// TODO Auto-generated method stub
		System.out.println("DAOImple"+clientReservationInfoVO);
		return sqlSessionTemplate.selectList(namespace + ".revInfo", clientReservationInfoVO);
	}

	

}
