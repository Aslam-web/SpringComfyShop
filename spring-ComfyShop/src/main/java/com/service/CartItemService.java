package com.service;

import java.util.List;

import com.model.CartItem;
import com.model.Product;

public interface CartItemService {

	CartItem getCartItemById(int cartItemId);
	List<CartItem> getAllCartItems(String username);
	List<CartItem> getUserCartItemsByPaymentStatus(String username, String paymentStatus);
	
	
	void addCartItem(CartItem cartItem);
	void deleteCartItemsById(int cartItemId);
	void deleteCartItemsByUsername(String username);
	
	void addProductToCart(Product product, String username);
	void removeItemFromCart(int cartItemId);
//	List<CartItem> initiatePaymentForOrder(String username);
	void emptyCart(String username);
	boolean isCartEmpty(String username);
//	int getCartGrandTotal(String username); // to be tested
}