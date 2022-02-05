package com.service;

import com.model.User;

public interface UserService {

	User getUser(String email);
	void addUser(User user);
	boolean checkUser(User user);
	boolean checkUserByEmail(String email);
	boolean loginUser(String email, String password);
	boolean logoutUser(String email);
}
