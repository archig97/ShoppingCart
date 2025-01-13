package com.javaproject.shopping_cart.requests;

import com.javaproject.shopping_cart.model.Category;

import lombok.Data;

@Data
public class ProductUpdateRequest {
	
	private Long id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	private int inventory;
	private String brand;

	private Category category;

}
