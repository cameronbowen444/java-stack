package com.cameronbowen.many.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronbowen.many.models.Category;
import com.cameronbowen.many.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	List<Product> findAllByCategories(Category category);
	
	List<Product> findByCategoriesNotContains(Category category);
}
