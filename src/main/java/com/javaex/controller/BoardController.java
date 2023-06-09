
package com.javaex.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;
import com.javaex.vo.Criteria;
import com.javaex.vo.PageMakerDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardVO boardVO;

	// ------------------- list --------------------
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, @ModelAttribute Criteria cri) {
		System.out.println("list");

		model.addAttribute("boardList", boardService.getBoardList(cri));

		int total = boardService.getTotal(cri);

		PageMakerDTO pageMaker = new PageMakerDTO(cri, total);

		model.addAttribute("pageMaker", pageMaker);

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

	// ------------------- serchBoard -------------------- //사용안함
	@RequestMapping(value = "/serchBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public String serchBoard(@ModelAttribute Criteria cri, Model model) {
		System.out.println("list");

		model.addAttribute("boardList", boardService.getBoardList(cri));

		model.addAttribute("pageMaker", new PageMakerDTO(cri, boardService.getTotal(cri)));

		return "/board/list";
	}

	// ------------------- readForm --------------------
	@RequestMapping(value = "/readForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String readForm(@ModelAttribute BoardVO vo, Model model) {
		System.out.println("readForm");

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
