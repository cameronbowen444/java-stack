package com.cameronbowen.lang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cameronbowen.lang.models.Language;
import com.cameronbowen.lang.repositories.LangRepository;

@Service
public class LangService {
	
	private final LangRepository langRepository;
	
	public LangService(LangRepository langRepository) {
		this.langRepository = langRepository;
	}
	
	
	public List<Language> allLanguages() {
		return langRepository.findAll();
	}
	
	
	public Language createLanguage(Language language) {
		return langRepository.save(language);
	}
	
	
	public Language findLanguage(Long id) {
		Optional <Language> optionalLanguage = langRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	
	
	public Language updateLanguage(Language language) {
		return langRepository.save(language);
	}
	
	
	public void deleteLanguage(Long id) {
		Optional <Language> optionalLanguage = langRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			langRepository.deleteById(id);
		}
	}
	
}
