package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/hello")
	public String saqyHello() {
		System.out.println("Inside heelo....");
		return "hello";
	}
}
