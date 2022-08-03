package com.cameronbowen.bclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.bclub.models.Book;
import com.cameronbowen.bclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired 
	private BookRepository bookRepo;
	
	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book findBook(Long id) {
		Optional<Book> result = bookRepo.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
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
}
