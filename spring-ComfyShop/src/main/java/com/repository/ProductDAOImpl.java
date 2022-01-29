package com.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository("productDao")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sf;

	private Session getSession() {
		return sf.getCurrentSession();
	}

	@Override
	public void addProduct(Product product) {
		getSession().persist(product);
	}

	@Override
	public void updateProduct(Product product) {
		Product entity = getSession().get(Product.class, product.getProductId());
		if (entity != null) {
			entity.setProductName(product.getProductName());
			entity.setProuductDesc(product.getProuductDesc());
			entity.setPrice(product.getPrice());
			entity.setStock(product.getStock());
			getSession().persist(entity);
		} else {
			System.out.println("No such product exists in database");
		}
	}

	@Override
	public void deleteProduct(Product product) {
		getSession().delete(product);
	}

	@Override
	public void deleteProductById(int productId) {
		Product entity = getSession().get(Product.class, productId);
		if (entity != null) {
			getSession().delete(entity);
		} else {
			System.out.println("No such product exists in database");
		}
	}

	@Override
	public Product getProductById(int productId) {
		Product entity = getSession().get(Product.class, productId);
		if (entity != null) {
			return entity;
		} else {
			System.out.println("No such product exists in database");
			return null;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		Criteria criteria = getSession().createCriteria(Product.class);
		return criteria.list();
	}

}
