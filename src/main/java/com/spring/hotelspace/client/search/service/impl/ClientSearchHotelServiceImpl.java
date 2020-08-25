package com.spring.hotelspace.client.search.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.search.dao.ClientSearchHotelDAOImpl;
import com.spring.hotelspace.client.search.service.ClientSearchHotelService;
import com.spring.hotelspace.client.search.vo.ClientHotelFilterDTO;
import com.spring.hotelspace.client.search.vo.ClientHotelVO;
import com.spring.hotelspace.client.search.vo.ClientSearchHotelDTO;
import com.spring.hotelspace.common.geocode.GeoCodeService;

@Service
public class ClientSearchHotelServiceImpl implements ClientSearchHotelService {

	@Autowired
	private ClientSearchHotelDAOImpl clientSearchHotelDAO;
	
	@Autowired
	private GeoCodeService geoCodeService;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
	Calendar cal = new GregorianCalendar();
    
	private final static int hoteListPageSize = 3;
	private final static int pageBlock = 2;
	// 전체 호텔 리스트 조회
	
	// 호텔 리스트 검색(hotelList page)
	@Override
	public HashMap<String, Object> searchHotelToSearchBar(ClientSearchHotelDTO requestDTO) {

		
		HashMap<Object, Object> map = new HashMap<>();
		
		map.put("hotelSearchMethod", "hotelListToSearch");
		map.put("searchKeyword", requestDTO.getSearchKeyword());
		map.put("checkIdDate", requestDTO.getCheckInDate());
		map.put("checkOutDate", requestDTO.getCheckOutDate());
		map.put("people", requestDTO.getPeople());
		map.put("area", requestDTO.getArea());
		
		map.put("filter", "no");
		map.put("start", 1);
		map.put("end", hoteListPageSize);

		List<Object> hotelList = clientSearchHotelDAO.searchHotelToSearchBar(map);
		HashMap<String, Object> hotelMap = new HashMap<String, Object>();

		for(int i = 1; i < hotelList.size() + 1; i++) {
			ClientHotelVO vo = (ClientHotelVO)hotelList.get(i-1);
			try {
				hotelMap.put("geoCode" + i, (String) geoCodeService.getKakaoApiFromAddress(vo.getHotelAddress()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			hotelMap.put("hotel" + i, hotelList.get(i-1));
		}
		
		hotelMap.put("reservationInDate", requestDTO.getCheckInDate());
		hotelMap.put("reservationOutDate", requestDTO.getCheckOutDate());
		hotelMap.put("count", clientSearchHotelDAO.getCountToHotelList(map));
		hotelMap.put("pageNum", 1);
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		return hotelMap;
	}

	// 호텔 리스트 결과 필터 적용
	@Override
	public HashMap<String, Object> searchHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod) {

		HashMap<Object, Object> map = new HashMap<>();
		List<Object> hotelList = null;
		map.put("checkedKeyword", hotelFillter.getCheckedKeyword());
		map.put("parking", hotelFillter.getParking());
		map.put("pool", hotelFillter.getPool());
		map.put("breakfast", hotelFillter.getBreakfast());
		map.put("fitness", hotelFillter.getFitness());
		map.put("wifi", hotelFillter.getWifi());
		map.put("partyRoom", hotelFillter.getPartyRoom());
		map.put("minPrice", hotelFillter.getMinPrice());
		map.put("maxPrice", hotelFillter.getMaxPrice());
		map.put("minStar", hotelFillter.getMinStar());
		map.put("maxStar", hotelFillter.getMaxStar());
		map.put("checkedConcept", hotelFillter.getCheckedConcept());
		map.put("filter", "yes");
		map.put("start", 1);
		map.put("end", hoteListPageSize);
		
		
		String checkIdDate = null;
		String checkOutDate = null;
		
		if(hotelSearchMethod.equals("hotelListAll")) {
			cal.add(Calendar.DATE, 1);
			checkIdDate = simpleDateFormat.format(new Date());
			checkOutDate = simpleDateFormat.format(cal.getTime());
			map.put("checkIdDate", checkIdDate);
			map.put("checkOutDate", checkOutDate);

			map.put("hotelSearchMethod", "hotelListAll");
			
			hotelList = clientSearchHotelDAO.searchHotelAll(map);
		}
		else {
			ClientSearchHotelDTO searchQuery = (ClientSearchHotelDTO) hotelSearchMethod;
			map.put("hotelSearchMethod", "hotelListToSearch");
			map.put("searchKeyword", searchQuery.getSearchKeyword());
			map.put("checkIdDate", searchQuery.getCheckInDate());
			map.put("checkOutDate", searchQuery.getCheckOutDate());
			map.put("people", searchQuery.getPeople());
			map.put("area", searchQuery.getArea());
			
			hotelList = clientSearchHotelDAO.searchHotelToSearchBar(map);
		}
	
		HashMap<String, Object> hotelMap = new HashMap<String, Object>();

		for(int i = 1; i < hotelList.size() + 1; i++) {
			ClientHotelVO vo = (ClientHotelVO)hotelList.get(i-1);
			try {
				hotelMap.put("geoCode" + i, (String) geoCodeService.getKakaoApiFromAddress(vo.getHotelAddress()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			hotelMap.put("hotel" + i, hotelList.get(i-1));
		}
		
		if(hotelSearchMethod.equals("hotelListAll")) {
			hotelMap.put("reservationInDate", checkIdDate);
			hotelMap.put("reservationOutDate", checkOutDate);
		} else {
			hotelMap.put("reservationInDate", ((ClientSearchHotelDTO) hotelSearchMethod).getCheckInDate());
			hotelMap.put("reservationOutDate", ((ClientSearchHotelDTO) hotelSearchMethod).getCheckOutDate());
		}
		
		hotelMap.put("count", clientSearchHotelDAO.getCountToHotelList(map));
		hotelMap.put("pageNum", 1);
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		return hotelMap;
	}

	// 호텔리스트 페이지 이동
	@Override
	public HashMap<String, Object> movePageToHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod, String filter) {
		
		
		HashMap<Object, Object> map = new HashMap<>();
		
		// filter
		map.put("checkedKeyword", hotelFillter.getCheckedKeyword());
		map.put("parking", hotelFillter.getParking());
		map.put("pool", hotelFillter.getPool());
		map.put("breakfast", hotelFillter.getBreakfast());
		map.put("fitness", hotelFillter.getFitness());
		map.put("wifi", hotelFillter.getWifi());
		map.put("partyRoom", hotelFillter.getPartyRoom());
		map.put("minPrice", hotelFillter.getMinPrice());
		map.put("maxPrice", hotelFillter.getMaxPrice());
		map.put("minStar", hotelFillter.getMinStar());
		map.put("maxStar", hotelFillter.getMaxStar());
		map.put("checkedConcept", hotelFillter.getCheckedConcept());
		
		map.put("filter", filter);
		map.put("start", ((hotelFillter.getPageNum() -1 ) * hoteListPageSize) + 1);
		map.put("end", (hotelFillter.getPageNum() * hoteListPageSize));
		
		List<Object> hotelList = null;
		String checkIdDate = null;
		String checkOutDate = null;
		
		if(hotelSearchMethod.equals("hotelListAll")) {
			map.put("hotelSearchMethod", "hotelListAll");
			cal.add(Calendar.DATE, 1);
			checkIdDate = simpleDateFormat.format(new Date());
			checkOutDate = simpleDateFormat.format(cal.getTime());
			map.put("checkIdDate", checkIdDate);
			map.put("checkOutDate", checkOutDate);
			
			hotelList =  clientSearchHotelDAO.searchHotelAll(map);
		} else {
			ClientSearchHotelDTO searchQuery = (ClientSearchHotelDTO) hotelSearchMethod;
			map.put("hotelSearchMethod", "hotelListToSearch");
			map.put("searchKeyword",  searchQuery.getSearchKeyword());
			map.put("checkIdDate", searchQuery.getCheckInDate());
			map.put("checkOutDate", searchQuery.getCheckOutDate());
			map.put("people", searchQuery.getPeople());
			map.put("area", searchQuery.getArea());
			
			hotelList = clientSearchHotelDAO.searchHotelToSearchBar(map);
		};
		HashMap<String, Object> hotelMap = new HashMap<String, Object>();
		
		for(int i = 1; i < hotelList.size() + 1; i++) {
			ClientHotelVO vo = (ClientHotelVO)hotelList.get(i-1);
			try {
				hotelMap.put("geoCode" + i, (String) geoCodeService.getKakaoApiFromAddress(vo.getHotelAddress()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			hotelMap.put("hotel" + i, hotelList.get(i-1));
		}
		
		
		if(hotelSearchMethod.equals("hotelListAll")) {
			hotelMap.put("reservationInDate", checkIdDate);
			hotelMap.put("reservationOutDate", checkOutDate);
		} else {
			hotelMap.put("reservationInDate", checkIdDate);
			hotelMap.put("reservationOutDate", checkOutDate);
		}
		hotelMap.put("count", clientSearchHotelDAO.getCountToHotelList(map));
		hotelMap.put("pageNum", hotelFillter.getPageNum());
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		return hotelMap;
	}


}
