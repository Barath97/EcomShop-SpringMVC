package com.mvc.ecomshop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.ecomshop.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

	Products findByVariant(String variant);
	Optional<Products> findByModel(String model);
}
