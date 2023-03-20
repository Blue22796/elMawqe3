package com.elMawqe3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elMawqe3.Models.Event;
import com.elMawqe3.Services.newsService;

@Controller
public class NewsController {
	
	@Autowired
	newsService service;
	
	
	
	@GetMapping("/home")
	public String hp(Model model) {
		model.addAttribute("news",service.events());
		return "home.html";
	}
	
	@GetMapping("/update")
	public String update() {
		return"update.html";
	}
		
	@PostMapping("/news")
	public String insert(@RequestParam String headline,
			@RequestParam String details, @RequestParam String author,
			@RequestParam String pPath, Model model) 
	{
		Event newEvent = new Event();
		System.out.println(newEvent.getId());
		newEvent.setAuthor(author);
		newEvent.setDetails(details);
		newEvent.setHeadline(headline);
		newEvent.setPPath(pPath);
		
		model.addAttribute("news",service.events());
		service.insert(newEvent);
		return "home.html";
	}
}
