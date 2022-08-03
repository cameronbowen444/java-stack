package com.cameronbowen.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameronbowen.dojo.models.Ninja;
import com.cameronbowen.dojo.service.DojoService;
import com.cameronbowen.dojo.service.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjas;
	@Autowired
	private DojoService dojos;
	
	@GetMapping("/ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojos.allDojos());
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
		ninja = ninjas.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
}
