package com.jacaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVO;
import com.javaex.vo.JsonResult;

@Controller
@RequestMapping("/apiguestbook")
public class ApiGuestBookController {

	@Autowired
	private GuestBookService guestBookService;
	@Autowired
	private GuestBookVO guestBookVO;
	
 //------------------- 방명록 첫페이지(ajax로 리스트 출력)
	
	@RequestMapping(value = "/guestBookForm2", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestBookForm2() {
		System.out.println("apiguestBookForm2");
	
		return "/apiguestbook/apiaddList2";
	}
	
	//ajax 전체리스트 가지고오기
	@RequestMapping(value = "/guestBookList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonResult guestBookList() {
		System.out.println("guestBookList");
		
		List<GuestBookVO> guestBookList = guestBookService.getGuestBookList();
		
		JsonResult jsonResult = new JsonResult();
		
		jsonResult.success(guestBookList);
		
		return jsonResult;
	}
	
	@RequestMapping(value = "/addList2", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonResult addList2(@RequestBody GuestBookVO vo) { //RequestBody는 JSON형식으로 변환된걸 받는방법
		System.out.println("apiaddList2");
		
		guestBookVO = guestBookService.addGuest(vo);
		
		JsonResult jsonResult = new JsonResult();
				 
		jsonResult.success(guestBookVO);
		

		return jsonResult;
	}
	

	
	
	
	
	
	
//----------------------- 기존 방식 ------------------------
	//방명록 등록 폼
	@RequestMapping(value = "/guestBookForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestBookForm(Model model) {
		System.out.println("apiguestBookForm");
		
		List<GuestBookVO> guestBookList = guestBookService.getGuestBookList();
		model.addAttribute("guestBookList", guestBookList);
	
		return "/apiguestbook/apiaddList";
	}

	//방명록 등록
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonResult addList(@ModelAttribute GuestBookVO vo) {
		System.out.println("apiaddList");
				
		guestBookVO = guestBookService.addGuest(vo);
		
		JsonResult jsonResult = new JsonResult();
				 
		jsonResult.success(guestBookVO);
		

		return jsonResult;
	}
	
	//방명록 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonResult delete(@ModelAttribute GuestBookVO vo) {
		System.out.println("delete");
					
		int row = guestBookService.deleteGuestBook(vo);
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(row);
		
		return jsonResult;
	}

}






