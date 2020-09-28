package com.spring.hotelspace.client.search.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hotelspace.admin.management.hotel.vo.AdminRoomVO;
import com.spring.hotelspace.client.search.dao.ClientSearchHotelDAOImpl;
import com.spring.hotelspace.client.search.service.ClientSearchHotelService;
import com.spring.hotelspace.client.search.vo.ClientHotelFilterDTO;
import com.spring.hotelspace.client.search.vo.ClientHotelVO;
import com.spring.hotelspace.client.search.vo.ClientSearchHotelDTO;
import com.spring.hotelspace.client.search.vo.PaginationHotelList;
import com.spring.hotelspace.common.geocode.GeoCodeService;

@Service
public class ClientSearchHotelServiceImpl implements ClientSearchHotelService {

	@Autowired
	private ClientSearchHotelDAOImpl clientSearchHotelDAO;

	@Autowired
	private GeoCodeService geoCodeService;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private final static int hoteListPageSize = 3;
	private final static int pageBlock = 5;
	// 전체 호텔 리스트 조회

	// 호텔 리스트 검색(hotelList page)
	@Override
	@Transactional
	public HashMap<String, Object> searchHotelToSearchBar(ClientSearchHotelDTO requestDTO) {
		HashMap<Object, Object> map = new HashMap<>();

		map.put("hotelSearchMethod", "hotelListToSearch");
		map.put("searchKeyword", requestDTO.getSearchKeyword());
		map.put("checkInDate", requestDTO.getCheckInDate());
		map.put("checkOutDate", requestDTO.getCheckOutDate());
		map.put("people", requestDTO.getPeople());
		map.put("area", requestDTO.getArea());
		map.put("concept", requestDTO.getConcept());

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
		int count = clientSearchHotelDAO.getCountToHotelList(map);
		hotelMap.put("reservationInDate", requestDTO.getCheckInDate());
		hotelMap.put("reservationOutDate", requestDTO.getCheckOutDate());
		hotelMap.put("pagination", new PaginationHotelList(count,1));
		hotelMap.put("pageNum", 1);
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		System.out.println("hotelMap : " + hotelMap);
		return hotelMap;
	}

	// 호텔 리스트 결과 필터 적용
	@Override
	@Transactional
	public HashMap<String, Object> searchHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod) {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 1);
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


		String checkInDate = null;
		String checkOutDate = null;

		if(hotelSearchMethod.equals("hotelListAll")) {
			checkInDate = simpleDateFormat.format(new Date());
			checkOutDate = simpleDateFormat.format(cal.getTime());
			map.put("checkInDate", checkInDate);
			map.put("checkOutDate", checkOutDate);

			map.put("hotelSearchMethod", "hotelListAll");

			hotelList = clientSearchHotelDAO.searchHotelAll(map);
		}
		else {
			ClientSearchHotelDTO searchQuery = (ClientSearchHotelDTO) hotelSearchMethod;
			checkInDate = searchQuery.getCheckInDate();
			checkOutDate = searchQuery.getCheckOutDate();
			map.put("hotelSearchMethod", "hotelListToSearch");
			map.put("searchKeyword", searchQuery.getSearchKeyword());
			if(searchQuery.getCheckInDate() == null) {
				checkInDate = simpleDateFormat.format(new Date());
				checkOutDate = simpleDateFormat.format(cal.getTime());
				map.put("checkInDate", checkInDate);
				map.put("checkOutDate", checkOutDate);
			} else {
				map.put("checkInDate", searchQuery.getCheckInDate());
				map.put("checkOutDate", searchQuery.getCheckOutDate());
			}
			map.put("people", searchQuery.getPeople());
			map.put("area", searchQuery.getArea());
			map.put("concept", searchQuery.getConcept());
			System.out.println(map);
			hotelList = clientSearchHotelDAO.searchHotelToSearchBar(map);
		}
		System.out.println(hotelList);
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

		hotelMap.put("reservationInDate", checkInDate);
		hotelMap.put("reservationOutDate", checkOutDate);

		int count = clientSearchHotelDAO.getCountToHotelList(map);
		hotelMap.put("pagination", new PaginationHotelList(count,1));
		hotelMap.put("pageNum", 1);
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);
		System.out.println("hotelMap : " + hotelMap);
		return hotelMap;
	}

	// 호텔리스트 페이지 이동
	@Override
	@Transactional
	public HashMap<String, Object> movePageToHotelList(ClientHotelFilterDTO hotelFillter, Object hotelSearchMethod, String filter) {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, 1);
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
		String checkInDate = null;
		String checkOutDate = null;

		if(hotelSearchMethod.equals("hotelListAll")) {
			map.put("hotelSearchMethod", "hotelListAll");
			checkInDate = simpleDateFormat.format(new Date());
			checkOutDate = simpleDateFormat.format(cal.getTime());
			map.put("checkInDate", checkInDate);
			map.put("checkOutDate", checkOutDate);

			hotelList =  clientSearchHotelDAO.searchHotelAll(map);
		} else {
			ClientSearchHotelDTO searchQuery = (ClientSearchHotelDTO) hotelSearchMethod;
			map.put("hotelSearchMethod", "hotelListToSearch");
			map.put("searchKeyword",  searchQuery.getSearchKeyword());
			if(searchQuery.getCheckInDate() == null) {
				checkInDate = simpleDateFormat.format(new Date());
				checkOutDate = simpleDateFormat.format(cal.getTime());
				map.put("checkInDate", checkInDate);
				map.put("checkOutDate", checkOutDate);
			} else {
				map.put("checkInDate", searchQuery.getCheckInDate());
				map.put("checkOutDate", searchQuery.getCheckOutDate());
			}

			map.put("people", searchQuery.getPeople());
			map.put("area", searchQuery.getArea());
			map.put("concept", searchQuery.getConcept());

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
		System.out.println("map : " + map);

		hotelMap.put("reservationInDate", checkInDate);
		hotelMap.put("reservationOutDate", checkOutDate);

		int count = clientSearchHotelDAO.getCountToHotelList(map);
		hotelMap.put("pagination", new PaginationHotelList(count,hotelFillter.getPageNum()));
		hotelMap.put("pageNum", hotelFillter.getPageNum());
		hotelMap.put("pageSize", hoteListPageSize);
		hotelMap.put("pageBlock", pageBlock);

		System.out.println("hotelMap : " + hotelMap);
		return hotelMap;
	}

	// 호텔 리뷰 목록 조회
	public Map<String, Object> searchHotelReviewList(String jsonParam) throws ParseException {
		String hotelId = (String)((JSONObject) new JSONParser().parse(jsonParam)).get("hotelId");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("hotelReviewList", clientSearchHotelDAO.searchHotelReviewList(hotelId));
		System.out.println("리뷰 : " + resultMap);
		return resultMap;
	}


}
