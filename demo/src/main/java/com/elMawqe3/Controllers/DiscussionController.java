package com.elMawqe3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elMawqe3.Services.BoardService;

@Controller
public class DiscussionController {
	
	@Autowired
	BoardService bServ;
	
	@GetMapping("/discussion")
	public String disc(Model mod) {
		mod.addAttribute("board", bServ.getAll());
		return "discussion.html";
		
	}
}
