package com.cameronbowen.project1;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
//@RequestMapping("/greeting")
public class HomeController {
	
	
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		if (searchQuery == null) {
			return "nothing searched";
		} else {
			return "You Searched for: " + searchQuery;
		}
	}
	
	@RequestMapping("/m/{track}/{module}/{lesson}")
	public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson")String lesson) {
		return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
	}
	
	
	
//	@RequestMapping("")
//	public String index() {
//		return "Hello User!";
//	}
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
//	public String hello() {
//		return "Hello World! What route did your use to access me?";
//	}
//	@RequestMapping("/goodbye")
//	public String world() {
//		return "Goodbye World!";
//	}
}
