package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {

	@RequestMapping(value = "/greeting") //maps it to the url
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Hello World");
		
		return "hello";
	}
	
}
