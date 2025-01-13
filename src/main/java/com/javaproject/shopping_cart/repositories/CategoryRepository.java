package com.javaproject.shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.shopping_cart.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

	Category findByName(String name);

}
