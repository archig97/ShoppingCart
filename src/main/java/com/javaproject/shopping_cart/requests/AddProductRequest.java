package com.javaproject.shopping_cart.requests;

import java.util.List;

import com.javaproject.shopping_cart.model.Category;
import com.javaproject.shopping_cart.model.Image;

import lombok.Data;


@Data
public class AddProductRequest {
	
	private Long id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	private int inventory;
	private String brand;

	private Category category;
	private List<Image> images;

}
