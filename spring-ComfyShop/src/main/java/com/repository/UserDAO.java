package com.repository;

import java.util.List;

import com.model.User;

public interface UserDAO {

	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	void deleteUserByEmail(String email);

	User getUserByEmail(String email);	
	List<User> getAllUsers();
	
	boolean isActive(String email);
}