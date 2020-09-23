
package com.spring.hotelspace.admin.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hotelspace.admin.main.service.AdminMainService;
import com.spring.hotelspace.admin.main.vo.AdminMainVO;
import com.spring.hotelspace.admin.main.vo.ReservationDataVO;

@Controller
public class AdminMainController {

	@Autowired
	AdminMainService adminMainService;

	@RequestMapping(value = "/index.mdo", method = RequestMethod.GET)
	public String showIndexPage() {

		return "adminIndex";
	}

	@RequestMapping(value = "/main.mdo", method = RequestMethod.GET)
	public String getMainPage(Model model) {

		// 맨 윗 줄-------------------------------------------------
		int hotelCount = adminMainService.gethotelCount();// 총 호텔수
		int resCount = adminMainService.getresCount();// 예약 건 수
		int userCount = adminMainService.getuserCount();// 유저 수

		System.out.println("hotelcount :" + hotelCount);
		model.addAttribute("hotelCount", hotelCount);
		model.addAttribute("resCount", resCount);
		model.addAttribute("userCount", userCount);

		// 월별 예약 통계(최초 로드 화면 : Sales)-------------------------------------------------
/*		String month[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };// 월
		ArrayList<Integer> monthly = new ArrayList<Integer>();// 월별 예약건수 컬렉션

		for (int i = 0; i < month.length; i++) {// 월별 예약건수를 arrayList에 넣기

			int Sales = Integer.parseInt(adminMainService.getReservation(month[i]));
			monthly.add(Sales);
			System.out.println(Sales);
		}

		for (int i = 0; i < month.length; i++) {// 월별 예약건수 scope에 적재

			model.addAttribute(month[i], monthly.get(i));
		}
		for (int i = 0; i < month.length; i++) {// 월별 예약건수를 arrayList에 넣기

			int Sales = Integer.parseInt(adminMainService.getReservation2019(month[i]));
			monthly.add(Sales);
			System.out.println(Sales);
		}

		for (int i = 0; i < month.length; i++) {// 월별 예약건수 scope에 적재
			String name = "s" + month[i];
			model.addAttribute(name, monthly.get(i));
		}*/

		// 월별 예약 통계(최초 로드 화면 : Sales)-------------------------------------------------
		ArrayList<ReservationDataVO> getData=adminMainService.getData();
		int array[][]= {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}};
		System.out.println(getData);
		
		for (ReservationDataVO e : getData) {
			System.out.println(e.getYear());
			if(e.getYear().equals("2020")) {
				int m = Integer.parseInt(e.getMonth());
				array[0][m-1] = e.getCount();//예약 건수
				System.out.println("count : "+e.getCount());
				
			}else {
				int m = Integer.parseInt(e.getMonth());
				array[1][m-1] = e.getCount();
				System.out.println("count2 : "+e.getCount());
			}
			
		}
		model.addAttribute("getData",array);
		
		//최근 예약 최근 리뷰 불러오기
		model.addAttribute("reservation", adminMainService.getRecentRes());
		model.addAttribute("review", adminMainService.getRecentRev());
		
		
		return "main";
	}

	@RequestMapping(value = "/getChart.mdo", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody ArrayList<Integer> getChart(String option) {

		ArrayList<Integer> monthly = new ArrayList<Integer>();// 월별 예약 컬렉션
		String month[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };// 월

		if (option == null) {
			option = "Reservation";// option이 null일시 초기값 설정
		}

		// 월별 예약 통계(건수,매출)-------------------------------------------------,
		if (option.equals("Reservation")) {

			for (int i = 0; i < month.length; i++) {// 월별 예약건수를 arrayList에 넣기

				int Sales = Integer.parseInt(adminMainService.getReservation(month[i]));
				monthly.add(Sales);
			}
			for (int i = 0; i < month.length; i++) {// 월별 예약건수를 arrayList에 넣기

				int Sales = Integer.parseInt(adminMainService.getReservation2019(month[i]));
				monthly.add(Sales);
			}

		} else {

			for (int i = 0; i < month.length; i++) {// 2020월별 매출을 arrayList에 넣기
				if (adminMainService.getSales(month[i]) == null) {// 매출이 없는 달은 0원
					monthly.add(0);

				} else {
					int Sales = Integer.parseInt(adminMainService.getSales(month[i]));
					monthly.add(Sales);
				}

			}

			for (int i = 0; i < month.length; i++) {// 2019월별 예약건수를 arrayList에 넣기
				if (adminMainService.getSales2019(month[i]) == null) {// 매출이 없는 달은 0원
					monthly.add(0);

				} else {

					int Sales = Integer.parseInt(adminMainService.getSales2019(month[i]));
					monthly.add(Sales);
					System.out.println(Sales + i);

				}

			}

		}

		return monthly;

	}

	@RequestMapping(value = "/navbar.mdo", method = RequestMethod.GET)
	public String getNavBar(Model model) {

		return "adminNavBar";
	}

	@RequestMapping(value = "/sidebar.mdo", method = RequestMethod.GET)
	public String getsideBar(Model model) {

		return "adminSideBar";
	}

	@RequestMapping(value = "/footer.mdo", method = RequestMethod.GET)
	public String getFooter(Model model) {

		return "adminFooter";
	}

}
