package com.cameronbowen.gold.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/") 
	public String index(HttpSession session, Model model) {
		
		int goldValue = 0;
		session.setAttribute("goldValue", goldValue);
		model.addAttribute("goldValue", goldValue);
		
		String farmResult = (String) session.getAttribute("resultMessage");
		model.addAttribute("farmResult", farmResult);
		
		return "index.jsp";
	}
	@RequestMapping(value="/game", method=RequestMethod.POST)
	public String farm(
			@RequestParam("farmGold") int farmGold,
			HttpSession session) {
		
		Random rand = new Random();
		
		farmGold = rand.nextInt(10) + 10;
		session.setAttribute("goldValue", (Integer) session.getAttribute("goldValue") + farmGold);
		
		String resultMessage = String.format("Contrats, You earned %d gold!!!", farmGold);
		session.setAttribute("resultMessage", resultMessage);
		session.setAttribute("farmGold", farmGold);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave() {
		
		return "redirect:/";
	}
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house() {
		
		return "redirect:/";
	}
	@RequestMapping(value="/quest", method=RequestMethod.POST)
	public String quest() {
		
		return "redirect:/";
	}
}
