package com.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId;

	String productName;
	String prouductDesc;
	int price;
	int stock;

	public Product(int productId, String productName, String prouductDesc, int price, int stock) {
		this.productId = productId;
		this.productName = productName;
		this.prouductDesc = prouductDesc;
		this.price = price;
		this.stock = stock;
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

	public String getProuductDesc() {
		return prouductDesc;
	}

	public void setProuductDesc(String prouductDesc) {
		this.prouductDesc = prouductDesc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", prouductDesc=" + prouductDesc
				+ ", price=" + price + ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, productId, productName, prouductDesc, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return price == other.price && productId == other.productId && Objects.equals(productName, other.productName)
				&& Objects.equals(prouductDesc, other.prouductDesc) && stock == other.stock;
	}
}