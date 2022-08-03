package com.cameronbowen.myexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronbowen.myexam.models.Show;
import com.cameronbowen.myexam.models.User;


@Repository
public interface ShowRepository extends CrudRepository<Show,Long> {

	List<Show> findAll();
	Show findByIdIs(Long id);
	List<Show> findAllByUser(User user);
	List<Show> findByUserNotContains(User user);
}
