package com.cameronbowen.bclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cameronbowen.bclub.models.Book;
import com.cameronbowen.bclub.service.BookService;
import com.cameronbowen.bclub.service.UserService;


@Controller
public class BookController {

	@Autowired 
	UserService userService;
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		model.addAttribute("allBooks", bookService.findAllBooks());
		
		return "books.jsp";
	}
	
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		return "create.jsp";
	}
	
	@PostMapping("/books/new")
	public String newBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		model.addAttribute("book", bookService.create(book));
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		model.addAttribute("book", bookService.findBook(id));
		
		
		return "show.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		model.addAttribute("book", bookService.findBook(id));
		return "edit.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		model.addAttribute("book", bookService.update(book));
		
		return "redirect:/books";
	}
}
