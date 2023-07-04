package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/mylogin")
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	public String showloginpage() {
		return "loginpage";
	}

	@PostMapping("/validate")
	public ModelAndView validateUser(HttpSession session, @RequestParam("uname") String unm,
			@RequestParam String passwd) {

		MyUser u1 = loginService.validateUser(unm, passwd);

		if (u1 != null) {
//			return new ModelAndView("hello", "msg", "Success");
			session.setAttribute("user", u1);
			return new ModelAndView("redirect:/product/viewproduct");
		} else {
			return new ModelAndView("loginpage", "msg", "Please re-enter credentials");
		}
	}
}
