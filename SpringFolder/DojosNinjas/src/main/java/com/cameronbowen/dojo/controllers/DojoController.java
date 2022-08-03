package com.cameronbowen.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameronbowen.dojo.models.Dojo;
import com.cameronbowen.dojo.service.DojoService;


@Controller
public class DojoController {


	@Autowired
	private DojoService dojos;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", dojos.allDojos());
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String home(@ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("dojos", dojos.allDojos());
		return "index.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String dojodash(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojos.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		Dojo newDojo = dojos.createDojo(dojo);
		System.out.printf("new id: %s", dojo.getId());
		
		return String.format("redirect:/dojos/%s", newDojo.getId());
	}
}
