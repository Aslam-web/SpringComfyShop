package com.repository;

import java.util.List;

import com.model.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);
	void updateCartItem(CartItem cartItem);
	void updateCartItemByPaymentStatus(int cartItemId, String status);
	
	void deleteCartItem(CartItem cartItem);
	void deleteCartItemById(int cartItemId);
	void deleteCartItemsByUsername(String username);
	
	CartItem getCartItemById(int cartItemId);
	List<CartItem> getAllCartItems();
	List<CartItem> getAllCartItemsByUsername(String username);
	List<CartItem> getUserCartItemsByPaymentStatus(String username, String paymentStatus);
}