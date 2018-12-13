package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.models.Product;

public interface ProductDao {
	Product saveProduct(Product product);
	
	Product getProduct(int id);
	
	void updateProduct(Product product);
	void deleteProduct(int id);
	
	List<Product> getAllProducts();
	

}
