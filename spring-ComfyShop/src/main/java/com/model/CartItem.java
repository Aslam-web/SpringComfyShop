package com.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cartItemId;

	@NotNull
	int productId;
	
	@NotNull
	String productName;
	@NotNull
	int quantity;
	@NotNull
	int price;

	@NotNull
	String username;
	
	@NotNull
//	@Column(columnDefinition = "varchar default NP")
	String paymentStatus; // "P" (or) "NP" (or) "JP" 	i.e. {PAID, NOT_PAID, JUST_PAID}
	
	@NotNull
	String image;

	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(int productId, String productName, int quantity, int price, String username,
			String paymentStatus, String image) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.username = username;
		this.paymentStatus = paymentStatus;
		this.image = image;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartItemId, image, paymentStatus, price, productId, productName, quantity, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return cartItemId == other.cartItemId && Objects.equals(image, other.image)
				&& Objects.equals(paymentStatus, other.paymentStatus) && price == other.price
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& quantity == other.quantity && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + ", username=" + username + ", paymentStatus="
				+ paymentStatus + ", image=" + image + "]";
	}
}