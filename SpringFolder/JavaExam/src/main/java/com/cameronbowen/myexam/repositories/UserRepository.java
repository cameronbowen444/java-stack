package com.cameronbowen.myexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronbowen.myexam.models.Show;
import com.cameronbowen.myexam.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	List<User> findUsersByShows(Long id);
	Optional<User> findByEmail(String email);
	
}
