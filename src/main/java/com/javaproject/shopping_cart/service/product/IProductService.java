package com.javaproject.shopping_cart.service.product;

import java.util.List;

import com.javaproject.shopping_cart.model.Product;

public interface IProductService {
	
	Product addProduct(Product product);
	Product getProductById(Long id);
	void deleteProductById(Long id);
	void updateProduct(Product product,Long id);
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByName(String name);
	List<Product> getProductsByBrand(String brand);
	List<Product> getProductsByCategoryAndBrand(String category,String brand);
	List<Product> getProductsByNameAndBrand(String name,String brand);
	List<Product> countProductsByNameAndBrand(String name,String brand);
	
	
	
	
	

}
