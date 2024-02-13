package com.mvc.ecomshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.ecomshop.model.Products;
import com.mvc.ecomshop.service.ProductService;

@RestController
@RequestMapping("/ecom")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/addproduct/product")
	public ResponseEntity<?> createNewProduct(@RequestBody Products products){
		
		try {
			Products newProduct = productService.createProduct(products);
			return new ResponseEntity<Products>(newProduct,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find/model/{modelName}")
	public ResponseEntity<?> findProductByModelName(@PathVariable String modelName){
		try {
			Products product=productService.findProductByModelName(modelName);
			return new ResponseEntity<Products>(product,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/product")
	public ResponseEntity<?> updateProduct(@RequestBody Products product){
		try {
			Products updateProduct = productService.updateProduct(product);
			return new ResponseEntity<Products>(updateProduct,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/product/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id){
		try {
			productService.deleteProductById(id);
			return new ResponseEntity<String>("Product Deleted Successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
