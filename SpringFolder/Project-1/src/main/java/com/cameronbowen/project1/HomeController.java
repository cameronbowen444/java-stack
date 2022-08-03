package com.cameronbowen.project1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/cam")
	public String camcam() {
		return "Cam Cam Baby is Java Full Stack Now!";
	}
	@RequestMapping("/world")
	public String world() {
		return "Class Level Annotations are cool too!";
	}
}
