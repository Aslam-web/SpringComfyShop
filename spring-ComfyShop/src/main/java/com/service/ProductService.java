package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {

	int addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	void deleteProductById(int productId);

	Product getProduct(int productId);
	List<Product> getAllProducts();
}