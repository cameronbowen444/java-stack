package com.cameronbowen.form.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControllers {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String form(
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="action") String action,
			@RequestParam(value="living") String living,
			@RequestParam(value="comment") String comment,
			HttpSession session) {
		
		String messageInfo = String.format("In %s years, you will live in %s, with %s as your roomate, "
				+ "%s for a living. The next time you see a %s, you will have good luck. "
				+ "Also, %s", number, city, person, action, living, comment);
		
		session.setAttribute("messageInfo", messageInfo);
		
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show(HttpSession session, Model model) {
		String result = (String) session.getAttribute("messageInfo");
		model.addAttribute("result", result);
		return "show.jsp";
	}
}
