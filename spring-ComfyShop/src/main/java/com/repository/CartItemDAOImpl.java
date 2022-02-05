package com.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.CartItem;

@Repository("cartItemDao")
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	SessionFactory sf;

	private Session getSession() {
		return sf.getCurrentSession();
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		getSession().persist(cartItem);
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		CartItem entity = getSession().get(CartItem.class, cartItem.getCartItemId());
		if (entity != null) {
			entity.setPaymentStatus(cartItem.getPaymentStatus());
			entity.setPrice(cartItem.getPrice());
			entity.setProductId(cartItem.getProductId());
			entity.setProductName(cartItem.getProductName());
			entity.setQuantity(cartItem.getQuantity());
			entity.setUsername(cartItem.getUsername());
			getSession().persist(entity);
		} else {
			System.out.println("No such CartItem exists in database");
		}
	}
	
	@Override
	public void updateCartItemByPaymentStatus(int cartItemId, String status) {
		CartItem entity = getSession().get(CartItem.class, cartItemId);
		if (entity != null) {
			entity.setPaymentStatus(status);
			getSession().persist(entity);
		} else {
			System.out.println("No such CartItem exists in database");
		}
	}

	@Override
	public void deleteCartItem(CartItem cartItem) {
		getSession().delete(cartItem);
	}

	@Override
	public void deleteCartItemById(int cartItemId) {
		CartItem entity = getSession().get(CartItem.class, cartItemId);
		if (entity != null) {
			getSession().delete(entity);
		} else {
			System.out.println("No such CartItem exists in database");
		}
	}
	
	@Override
	public void deleteCartItemsByUsername(String username) {
		Query query = getSession().createQuery("delete from cartItem where username=:username");
		query.setParameter("username", username);
		query.executeUpdate();
	}

	@Override
	public CartItem getCartItemById(int cartItemId) {
		CartItem entity = getSession().get(CartItem.class, cartItemId);
		if (entity != null) {
			return entity;
		} else {
			System.out.println("No such CartItem exists in database");
			return null;
		}
	}

	@Override
	public List<CartItem> getAllCartItems() {
		Criteria criteria = getSession().createCriteria(CartItem.class);
		return criteria.list();
	}

	@Override
	public List<CartItem> getAllCartItemsByUsername(String username) {
		Criteria criteria = getSession().createCriteria(CartItem.class);
		criteria.add(Property.forName("username").eq(username));
		return criteria.list();
	}
	
	@Override
	public List<CartItem> getUserCartItemsByPaymentStatus(String username, String paymentStatus) {
		Criteria criteria = getSession().createCriteria(CartItem.class);
		criteria.add(Property.forName("username").eq(username));
		criteria.add(Property.forName("paymentStatus").eq(paymentStatus));
		return criteria.list();
	}
}