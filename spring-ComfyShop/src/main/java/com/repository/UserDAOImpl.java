package com.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sf;

	private Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Override
	public void addUser(User user) {
		getSession().persist(user);
	}

	@Override
	public void updateUser(User user) {
		User entity = getSession().get(User.class, user.getEmail());
		if (entity != null) {
			entity.setPassword(user.getPassword());
			entity.setName(user.getName());
			entity.setRole(user.getRole());
			entity.setAddress(user.getAddress());
			getSession().persist(entity);
		} else {
			System.out.println("No such User exists in database");
		}
	}

	@Override
	public void deleteUser(User user) {
		getSession().delete(user);
	}

	@Override
	public void deleteUserByEmail(String email) {
		User entity = getSession().get(User.class, email);
		if (entity != null) {
			getSession().delete(entity);
		} else {
			System.out.println("No such User exists in database");
		}
	}

	@Override
	public User getUserByEmail(String email) {
		User entity = getSession().get(User.class, email);
		if (entity != null) {
			return entity;
		} else {
			System.out.println("No such user exists in database");
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return criteria.list();
	}

	@Override
	public boolean isActive(String email) {
		User entity = getSession().get(User.class, email);
		if(entity!=null) {
			return entity.isActive();
		} else {
			return false;
		}
	}
}