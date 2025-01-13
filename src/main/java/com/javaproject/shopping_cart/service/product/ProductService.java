package com.javaproject.shopping_cart.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaproject.shopping_cart.repositories.CategoryRepository;
import com.javaproject.shopping_cart.repositories.ProductRepository;
import com.javaproject.shopping_cart.requests.AddProductRequest;
import com.javaproject.shopping_cart.requests.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

import com.javaproject.shopping_cart.exceptions.ProductNotFoundException;
import com.javaproject.shopping_cart.model.Category;
import com.javaproject.shopping_cart.model.Product;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
	
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
	

	@Override
	public Product addProduct(AddProductRequest request) {
		// TODO Auto-generated method stub
		//check if category was found in db
		
		Category category=Optional.ofNullable(categoryRepo.findByName(request.getCategory().getName())).
				orElseGet(() -> {
					Category newCategory=new Category(request.getCategory().getName());
					return categoryRepo.save(newCategory);
				});
		
		request.setCategory(category);
		return productRepo.save(createProduct(request,category));
		//if yes, set it as category of new product
		//if not then save it as a new category
		//then set it as category of new product
		
	}
	
	private Product createProduct(AddProductRequest request, Category category) {
		return new Product(
				request.getName(),
				request.getBrand(),
				request.getPrice(),
				request.getInventory(),
				request.getDescription(),
				category);
				
		
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found"));//lambda expression used
		
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		productRepo.findById(id).ifPresentOrElse(
				productRepo::delete,
				() -> { 
					throw new ProductNotFoundException("Product Not Found");
					}
				);
		
	}

	@Override
	public void updateProduct(Product product, Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private Product updateExistingProduct(Product existingProduct,ProductUpdateRequest request) {
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepo.findByCategoryName(category);//writing category name specifically because category is an object itself
	}

	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return productRepo.findByName(name);
	}

	@Override
	public List<Product> getProductsByBrand(String brand) {
		
		return productRepo.findByBrand(brand);
	}

	@Override
	public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return productRepo.findByCategoryNameAndBrand(category,brand);
	}

	@Override
	public List<Product> getProductsByNameAndBrand(String name, String brand) {
		
		return productRepo.findByNameAndBrand(name,brand);
	}

	@Override
	public List<Product> countProductsByNameAndBrand(String name, String brand) {
		// TODO Auto-generated method stub
		return productRepo.countByNameAndBrand(name,brand);
	}

	

}
