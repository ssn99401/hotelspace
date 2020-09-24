package com.spring.hotelspace.client.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.hotelspace.client.board.service.ClientQNAService;
import com.spring.hotelspace.client.board.service.ClientReplyService;
import com.spring.hotelspace.client.board.vo.ClientQNAVO;
import com.spring.hotelspace.client.board.vo.ClientReplyVO;
import com.spring.hotelspace.common.file.FileService;
import com.spring.hotelspace.common.file.FileVO;

@Controller
public class ClientQNAController {

	@Autowired
	private ClientQNAService clientQNAService;
	@Autowired
	private FileService fileService;
	@Autowired
	private ClientReplyService ClientReplyService;


	@RequestMapping(value = "/AllQNA.do", method = RequestMethod.POST)
	public @ResponseBody List<Object> AllQnABoard(ClientQNAVO qnaVO, Model model) {
		List<Object> QNAList = clientQNAService.AllQNA(qnaVO);
		return QNAList;
	}

	@RequestMapping(value = "/MyQNA.do", method = RequestMethod.POST)
	public @ResponseBody List<Object> MyQnABoard(ClientQNAVO qnavo, Model model) {
		List<Object> MyQNAList = clientQNAService.MyQNA(qnavo);
		return MyQNAList;
	}

	@RequestMapping(value = "/SearchQNA.do", method = RequestMethod.POST)
	public @ResponseBody List<Object> SearchQnABoard(ClientQNAVO qnavo, Model model) {
		List<Object> SearchQNAList = clientQNAService.SearchQNA(qnavo);
		return SearchQNAList;
	}

	@RequestMapping(value = "/clientQNAServiceForm.do", method = RequestMethod.GET)
	public String clientQNAWriteForm() {
		return "board/clientQNAWriteForm";
	}
	@RequestMapping(value = "/clientQNAReadForm.do", method = RequestMethod.GET)
	public String clientQNAReadForm() {
		return "board/clientQNAReadForm";
	}
	@RequestMapping(value = "/QNAInsert.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String QNAInsert(HttpSession session, ClientQNAVO QNAVO, MultipartFile file ) throws Exception {
		
		FileVO nfile = fileService.uploadFile(session.getAttribute("login").toString(), QNAVO.getFile());
		if(nfile!=null) {
		QNAVO.setClaimPhoto(nfile.getSavePath() + nfile.getFileName());
		}
			clientQNAService.QNAInsert(QNAVO);
		
		return "redirect:clientQNAServices.do";
	}

	@RequestMapping(value = "/clientQNAServices.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String clientQNAServices() {
		return "board/clientQNAServices";
	}


	@RequestMapping(value = "/QNAread.do", method = RequestMethod.GET)
	public String QNAread(ClientQNAVO ClientQNAVO, Model model,ClientReplyVO ClientReplyVO) throws Exception{

		model.addAttribute("read", clientQNAService.QNAread(ClientQNAVO.getClaimNum()));

		return "board/clientQNAReadForm";
	}
	@RequestMapping(value = "/clientQNAUpdateForm.do", method = RequestMethod.GET)
	public String clientQNAUpdateForm(ClientQNAVO ClientQNAVO, Model model) throws Exception {
		model.addAttribute("update", clientQNAService.QNAread(ClientQNAVO.getClaimNum()));
		return "board/clientQNAUpdateForm";
	}
	@RequestMapping(value = "/QNAupdate.do", method = RequestMethod.POST)
	public String QNAupdate(ClientQNAVO QNAVO)throws Exception{
		clientQNAService.QNAupdate(QNAVO);
		return "redirect:clientQNAServices.do";

	}
	@RequestMapping(value = "/QNAdelete.do", method = RequestMethod.GET)
	public String QNAdelete(int claimNum,RedirectAttributes rttr)throws Exception{

		clientQNAService.QNAdelete(claimNum);

		return "redirect:clientQNAServices.do";
	}
	/*
	 * clientQNAService.QNAdelete(claimNum); return "redirect:clientQNAServices.do";
	 * 
	 * }
	 */
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	@SuppressWarnings({ "unchecked", "rawtypes"})
	@RequestMapping(value= "/Replylist.do", method = RequestMethod.GET , produces="application/json; charset=utf8") //댓글리스트
	@ResponseBody
	public ResponseEntity ajax_Replylist(@ModelAttribute("ClientReplyVO") ClientReplyVO ClientReplyVO, HttpServletRequest request
			) throws Exception{


		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		List<ClientReplyVO> commentVO = ClientReplyService.ReplyAll(ClientReplyVO);


		if(commentVO.size() > 0){
			for(int i=0; i<commentVO.size(); i++){
				HashMap hm = new HashMap();
				
				
				hm.put("replyDate", commentVO.get(i).getReplyDate());
				hm.put("replyNum", commentVO.get(i).getReplyNum());
				hm.put("replyContent", commentVO.get(i).getReplyContent());
				hm.put("clientName", commentVO.get(i).getClientName());
				hm.put("clientId", commentVO.get(i).getClientId());
				hm.put("replyAdate", commentVO.get(i).getreplyAdate());
				hmlist.add(hm);
			}

		}
		return new ResponseEntity(hmlist,HttpStatus.CREATED);
	}

	@RequestMapping(value=  "/ReplyInsert.do", method = RequestMethod.POST )
	@ResponseBody
	public String ajax_Replyinsert(@ModelAttribute("ClientReplyVO") ClientReplyVO ClientReplyVO,Model model) 
			throws Exception{


		ClientReplyService.ReplyInsert(ClientReplyVO);
		return "redirect:Replylist.do";
	}


	@RequestMapping(value = "/ReplyUpdate.do", method = RequestMethod.GET ) //댓글 수정
	public String ReplyUpdate(ClientReplyVO RVO) throws Exception{

		ClientReplyService.ReplyUpdate(RVO);

		return "redirect:Replylist.do";
	}

	@RequestMapping(value = "/ReplyDelete.do", method =  RequestMethod.GET) //댓글 삭제
	public String ReplyDelete(int replyNum) throws Exception{

		ClientReplyService.ReplyDelete(replyNum);

		return "redirect:Replylist.do";
	}

}