package com.app.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.user.Model.User;
import com.app.user.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userHome");
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userLogin");
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView register()
	{
		return new ModelAndView("userRegister", "user", new User());
	}
	
	@PostMapping("/adduser")
	public ModelAndView adduser(@ModelAttribute("user") User user)
	{
		userservice.adduser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userLogin");
		return mv;
	}	
	
}
