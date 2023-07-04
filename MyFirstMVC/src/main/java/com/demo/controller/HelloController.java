package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
	@RequestMapping("/")
	public String displayhomepage() {
		System.out.println("In display login");
		return "index";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		String message = "This is message from sayHello";
		return new ModelAndView("hello", "msg", message);
	}
}
