package com.repository;

import java.util.List;

import com.model.Product;

public interface ProductDAO {

	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	void deleteProductById(int productId);

	Product getProductById(int productId);	
	List<Product> getAllProducts();
}
