package com.javaex.controller;

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
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	private GuestBookService guestBookService;

	@RequestMapping(value = "/guestBookForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestBookForm(Model model) {
		System.out.println("guestBookForm");

		List<GuestBookVO> guestBookList = guestBookService.getGuestBookList();
		model.addAttribute("guestBookList", guestBookList);

		return "/guestbook/addList";
	}

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(@ModelAttribute GuestBookVO vo) {
		System.out.println("addList");
		int row = guestBookService.addList(vo);

		return "redirect:/guestbook/guestBookForm";
	}

	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@ModelAttribute GuestBookVO vo, Model model) {
		System.out.println("deleteForm");

		model.addAttribute("guestBook", vo);

		return "/guestbook/deleteForm";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestBookVO vo,Model model) {
		System.out.println("delete");
		
		model.addAttribute("guestBook", vo);
		String uri = "/guestbook/deleteForm";
		int row = guestBookService.deleteGuestBook(vo);
		if(row >0) {
			uri = "redirect:/guestbook/guestBookForm";
		}
		return uri;
	}

}
