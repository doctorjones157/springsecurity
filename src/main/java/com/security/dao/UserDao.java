package com.security.dao;

import java.util.List;

import com.security.model.User;

public interface UserDao {

	void saveUser(List<User> userList);

	void getAllUsers();

	User getUserById(User u);

}
