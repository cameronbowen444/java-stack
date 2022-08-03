package com.cameronbowen.dojo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cameronbowen.dojo.models.Dojo;
import com.cameronbowen.dojo.models.Ninja;
import com.cameronbowen.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository repo;
	
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;
	}
	
	public List<Ninja> allNinjas() {
		return repo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return repo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional <Ninja> optionalNinja = repo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
	public List<Ninja> ninjasByDojos(Dojo dojo) {
		return repo.findAllByDojo(dojo);
	}
}
