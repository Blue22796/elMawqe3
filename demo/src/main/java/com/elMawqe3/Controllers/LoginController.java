package com.elMawqe3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String loginPage() {
		return "login.html";
	}
	@PostMapping("/logout")
	public String logout() {
		return "logout.html";
	}
}
