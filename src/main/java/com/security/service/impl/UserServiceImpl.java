package com.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.UserDao;
import com.security.model.User;
import com.security.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	
	public void saveUser(List<User> userList) {
		this.userDao.saveUser(userList);
		
	}

	@Override
	public void getAllUsers() {
		this.userDao.getAllUsers();
		
	}

	@Override
	public User getUserById(User u) {
		// TODO Auto-generated method stub
		return this.userDao.getUserById(u) ;
	}
	
}
