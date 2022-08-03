package com.cameronbowen.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.club.models.Book;
import com.cameronbowen.club.models.User;
import com.cameronbowen.club.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book findById(Long id) {
		
		Optional<Book> result = bookRepo.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	
	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public void delete(Book book) {
		bookRepo.delete(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	public List<Book> unborrowedBooks(User user){
		return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	
	public List<Book> myBooks(User user){
		return bookRepo.findByUserIdIs(user.getId());
	}
	
	
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}

}
