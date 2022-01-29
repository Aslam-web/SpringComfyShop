package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;
import com.repository.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Override
	public User getUser(String email) {
		return userDao.getUserByEmail(email);
	}
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public boolean checkUser(User user) {
		User entity = userDao.getUserByEmail(user.getEmail());
		return entity != null ? true : false;
	}

	@Override
	public boolean checkUserByEmail(String email) {
		User entity = userDao.getUserByEmail(email);
		return entity != null ? true : false;
	}

	@Override
	public boolean loginUser(String email, String password) {
		User entity = userDao.getUserByEmail(email);
		if (entity == null) {
			System.out.println("No user with email : " + email);
			return false;
		} else if (entity.getPassword().equals(password)) {
			entity.setActive(true);
			userDao.updateUser(entity);
			return true;
		} else {
			System.out.println("Wrong password. Please try again");
			return false;
		}
	}

	@Override
	public boolean logoutUser(String email) {
		User entity = userDao.getUserByEmail(email);
		if (entity == null) {
			System.out.println("No user with email : " + email);
			return false;
		} else if (entity.isActive() == true) {
			entity.setActive(false);
			userDao.updateUser(entity);
			return true;
		} else {
			System.out.println("The user <" + email + "> is already logged out");
			return false;
		}
	}

}
