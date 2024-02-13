package com.mvc.ecomshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.ecomshop.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
