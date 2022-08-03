package com.cameronbowen.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronbowen.books.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findAll();
	
	List<Book> findByDescriptionContaining(String search);
	
	Long countByTitleContaining(String search);

    Long deleteByTitleStartingWith(String search);
}
