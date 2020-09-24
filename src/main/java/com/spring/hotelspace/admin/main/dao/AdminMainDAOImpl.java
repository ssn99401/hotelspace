
package com.spring.hotelspace.admin.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.main.vo.AdminRecentResVO;
import com.spring.hotelspace.admin.main.vo.AdminRecentRevVO;
import com.spring.hotelspace.admin.main.vo.PiChartVO;
import com.spring.hotelspace.admin.main.vo.ReservationDataVO;

@Repository
public class AdminMainDAOImpl implements AdminMainDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.spring.hotelspace.admin.main.dao.AdminMainDAO";

	@Override
	public int gethotelCount() {
		
		int result = sqlSessionTemplate.selectOne(namespace + ".getHotelCount");
		
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

	@Override
	public ArrayList<AdminRecentResVO> getRecentRes() {
		List<AdminRecentResVO> res =sqlSessionTemplate.selectList(namespace + ".getRecentReservation");
		// TODO Auto-generated method stub
		return (ArrayList<AdminRecentResVO>) res;
	}

	@Override
	public ArrayList<AdminRecentRevVO> getRecentRev() {
		List<AdminRecentRevVO> rev =sqlSessionTemplate.selectList(namespace + ".getRecentRev");
		// TODO Auto-generated method stub
		return (ArrayList<AdminRecentRevVO>) rev;
	}

	@Override
	public ArrayList<PiChartVO> getpichart() {//호텔 예약된 개수
		
		List<PiChartVO> hid =sqlSessionTemplate.selectList(namespace + ".getpiChart");
		
/*		List<String> rid =sqlSessionTemplate.selectList(namespace + ".getResid");
		List<String> pich = new ArrayList<String>();*/
		
		
		/*for (int i = 0; i < rid.size(); i++) {//예약 hotelid와 hotelid가 같으면
			for (int j = 0; j < hid.size(); j++) {
				if(rid.get(i).equals(hid.get(j))) {
					pich.add(rid.get(i));
					System.out.println(rid.get(i));
				}
				
			}
			
			
		}*/
		return (ArrayList<PiChartVO>)hid;
	}

	@Override
	public ArrayList<String> getpichart2() {
		String city="도심 속 힐링";
		
		List<String> hid =sqlSessionTemplate.selectList(namespace + ".gethid2",city);
		List<String> rid =sqlSessionTemplate.selectList(namespace + ".getrid2");
		List<String> pich = new ArrayList<String>();
		for (int i = 0; i < rid.size(); i++) {//예약 hotelid와 hotelid가 같으면
			for (int j = 0; j < hid.size(); j++) {
				if(rid.get(i).equals(hid.get(j))) {
					pich.add(rid.get(i));
					System.out.println(rid.get(i));
				}
				
			}
			
			
		}
		return (ArrayList<String>) pich;
	}
}
