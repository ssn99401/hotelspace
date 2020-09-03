package com.spring.hotelspace.admin.management.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hotelspace.admin.management.user.service.AdminManageClientService;
import com.spring.hotelspace.admin.management.user.vo.AdminManageClientVO;

@Controller
public class AdminManageClientController {

	@Autowired
	private AdminManageClientService adminManageClientService;

	@RequestMapping(value = "/clientManagement.mdo", method = RequestMethod.GET)
	public String clientTable(AdminManageClientVO vo, Model model) {

		List<AdminManageClientVO> clientList = adminManageClientService.getClientList(vo);

		model.addAttribute("clientList", clientList);

		return "management/clientManagementPage/adminTable";

	}

	@RequestMapping(value = "/togglebutton.mdo", method = { RequestMethod.GET, RequestMethod.POST })
	public String togglebutton(AdminManageClientVO vo, Model model,
			@RequestParam(value = "state[]", required = false) String[] state,
			@RequestParam(value = "Nstate[]", required = false) String[] Nstate) {

		System.out.println("컨트롤러가 받음");
		

		List<AdminManageClientVO> clientList = adminManageClientService.getClientList(vo);
		model.addAttribute("clientList", clientList);

		System.out.println(clientList.size() + "clientList.size");
		System.out.println(state.length + "state.size");
		ArrayList<AdminManageClientVO> arr = new ArrayList<AdminManageClientVO>();// active id array

		ArrayList<AdminManageClientVO> Narr = new ArrayList<AdminManageClientVO>();// ban id array

		for (int i = 0; i < state.length; i++) {
			arr.add(clientList.get(Integer.parseInt(state[i]) - 1));
			System.out.println(arr.get(i).getClientID());
		}

		if (Nstate == null || Nstate.length==0) {
			
		}else {
			for (int i = 0; i < Nstate.length; i++) {
				Narr.add(clientList.get(Integer.parseInt(Nstate[i]) - 1));
				System.out.println(Narr.get(i).getClientID());
			}
			
		}
		adminManageClientService.getState(arr, Narr, vo);

		clientList = adminManageClientService.getClientList(vo);

		// vo에서 0인 행의 id 조회
		// id로 update mapper연결 후 리턴

		return "redirect:clientManagement.mdo";

	}

}
