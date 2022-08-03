package com.cameronbowen.club.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.cameronbowen.club.models.Book;
import com.cameronbowen.club.models.LoginUser;
import com.cameronbowen.club.models.User;
import com.cameronbowen.club.service.BookService;
import com.cameronbowen.club.service.UserService;

@Controller
public class BookController {
	
	@Autowired
	private UserService users;
	@Autowired 
	private BookService books;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		
		User user = users.register(newUser, result);
		
		if(result.hasErrors()) {
			
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {
		
		User user = users.login(newLogin, result);
		
		if(result.hasErrors()) {
			
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("books", books.findAllBooks());
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
		return "main.jsp";
	}
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book,
			Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = users.findById ((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "create.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		books.create(book);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", users.findById ( (Long) session.getAttribute("userId")));
		model.addAttribute("book", books.findById(id));
		return "show.jsp";
	}

	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Book book = books.findById(id);
    	model.addAttribute("book", book);
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
		return "edit.jsp";
	}
	@PutMapping("edit/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		books.update(book);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
    	 
    	books.delete(books.findBook(id));
    	 
    	return "redirect:/dashboard";
	}
	@GetMapping("/bookmarket")
	public String bookmarket(HttpSession session, Model model) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", users.findById(userId));

		List<Book> unBooks = books.unborrowedBooks(users.findById(userId));
		model.addAttribute("books", unBooks);

		List<Book> myBooks = books.borrowedBooks(users.findById(userId));
		model.addAttribute("myBooks", myBooks);
		 
		return "bookmarket.jsp";
	}
	
	@RequestMapping("/bookmarket/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		books.addBorrower(books.findBook(bookID), users.findById(userId));
		 
		return "redirect:/bookmarket";
	}
	
	@RequestMapping("/bookmarket/return/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		books.removeBorrower(books.findBook(bookID));
		 
		return "redirect:/bookmarket";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
	