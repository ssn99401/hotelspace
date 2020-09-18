package com.spring.hotelspace.admin.management.page.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.hotelspace.admin.management.page.service.AdminPageManagerService;
import com.spring.hotelspace.admin.management.page.vo.AdminPageImageVO;

@Controller
public class AdminPageManagerController {

	@Autowired
	private AdminPageManagerService adminPageManagerService;

	// 페이지 사진 관리 view
	@RequestMapping(value = "/pageManagement.mdo", method =  RequestMethod.GET)
	public String showIndexPage(Model model) {

		model.addAttribute("imageList",adminPageManagerService.getImageLinkList());

		return "management/webViews/managementWebView";
		//		return "adminChart";
	}

	// 페이지 사진 관리 onload 이미지
	@RequestMapping(value = "/pageImageList.mdo", method =  RequestMethod.GET)
	public @ResponseBody List<AdminPageImageVO> getImageListToWebPage() {
		List<AdminPageImageVO> list = adminPageManagerService.getImageLinkList();
		return list;
		//		return "adminChart";
	}


	// 페이지 관리 사진 업로드
	@RequestMapping(value = "uploadPageImage.mdo", method = RequestMethod.POST)
	public String searchHotelToConcept(MultipartHttpServletRequest files) throws IOException, Exception {
		adminPageManagerService.uploadImageToServer(files);

		return "redirect:pageImageList.mdo";
	}

	// 페이지 사진 변경
	@RequestMapping(value = "changeImage.mdo", method = RequestMethod.POST)
	public String changePageImage(@RequestBody String jsonParam) throws ParseException  {
		
		int result = adminPageManagerService.changePageImage(jsonParam);
		return "redirect:pageImageList.mdo";
	}
	// 페이지 사진 삭제
	@RequestMapping(value = "deleteImage.mdo", method = RequestMethod.POST)
	public String deletePageImage(@RequestBody List<Map> arrJson) throws ParseException  {
		
		int result = adminPageManagerService.deletePageImage(arrJson);
		return "redirect:pageImageList.mdo";
	}

	
}
