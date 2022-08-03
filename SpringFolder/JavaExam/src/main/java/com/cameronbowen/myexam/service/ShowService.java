package com.cameronbowen.myexam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronbowen.myexam.models.Show;
import com.cameronbowen.myexam.repositories.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepo;
	
	
	public List<Show> findAllShows() {
		return showRepo.findAll();
	}
	
	public Show findShow(Long id) {
		Optional<Show> result = showRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public Show create(Show show) {
		return showRepo.save(show);
	}
	
	public Show update(Show show) {
		return showRepo.save(show);
	}
	
	public void delete(Show show) {
		showRepo.delete(show);
	}
}
