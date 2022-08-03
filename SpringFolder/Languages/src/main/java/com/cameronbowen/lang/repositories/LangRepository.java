package com.cameronbowen.lang.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronbowen.lang.models.Language;

@Repository
public interface LangRepository extends CrudRepository <Language, Long> {
	
	List<Language> findAll();
	
	List<Language> findByCreatorContaining(String search);
}
