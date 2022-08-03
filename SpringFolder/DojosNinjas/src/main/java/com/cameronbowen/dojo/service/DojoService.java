package com.cameronbowen.dojo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cameronbowen.dojo.models.Dojo;
import com.cameronbowen.dojo.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository repo;
	
	public DojoService(DojoRepository repo) {
		this.repo = repo;
	}
	
	public List<Dojo> allDojos() {
		return repo.findAll();
	}
	
	
	public Dojo createDojo(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional <Dojo> optionalDojo =  repo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	public Dojo updateDojo(Dojo dojo) {
		return repo.save(dojo);
	}
	
}
