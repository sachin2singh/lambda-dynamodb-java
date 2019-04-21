package com.aws.lambda.dao;

import java.util.List;

import com.aws.lambda.domain.Product;

public interface ProductDAO {

	List<Product> findAllProduct();
	
	Product findProductById (String id);
	
	void saveOrUpdateProduct (Product product);
	
	void deleteProduct (Product product);
}
