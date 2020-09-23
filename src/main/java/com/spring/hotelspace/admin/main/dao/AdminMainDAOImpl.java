
package com.spring.hotelspace.admin.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.main.vo.ReservationDataVO;

@Repository
public class AdminMainDAOImpl implements AdminMainDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.admin.main.dao.AdminMainDAO";

	@Override
	public int gethotelCount() {
		
		int result = sqlSessionTemplate.selectOne(namespace + ".getHotelCount");
		
		System.out.println(result);
		return sqlSessionTemplate.selectOne(namespace + ".getHotelCount");
	}

	@Override
	public int getresCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".getResCount");
	}

	@Override
	public int getuserCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".getUserCount");
	}

	@Override
	public String getReservation(String month) {
		
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".getReservation","20/"+month+"%");
	}

	@Override
	public String getSales(String month) {
	
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".getSales","20/"+month+"%");
	}

	@Override
	public String getReservation2019(String month) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".getReservation2019","19/"+month+"%");
	}

	@Override
	public String getSales2019(String month) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace + ".getSales2019","19/"+month+"%");
	}

	@Override
	public ArrayList<ReservationDataVO> getData() {
		List<ReservationDataVO> getData=sqlSessionTemplate.selectList(namespace+".getData");
		System.out.println(getData);
		// TODO Auto-generated method stub
		return (ArrayList<ReservationDataVO>) getData;
	}
}
