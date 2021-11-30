package com.app.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.Model.User;
import com.app.user.Repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userrepository;
	
	@GetMapping("/")
	public String home() {
		return "userHome";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "userRegister";
	}
	
	@PostMapping("/adduser")
	public String adduser(User user) {
		userrepository.save(user);
		return "userLogin";
	}		
	
	@GetMapping("/login")
	public String login() {
		return "userLogin";
	}
	
}
