package com.cameronbowen.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameronbowen.books.models.Book;
import com.cameronbowen.books.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		System.out.print(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
		return "index.jsp";
	}
	
	@GetMapping("/books")
	public String showall(Model model) {
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
		
		return "show.jsp";
	}
	
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book, BindingResult result) {
		
		return "create.jsp";
	}
	@PostMapping("/create")
	public String newBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
//	@PostMapping("/create")
//	public String newBook(@RequestParam("title") String title,
//			@RequestParam("description") String description,
//			@RequestParam("language") String language,
//			@RequestParam("numberOfPages") Integer numberOfPages) {
//		
//		Book book = new Book(title, description, language, numberOfPages);
//		bookService.createBook(book);
//		
//		return "redirect:/books";
//	}
}
