package com.cameronbowen.many.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.many.models.Category;
import com.cameronbowen.many.models.Product;
import com.cameronbowen.many.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository productRepo;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public List<Product> findProductsByCategory(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedCategories(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
	public Product findById(Long id) {
		Optional<Product> findProduct = productRepo.findById(id);
		if(findProduct.isPresent()) {
			return findProduct.get();
		} else {
			return null;
		}
	}
	
	public void delete(Product product) {
		productRepo.delete(product);
	}
}
