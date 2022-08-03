package com.cameronbowen.lang.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cameronbowen.lang.models.Language;
import com.cameronbowen.lang.service.LangService;


@Controller
public class LangControllers {
	
	@Autowired
	LangService langService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String home(Model model, @ModelAttribute("language") Language language) {
		
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List <Language> languages = langService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		else {
			langService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Language language = langService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
		
		
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		Language language = langService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/languages/{id}/edit";
		}
		else {
			langService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
