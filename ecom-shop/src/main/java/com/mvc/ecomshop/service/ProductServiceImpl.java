package com.mvc.ecomshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.ecomshop.dao.ProductRepository;
import com.mvc.ecomshop.model.Products;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Products createProduct(Products product) {
		 String variant =product.getVariant();
		 
		 try {
			 Products isExist= productRepository.findByVariant(variant);
			 
			 if(isExist == null) {
				 return productRepository.save(product);
			 }
			 else {
				 throw new Exception("Product Already Exists");
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 return null;
		 }
	}

	@Override
	public Products updateProduct(Products product) {
		 
		 try {
			 if(productRepository.findById(product.getId()).isPresent()) {
				 return productRepository.save(product);
			 }
			 else {
				 throw new Exception("product not found");
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 return null;
		 }
	}

	@Override
	public Products findProductByModelName(String modelName) {
		 
		 try {
			 Optional<Products> productsOptional = productRepository.findByModel(modelName);
			 if(productsOptional.isPresent()) {
				 return productsOptional.get();
			 }
			 else {
				 throw new Exception("Model not exist");
			 }
		 }catch(Exception e) {
			 throw new RuntimeException("Error occured during finding the product");
		 }
	}

	@Override
    public void deleteProductById(int id) {

        try{
             Optional<Products> productsOptional = productRepository.findById(id);

             if(productsOptional.isPresent()){
                 productRepository.deleteById(id);
            }else {
                 throw new Exception("No product found with ID: " + id);
            }
        } catch (Exception e) {
             throw new RuntimeException("Error while deleting product", e);
        }

    }

}
