package com.javaex.controller;

import java.util.List;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardVO boardVO;

	// ------------------- list --------------------
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list");

		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);

		return "/board/list";
	}

	// ------------------- writeForm --------------------
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("writeForm");

		return "/board/writeForm";
	}

	// ------------------- write --------------------
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVO vo, HttpSession session) {
		System.out.println("write");

		boardService.insertBoard(vo);

		return "redirect:/board/list";
	}

	// ------------------- delete --------------------
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute BoardVO vo) {
		System.out.println("delete");

		int row = boardService.deleteBoard(vo);

		return "redirect:/board/list";
	}

	// ------------------- serchBoard --------------------
	@RequestMapping(value = "/serchBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public String serchBoard(@ModelAttribute BoardVO vo, Model model) {
		System.out.println("list");
		String title = vo.getTitle();

		List<BoardVO> boardList = boardService.serchBoardList(title);
		model.addAttribute("boardList", boardList);

		return "/board/list";
	}

	// ------------------- readForm --------------------
	@RequestMapping(value = "/readForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String readForm(@ModelAttribute BoardVO vo, Model model) {
		System.out.println("readForm");
		System.out.println(vo);

		boardVO = boardService.modifyBoard(vo);

		model.addAttribute("board", boardVO);

		return "/board/read";
	}

	// ------------------- modifyForm --------------------
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@ModelAttribute BoardVO vo, Model model) {
		System.out.println("modifyForm");

		String uri = "/board/read";
		boardVO = boardService.modifyBoard(vo);

		if (vo.getUserNo() == boardVO.getUserNo()) {
			model.addAttribute("board", boardVO);
			uri = "/board/modifyForm";
		}
		return uri;
	}

	// ------------------- modify --------------------
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVO vo, Model model) {
		System.out.println("modify");

		int row = boardService.updateBoard(vo);

		return "redirect:/board/list";
	}

}
