package com.javaproject.shopping_cart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.javaproject.shopping_cart.model.Product;


public interface ProductRepository extends JpaRepository<Product,Long>{

	List<Product> findByCategoryName(String category);

	List<Product> findByName(String name);

	List<Product> findByBrand(String brand);

	List<Product> findByCategoryNameAndBrand(String category, String brand);

	List<Product> findByNameAndBrand(String name, String brand);

	List<Product> countByNameAndBrand(String name, String brand);

	

}
