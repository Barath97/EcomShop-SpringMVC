package com.mvc.ecomshop.service;

import org.springframework.stereotype.Service;

import com.mvc.ecomshop.model.Products;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Override
	public Products createProduct(Products product) {
		 
		return null;
	}

	@Override
	public Products updateProduct(Products product) {
		 
		return null;
	}

	@Override
	public Products findProductByModelName(String modelName) {
		 
		return null;
	}

	@Override
	public void deleteProductById(int id) {
		 
		
	}

}
