
package com.spring.hotelspace.admin.main.service;

import java.util.ArrayList;

import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.main.vo.AdminRecentResVO;
import com.spring.hotelspace.admin.main.vo.AdminRecentRevVO;
import com.spring.hotelspace.admin.main.vo.PiChartVO;
import com.spring.hotelspace.admin.main.vo.ReservationDataVO;

public interface AdminMainService {

    public int gethotelCount();
    public int getresCount();
    public int getuserCount();
	public String getReservation(String month);
	public String getSales(String month);
	public String getReservation2019(String month);
	public String getSales2019(String month);
	
	public ArrayList<ReservationDataVO> getData();
	public ArrayList<AdminRecentResVO> getRecentRes();
	public ArrayList<AdminRecentRevVO> getRecentRev();
	public ArrayList<PiChartVO> getpichart();
	public ArrayList<String> getpichart2();
    

    
    
}