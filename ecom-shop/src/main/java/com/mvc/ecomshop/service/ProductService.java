package com.mvc.ecomshop.service;

import com.mvc.ecomshop.model.Products;

public interface ProductService {
	
	public Products createProduct(Products product);
	
	public Products updateProduct(Products product);
	
	public Products findProductByModelName(String modelName);
	
	public void deleteProductById(int id);
}
