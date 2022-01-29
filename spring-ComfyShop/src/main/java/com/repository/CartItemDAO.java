package com.repository;

import java.util.List;

import com.model.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);
	void updateCartItem(CartItem cartItem);
	void deleteCartItem(CartItem cartItem);
	void deleteCartItemById(int cartItemId);
	
	CartItem getCartItemById(int cartItemId);
	List<CartItem> getAllCartItems();
	List<CartItem> getAllCartItemsByUsername(String username);
}