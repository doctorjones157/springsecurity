package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.security.model.User;
import com.security.service.UserService;

@Controller
public class LoginController {
	
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/login")
	public String login(ModelMap map) {
		System.out.println("hit...........");
		map.put("emp", new User());
		return "login";
	}
	
	/*
	 * @PostMapping("/submit") public String submit(@ModelAttribute("emp") User
	 * user){ System.out.println(user.toString());
	 * this.userService.getUserById(user); return "success"; }
	 */
}
