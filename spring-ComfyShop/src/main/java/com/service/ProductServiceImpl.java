package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;
import com.repository.ProductDAO;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDao;

	@Override
	public int addProduct(Product product) {
		productDao.addProduct(product);
		return product.getProductId();
	}
	
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);;
	}
	
	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}
	
	@Override
	public void deleteProductById(int productId) {
		productDao.deleteProductById(productId);
	}
	
	@Override
	public Product getProduct(int productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

}
