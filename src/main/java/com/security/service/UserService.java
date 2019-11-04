package com.security.service;

import java.util.List;

import com.security.model.User;

public interface UserService  {
	
	public void saveUser(List<User> userList);
	
	public void getAllUsers();
	
	public User getUserById(User u);

}
