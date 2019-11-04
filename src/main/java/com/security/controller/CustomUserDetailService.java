package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.User;
import com.security.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService {

	private UserService userService;
	private Converter<User, UserDetails> converter;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	@Qualifier("userToUserDetail")
	public void setConverter(Converter<User, UserDetails> converter) {
		this.converter = converter;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User  u =new User();
		u.setUserName(username);
		u.setPassword("1234");
		System.out.println("Custom User Details.........."+username);
		return this.converter.convert(this.userService.getUserById(u));
	}

}
