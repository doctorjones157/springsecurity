package com.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.security.model.Roles;
import com.security.model.User;
import com.security.service.UserService;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent>  {

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("listner call..............");
		this.userService.saveUser(returnUsers());
		this.userService.getAllUsers();
	}
	
	public List<User> returnUsers(){
		List<User> user = new ArrayList<User>();
		
		Roles r = new Roles();
		r.setUserName("james");
		r.setRoles("EMP");
		

		Roles r1 = new Roles();
		r1.setUserName("raghu");
		r1.setRoles("ADMIN");
		
		List<Roles> roleList = new ArrayList<Roles>();
		roleList.add(r);
		roleList.add(r1);
		
		User u = new User();
		u.setUserName("james");
		u.setPassword("bond");
		u.setRoleList(roleList);

		User u1 = new User();
		u1.setUserName("raghu");
		u1.setPassword("1234");
		
		
		
		
		
		user.add(u);
		user.add(u1);
		return user;
		
	}

	

}
