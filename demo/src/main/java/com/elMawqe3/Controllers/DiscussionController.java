package com.elMawqe3.Controllers;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.elMawqe3.Models.Comment;
import com.elMawqe3.Models.User;
import com.elMawqe3.Services.BoardService;

@Controller
public class DiscussionController {
	
	@Autowired
	BoardService bServ;
	
	@GetMapping("/discussion")
	public String disc(Model mod) {
		for(Comment com:bServ.getAll())
			System.out.println(com.getAuthor().getUsername()+": "+com.getContent());
		mod.addAttribute("board", bServ.getAll());
		return "discussion.html";
	}
	@PostMapping("/comment")
	public RedirectView comment(@RequestParam String msg) {
		Comment cmt = new Comment();
		cmt.setAuthor((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		cmt.setContent(msg);
		cmt.setDate(LocalDate.now());
		cmt.setTime(Time.valueOf(LocalTime.now()));
		bServ.save(cmt);
		return new RedirectView("/discussion");
	}
}
