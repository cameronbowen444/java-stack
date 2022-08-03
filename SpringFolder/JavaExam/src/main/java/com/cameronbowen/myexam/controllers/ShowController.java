package com.cameronbowen.myexam.controllers;

import javax.servlet.http.HttpSession;
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

import com.cameronbowen.myexam.models.Show;
import com.cameronbowen.myexam.service.ShowService;
import com.cameronbowen.myexam.service.UserService;

@Controller
public class ShowController {

	@Autowired
	private ShowService showService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/shows")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		model.addAttribute("allShows", showService.findAllShows());
		return "home.jsp";
	}
	
	@GetMapping("/shows/new")
	public String home(@ModelAttribute("show") Show show, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		return "create.jsp";
	}
	
	@PostMapping("/shows/new")
	public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		model.addAttribute("show", showService.create(show));
		
		return "redirect:/shows";
	}
	
	@GetMapping("/shows/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		model.addAttribute("show", showService.findShow(id));
		return "edit.jsp";
	}
	
	@PutMapping("/shows/{id}/edit")
	public String update(@Valid @ModelAttribute("show") Show show, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		model.addAttribute("show", showService.update(show));
		return "redirect:/shows";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById( (Long) session.getAttribute("userId")));
		model.addAttribute("show", showService.findShow(id));
		
		return "show.jsp";
	}
	
	@RequestMapping("/shows/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}

    	showService.delete(showService.findShow(id));
    	 
    	return "redirect:/shows";
	}
}
