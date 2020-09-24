package com.spring.hotelspace.admin.management.hotel.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.hotelspace.admin.management.hotel.dao.AdminHotelManagerDAO;
import com.spring.hotelspace.admin.management.hotel.service.AdminHotelManagerService;
import com.spring.hotelspace.admin.management.hotel.vo.AdminHotelImageVO;
import com.spring.hotelspace.admin.management.hotel.vo.AdminRoomVO;
import com.spring.hotelspace.common.file.FileService;
import com.spring.hotelspace.common.file.FileVO;
import com.spring.hotelspace.common.json.JsonMapperService;

@Service
public class AdminHotelManagerServiceImpl implements AdminHotelManagerService {

	@Autowired
	private AdminHotelManagerDAO adminHotelManagerDAO;

	@Autowired
	private FileService fileService;

	@Autowired
	private JsonMapperService jsonMapperService;

	private final static int pageBlock = 2;

	// 관리자 호텔목록 조회  메서드
	@Transactional
	public Map<String, Object> getAdminHotelList(String jsonParam) throws ParseException {

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);

		int pageNum = Integer.parseInt((String)jsonObject.get("pageNum"));
		int pageSize = Integer.parseInt((String)jsonObject.get("pageSize"));
		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);

		requestMap.put("start", ""+ (pageSize * (pageNum - 1) + 1));
		requestMap.put("end", "" + (pageSize * pageNum));

		System.out.println("requestMap : " + requestMap);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("hotelList", adminHotelManagerDAO.getAdminHotelList(requestMap));
		resultMap.put("count", adminHotelManagerDAO.getAdminHotelListCount(requestMap));
		resultMap.put("pageBlock",pageBlock);
		resultMap.put("pageNum", pageNum);
		resultMap.put("pageSize", pageSize);
		resultMap.put("pageBlock", pageBlock);
		System.out.println(resultMap);
		return resultMap;
	}

	// 관리자 호텔 정보 조회 메서드
	@Transactional
	public Map<String, Object> getAdminHotelInfo(String jsonParam) throws ParseException {

		String hotelId = (String)((JSONObject) new JSONParser().parse(jsonParam)).get("hotelId");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AdminRoomVO> hotelRoomList = null;

		resultMap.put("hotelInfo", adminHotelManagerDAO.getAdminHotelInfo(hotelId));
		resultMap.put("hotelPictures", adminHotelManagerDAO.getAdminHotelImageList(hotelId));

		hotelRoomList = adminHotelManagerDAO.getAdminRoomList(hotelId);
		if(hotelRoomList.size() == 0) {
			resultMap.put("hotelRoomList", "empty");
			resultMap.put("roomPictures", "empty");
		} else {
			resultMap.put("hotelRoomList", hotelRoomList);
			resultMap.put("roomPictures", adminHotelManagerDAO.getAdminRoomImageList(hotelRoomList));
		}

		return resultMap;
	}

	// 호텔 정보 업데이트 요청처리 메서드
	public int updateHotelInfo(String jsonParam) throws ParseException  {
		System.out.println(jsonParam);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);

		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);

		return adminHotelManagerDAO.updateHotelInfo(requestMap);
	}

	// 방 정보 업데이트 요청처리 메서드
	public int updateRoomInfo(String jsonParam) throws ParseException  {
		System.out.println(jsonParam);
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);

		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);

		return adminHotelManagerDAO.updateRoomInfo(requestMap);
	}

	// 호텔 파일 업로드 요청처리 메서드
	public String uploadHotelImage(MultipartHttpServletRequest files) throws IOException, Exception {

		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyMMddHHmmss"); 
		String hotelId = "H" + simpleDataFormat.format(new Date());
		// 이미지 파일 서버 업로드

		List<FileVO> fileList = fileService.uploadFilesToIterator(hotelId, files);
		System.out.println(fileList);
		List<AdminHotelImageVO> pageImageList = new ArrayList<AdminHotelImageVO>();
		AdminHotelImageVO pageImage = new AdminHotelImageVO(hotelId, fileList.get(0).getSavePath() + fileList.get(0).getFileName(), "MAIN");
		pageImageList.add(pageImage); 
		for(int i = 1; i < fileList.size(); i++) {
			pageImage = new AdminHotelImageVO(hotelId,
					fileList.get(i).getSavePath() + fileList.get(i).getFileName(), "NORMAL");
			pageImageList.add(pageImage); } 
		int result = adminHotelManagerDAO.uploadHotelImage(pageImageList);

		return hotelId;
	}

	// 호텔 등록 요청처리 메서드
	public int uploadHotel(String jsonParam) throws ParseException  {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);
		int result = adminHotelManagerDAO.uploadHotel(requestMap);

		return result;
	}

	// 방 파일 업로드 요청처리 메서드
	public String uploadRoomImage(MultipartHttpServletRequest files) throws IOException, Exception {
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyMMddHHmmss"); 
		String roomId = "R" + simpleDataFormat.format(new Date());

		Iterator<String> filesIterator = files.getFileNames(); 
		String hotelId = (String) filesIterator.next();

		List<FileVO> fileList = fileService.uploadFilesToIterator(hotelId + "/" + roomId, files);
		System.out.println(fileList);
		List<AdminHotelImageVO> pageImageList = new ArrayList<AdminHotelImageVO>();
		AdminHotelImageVO pageImage = new AdminHotelImageVO(roomId, fileList.get(0).getSavePath() + fileList.get(0).getFileName(), "MAIN");
		pageImageList.add(pageImage); 
		for(int i = 1; i < fileList.size(); i++) {
			pageImage = new AdminHotelImageVO(roomId,
					fileList.get(i).getSavePath() + fileList.get(i).getFileName(), "NORMAL");
			pageImageList.add(pageImage); } 
		int result = adminHotelManagerDAO.uploadRoomImage(pageImageList);

		return roomId + "," + hotelId;
	}

	// 방 등록 요청처리 메서드
	public int uploadRoom(String jsonParam) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);
		int result = adminHotelManagerDAO.uploadRoom(requestMap);

		return result;
	}

	// 호텔 삭제 요청 처리 메서드
	public int deleteHotel(String jsonParam) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);
		return adminHotelManagerDAO.deleteHotel(requestMap.get("hotelId"));
	}

	// 방 삭제 요청 처리 메서드
	public int deleteRoom(String jsonParam) throws ParseException{
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonParam);
		Map<String, String> requestMap = jsonMapperService.convertJsonObjectToMap(jsonObject);
		return adminHotelManagerDAO.deleteRoom(requestMap.get("roomId"));
	}

}
