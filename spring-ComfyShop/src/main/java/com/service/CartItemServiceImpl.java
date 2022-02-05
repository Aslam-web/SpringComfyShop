package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.CartItem;
import com.model.Product;
import com.repository.CartItemDAO;

@Service("cartItemService")
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemDAO cartItemDao;

	@Override
	public CartItem getCartItemById(int cartItemId) {
		return cartItemDao.getCartItemById(cartItemId);
	}

	@Override
	public List<CartItem> getAllCartItems(String username) {
		return cartItemDao.getAllCartItemsByUsername(username);
	}

	@Override
	public List<CartItem> getUserCartItemsByPaymentStatus(String username, String paymentStatus) {
		List<CartItem> cartItems = cartItemDao.getAllCartItemsByUsername(username);
		cartItems = cartItems.stream().filter(i -> {
			return (i.getPaymentStatus().equals(paymentStatus)) ? true : false;
		}).collect(Collectors.toList());
		return cartItems;
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void removeItemFromCart(int cartItemId) {
		cartItemDao.deleteCartItemById(cartItemId);
	}

	@Override
	public void deleteCartItemsByUsername(String username) {
		cartItemDao.deleteCartItemsByUsername(username);
	}

	@Override
	public void deleteCartItemsById(int cartItemId) {
		cartItemDao.deleteCartItemById(cartItemId);
	}

	@Override
	public void addProductToCart(Product product, String username) {
		// convert product to cartitem
		CartItem cartItem = new CartItem(product.getProductId(), product.getProductName(), 1, product.getPrice(),
				username, "NP", product.getImage());
		cartItemDao.addCartItem(cartItem);
	}

//	@Override
//	public List<CartItem> initiatePaymentForOrder(String username) {
//		List<CartItem> notPaidCartItems = cartItemDao.getUserCartItemsByPaymentStatus(username, "NP");
//		notPaidCartItems.stream().forEach((i) -> {
//			cartItemDao.updateCartItemByPaymentStatus(i.getCartItemId(), "JP");
//		});
//
//		return notPaidCartItems;
//	}

	@Override
	public void emptyCart(String username) {
		List<CartItem> notPaidCartItems = cartItemDao.getUserCartItemsByPaymentStatus(username, "NP");
		notPaidCartItems.stream().forEach((i) -> {
			cartItemDao.deleteCartItem(i);
		});
	}

	@Override
	public boolean isCartEmpty(String username) {
		return cartItemDao.getUserCartItemsByPaymentStatus(username, "NP").size() == 0 ? true : false;
	}
}