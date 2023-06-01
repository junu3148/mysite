
package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVO;

@Controller
@RequestMapping("/rboard")
public class RboardController {

	@Autowired
	private RboardService rboardService;
	@Autowired
	private RboardVO rboardVO;

	// ------------------- list --------------------
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("list");

		model.addAttribute("rboardList", rboardService.getRboardList());

		return "/rboard/list";
	}

	// ------------------- rwriteForm --------------------
	@RequestMapping(value = "/rwriteForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String rwriteForm(@PathVariable("no") int no,@ModelAttribute RboardVO vo,Model model) {
		System.out.println("rwriteForm");

		String uri = "/rboard/rwriteForm";
		if (no == 2) {
			model.addAttribute("rboard",rboardService.modifyRboard(vo));
			uri = "/rboard/rwriteForm2";
		}
		return uri;
	}

	// ------------------- rwrite --------------------
	@RequestMapping(value = "/rwrite", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute RboardVO vo) {
		System.out.println("rwrite");

		rboardService.insertRboard(vo);

		return "redirect:/rboard/list";
	}

	// ------------------- rwrite2 --------------------
	@RequestMapping(value = "/rwriteComm", method = { RequestMethod.GET, RequestMethod.POST })
	public String rwriteComm(@ModelAttribute RboardVO vo) {
		System.out.println("rwriteComm");

		rboardService.insertRboardComm(vo);

		return "redirect:/rboard/list";
	}

	// ------------------- delete --------------------
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute RboardVO vo) {
		System.out.println("delete");

		int row = rboardService.deleteRboard(vo);

		return "redirect:/rboard/list";
	}

	// ------------------- readForm --------------------
	@RequestMapping(value = "/readForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String readForm(@ModelAttribute RboardVO vo, Model model) {
		System.out.println("readForm");

		rboardVO = rboardService.modifyRboard(vo);

		model.addAttribute("rboard", rboardVO);


		return "/rboard/read";
	}
	
	// ------------------- modifyForm --------------------
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@ModelAttribute RboardVO vo, Model model) {
		System.out.println("modifyForm");

		String uri = "/rboard/read";
		
		rboardVO = rboardService.modifyRboard(vo);

		if (vo.getUserNo() == rboardVO.getUserNo()) {
			model.addAttribute("rboard", rboardVO);
			uri = "/rboard/modifyForm";
		}
		return uri;
	}
	
	// ------------------- modify --------------------
		@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
		public String modify(@ModelAttribute RboardVO vo, Model model) {
			System.out.println("modify");

			int row = rboardService.updateRboard(vo);

			return "redirect:/rboard/list";
		}

}
