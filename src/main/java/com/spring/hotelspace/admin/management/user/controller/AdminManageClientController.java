package com.spring.hotelspace.admin.management.user.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value = "/searchUserIdName.mdo", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchUserIdandName(AdminManageClientVO vo, Model model,HttpServletRequest request) {
		
		String user=null;
		List<AdminManageClientVO> searchList= null;
		if(request.getParameter("type").equals("ID")) {
			 user=request.getParameter("searchUser");
			 System.out.println(user);
			System.out.println("id서치");
			 searchList = adminManageClientService.getSearchIdList(user);

				model.addAttribute("clientList", searchList);
				
		}else if(request.getParameter("type").equals("NAME")) {
			System.out.println(user);
			 user=request.getParameter("searchUser");
			System.out.println("name서치");
			 searchList = adminManageClientService.getSearchNameList(user);

				model.addAttribute("clientList", searchList);
				
		}
		

		
		return "management/clientManagementPage/adminTable";
	}

	
/*	@RequestMapping(value = "/searchId.mdo", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchId(AdminManageClientVO vo, Model model,@RequestParam (value="user") String user) {
		
		//전체리스트 중 찾는 id와 대조하여 맞으면 해당 행의 vo를 새로운 리스트에 담음
		List<AdminManageClientVO> clientList1 = adminManageClientService.getClientList(vo);
		List<AdminManageClientVO> clientList=new ArrayList<AdminManageClientVO>();
		System.out.println(clientList1.size());//9
		
		System.out.println(user);
		for (int i = 0; i < clientList1.size(); i++) {
			if(clientList1.get(i).getClientID().contains(user.replaceAll(" ", ""))) {//데이터가 입력값 중 있으면
				clientList.clear();
				
				
				System.out.println("찾음");
				System.out.println(clientList1.get(i).getClientID());
				
				vo.setClientID(clientList1.get(i).getClientID());
				vo.setClientName(clientList1.get(i).getClientName());
				vo.setClientRegDate(clientList1.get(i).getClientRegDate());
				vo.setClientMilage(clientList1.get(i).getClientMilage());
				vo.setClientState(clientList1.get(i).getClientState());
				
					clientList.add(vo);//vo추가
				
				
			}
		}
		if(user.length()==0) {
			 clientList = adminManageClientService.getClientList(vo);//사이즈 0일때는 전체목록 불러오기
		}
		
		model.addAttribute("clientList", clientList);
		System.out.println(clientList.size());
		return "management/clientManagementPage/adminTable";
		
	}
	@RequestMapping(value = "/searchName.mdo", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchName(AdminManageClientVO vo, Model model,@RequestParam (value="user") String user) {
		
		List<AdminManageClientVO> clientList = adminManageClientService.getSearchName(vo,user);
		model.addAttribute("clientList", clientList);

		return "management/clientManagementPage/adminTable";
		
	}
	*/

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

		return "management/clientManagementPage/adminTable";

	}
	
	



	
	@RequestMapping(value = "/profile.mdo" , method = RequestMethod.GET)
	public String clientProfile(String id, Model model) {
		
		AdminManageClientVO client = adminManageClientService.getClientInfo(id);
		model.addAttribute("client",client);
		
		model.addAttribute("review", adminManageClientService.getClientRev(id));
		model.addAttribute("reservation", adminManageClientService.getClientRes(id));
		
		
		return "management/clientManagementPage/profile";
		
	}
	@RequestMapping(value = "/deleteReview.mdo" , method = RequestMethod.POST)
	public @ResponseBody int deleteReview(String id) {
		
		adminManageClientService.deleteReivew(id);
		
		return 1;
		
	}
}
