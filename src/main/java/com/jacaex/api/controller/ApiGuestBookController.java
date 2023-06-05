package com.jacaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/guestBookForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestBookForm(Model model) {
		System.out.println("apiguestBookForm");
		
		List<GuestBookVO> guestBookList = guestBookService.getGuestBookList();
		model.addAttribute("guestBookList", guestBookList);
	
		return "/apiguestbook/apiaddList";
	}

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonResult addList(@ModelAttribute GuestBookVO vo) {
		System.out.println("apiaddList");
				
		guestBookVO = guestBookService.addGuest(vo);
		
		JsonResult jsonResult = new JsonResult();
				 
		jsonResult.success(guestBookVO);
		

		return jsonResult;
	}

}
