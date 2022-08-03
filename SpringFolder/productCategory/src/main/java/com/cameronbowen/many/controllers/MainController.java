package com.cameronbowen.many.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cameronbowen.many.models.Category;
import com.cameronbowen.many.models.Product;
import com.cameronbowen.many.service.CategoryService;
import com.cameronbowen.many.service.ProductService;

@Controller
public class MainController {

	@Autowired
	CategoryService categories;
	@Autowired 
	ProductService products; 
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", categories.allCategories());
		model.addAttribute("products", products.allProducts());
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newpro.jsp";
	}
	
	@PostMapping("/product")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newpro.jsp";
		}
		products.create(product);
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcat.jsp";
	}
	
	@PostMapping("/category")
	public String newcat(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return  "newcat.jsp";
		}
		categories.create(category);
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String product(@PathVariable("id") Long id, Model model) {
		Product product = products.findById(id);
		model.addAttribute("assignedCategories", categories.findCategoriesByProducts(product));
		model.addAttribute("unassignedCategories", categories.getUnassignedProducts(product));
		model.addAttribute("products", product);
		return "products.jsp";
	}
	@PostMapping("/products/{id}")
	public String productchange(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId, Model model) {
		
		Product product = products.findById(id);
		Category category = categories.findById(catId);
		
		product.getCategories().add(category);
		products.update(product);
		
		model.addAttribute("assignedCategories", categories.findCategoriesByProducts(product));
		model.addAttribute("unassignedCategories", categories.getUnassignedProducts(product));
		return "redirect:/products/" + id;
	}
	
	
	@GetMapping("/categories/{id}")
	public String category(@PathVariable("id") Long id, Model model) {
		Category category = categories.findById(id);
		model.addAttribute("assignedProducts", products.findProductsByCategory(category));
		model.addAttribute("unassignedProducts", products.getUnassignedCategories(category));
		model.addAttribute("category", category);
		return "categories.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String categoryChange(@PathVariable("id") Long id, @RequestParam(value="productId") Long proId, Model model) {
		Category category = categories.findById(id);
		Product product = products.findById(proId);
		
		category.getProducts().add(product);
		categories.update(category);
		
		model.addAttribute("assignedProducts", products.findProductsByCategory(category));
		model.addAttribute("unassignedProducts", products.getUnassignedCategories(category));
		
		return "redirect:/categories/" + id;
	}
}
