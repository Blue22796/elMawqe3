package com.elMawqe3.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import com.elMawqe3.Models.Role;
import com.elMawqe3.Models.User;
import com.elMawqe3.Models.UserDto;
import com.elMawqe3.Services.RoleService;
import com.elMawqe3.Services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	
	@GetMapping("/login")
	public String loginPage() {
		return "login.html";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "logout.html";
	}
	
	@GetMapping("/signup")
	public String reg(Model model, WebRequest wr) {
		UserDto dto = new UserDto();
		model.addAttribute("user", dto);
		return "signup.html";
	}
	
	@PostMapping("/signup")
	public RedirectView createAccount(@ModelAttribute("user") @Valid UserDto nuser,  
			HttpServletRequest request,
			 BindingResult result) {
		 try {
			 User user = new User(nuser);
			 user.roles.add(roleService.getUserRole());
		     userService.saveUser(user);
		     return new RedirectView("/home") ;
		    } catch (Exception uaeEx) {
		        return new RedirectView("/signup?error=true");
		    }
		
		
	}
}
