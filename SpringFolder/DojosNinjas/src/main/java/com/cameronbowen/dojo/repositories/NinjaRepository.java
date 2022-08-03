package com.cameronbowen.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronbowen.dojo.models.Dojo;
import com.cameronbowen.dojo.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
	
	List<Ninja> findAllByDojo(Dojo dojo);

}
