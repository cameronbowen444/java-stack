package com.cameronbowen.many.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.many.models.Category;
import com.cameronbowen.many.models.Product;
import com.cameronbowen.many.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public List<Category> findCategoriesByProducts(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedProducts(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	public void delete(Category category) {
		categoryRepo.delete(category);
	}
}
