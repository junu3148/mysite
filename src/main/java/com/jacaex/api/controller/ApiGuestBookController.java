package com.jacaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestBookService;
import com.javaex.vo.GuestBookVO;

@Controller
@RequestMapping("/apiguestbook")
public class ApiGuestBookController {

	@Autowired
	private GuestBookService guestBookService;

	@RequestMapping(value = "/guestBookForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestBookForm(Model model) {
		System.out.println("apiguestBookForm");

		List<GuestBookVO> guestBookList = guestBookService.getGuestBookList();
		model.addAttribute("guestBookList", guestBookList);

		return "/apiguestbook/apiaddList";
	}

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(@ModelAttribute GuestBookVO vo) {
		System.out.println("addList");
		int row = guestBookService.addList(vo);

		return "redirect:/apiguestbook/guestBookForm";
	}

}
