
package com.javaex.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserVO userVO;

	// ---------------------------- 회원 가입폼 --------------------------------------
	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("joinForm");

		return "/user/joinForm";
	}

	// --------------------------- Ajax 아이디체크 ------------------------------------
	@RequestMapping(value = "/idCheck", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public UserVO idCheck(@RequestParam("id") String id,Model model) {
		System.out.println("idCheck");
		System.out.println(id);
		userVO = userService.idCheck(id);
		System.out.println(userVO);
		
		return userVO;

	}

	// ---------------------------- 회원 가입 --------------------------------------
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVO vo) {
		System.out.println("join");

		String uri = "redirect:/user/joinForm";
		int row = userService.insertUser(vo);
		if (row > 0) {
			uri = "/user/joinOk";
		}
		return uri;
	}

	// ---------------------------- loginForm --------------------------------------
	@RequestMapping(value = "/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("loginForm");

		return "/user/loginForm";
	}

	// ---------------------------- login --------------------------------------
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(HttpSession session, @ModelAttribute UserVO vo) {
		System.out.println("login");

		this.userVO = userService.loginUser(vo);
		String uri;
		if (this.userVO != null) {
			session.setAttribute("user", this.userVO);
			uri = "/main/index";
		} else {
			uri = "redirect:/user/loginForm?result=fail";
		}

		return uri;
	}

	// ---------------------------- logout --------------------------------------
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("logout");
		session.removeAttribute("user");
		session.invalidate();

		return "redirect:/main";
	}

	// ---------------------------- modifyForm
	// --------------------------------------
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("modifyForm");

		userVO = userService.getUser((UserVO) session.getAttribute("user"));
		model.addAttribute("user", userVO);

		return "/user/modifyForm";
	}

	// ---------------------------- modify --------------------------------------
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVO vo) {
		System.out.println("modify");
//		userVO =(UserVO)session.getAttribute("user");
//		vo.setId(userVO.getId());
//		vo.setNo(userVO.getNo());
		userService.updateUser(vo);

		return "redirect:/main";
	}

}
