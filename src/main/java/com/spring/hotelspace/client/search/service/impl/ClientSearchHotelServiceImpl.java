package com.spring.hotelspace.client.search.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.search.dao.ClientSearchHotelDAOImpl;
import com.spring.hotelspace.client.search.service.ClientSearchHotelService;
import com.spring.hotelspace.client.search.vo.ClientHotelFilterDTO;
import com.spring.hotelspace.client.search.vo.ClientSearchHotelDTO;

@Service
public class ClientSearchHotelServiceImpl implements ClientSearchHotelService {

	@Autowired
	private ClientSearchHotelDAOImpl clientSearchHotelDAO;

	private final static int hoteListPageSize = 3;
	private final static int pageBlock = 2;
	// 전체 호텔 리스트 조회
	@Override
	public HashMap<String, Object> searchHotelAll(ClientSearchHotelDTO requestDTO) {

		HashMap<Object, Object> map = new HashMap<>();

		
		map.put("start", 1);
		map.put("end", hoteListPageSize);
		map.put("filter", "no");
		map.put("hotelSearchMethod", "hotelListAll");
		
		List<Object> hotelList = clientSearchHotelDAO.searchHotelAll(map);
		
		HashMap<String, Object> hotelMap = new HashMap<String, Object>();

		for(int i = 1; i < hotelList.size() + 1; i++) {
			hotelMap.put("hotel" + i, hotelList.get(i-1));
		}
		
		hotelMap.put("count", clientSearchHotelDAO.getCountToHotelList(map));
		hotelMap.put("pageNum", 1);
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		
		return hotelMap;
	}

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
			hotelMap.put("hotel" + i, hotelList.get(i-1));
		}
		
		hotelMap.put("count", clientSearchHotelDAO.getCountToHotelList(map));
		hotelMap.put("pageNum", 1);
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);

		return hotelMap;
	}

	// 호텔 리스트 결과 필터 적용
	@Override
	public HashMap<String, Object> applyFillterToHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod) {

		HashMap<Object, Object> map = new HashMap<>();
		
		if(hotelSearchMethod.equals("hotelListAll")) {
			map.put("hotelSearchMethod", "hotelListAll");
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
		}
		else {
			ClientSearchHotelDTO searchQuery = (ClientSearchHotelDTO) hotelSearchMethod;
			map.put("hotelSearchMethod", "hotelListToSearch");
			map.put("searchKeyword", searchQuery.getSearchKeyword());
			map.put("checkIdDate", searchQuery.getCheckInDate());
			map.put("checkOutDate", searchQuery.getCheckOutDate());
			map.put("people", searchQuery.getPeople());
			map.put("area", searchQuery.getArea());
			
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
		}

		map.put("filter", "yes");
		map.put("start", 1);
		map.put("end", hoteListPageSize);

		List<Object> hotelList = clientSearchHotelDAO.applyFillterToHotelList(map);

		HashMap<String, Object> hotelMap = new HashMap<String, Object>();

		for(int i = 1; i < hotelList.size() + 1; i++) {
			hotelMap.put("hotel" + i, hotelList.get(i-1));
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
		
		if(hotelSearchMethod.equals("hotelListAll")) {
			map.put("hotelSearchMethod", "hotelListAll");
		} else {
			ClientSearchHotelDTO searchQuery = (ClientSearchHotelDTO) hotelSearchMethod;
			map.put("hotelSearchMethod", "hotelListToSearch");
			map.put("searchKeyword",  searchQuery.getSearchKeyword());
			map.put("checkIdDate", searchQuery.getCheckInDate());
			map.put("checkOutDate", searchQuery.getCheckOutDate());
			map.put("people", searchQuery.getPeople());
			map.put("area", searchQuery.getArea());
		}
		
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
		
		
		List<Object> hotelList = clientSearchHotelDAO.movoPageToHotelList(map);
		
		HashMap<String, Object> hotelMap = new HashMap<String, Object>();
		
		for(int i = 1; i < hotelList.size() + 1; i++) {
			hotelMap.put("hotel" + i, hotelList.get(i-1));
		}
		
		hotelMap.put("count", clientSearchHotelDAO.getCountToHotelList(map));
		hotelMap.put("pageNum", hotelFillter.getPageNum());
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		
		return hotelMap;
	}


}
