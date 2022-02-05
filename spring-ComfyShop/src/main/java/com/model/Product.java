package com.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId;

	@NotNull
	String productName;
	@NotNull
	String productDesc;
	@NotNull
	int price;
	@NotNull
	int stock;
	
	@NotNull
	String image;

	public Product() {
	}
	
	public Product(String productName, String productDesc, int price, int stock, String image) {
		this.productName = productName;
		this.productDesc = productDesc;
		this.price = price;
		this.stock = stock;
		this.image = image;
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

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", price=" + price + ", stock=" + stock + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(image, price, productDesc, productId, productName, stock);
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
		return Objects.equals(image, other.image) && price == other.price
				&& Objects.equals(productDesc, other.productDesc) && productId == other.productId
				&& Objects.equals(productName, other.productName) && stock == other.stock;
	}
}