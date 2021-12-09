package com.app.user.Controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.user.Model.User;
import com.app.user.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userHome");
		return mv;
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userRegister");
		return mv;
	}
	@PostMapping("/adduser")
	public ModelAndView adduser(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName, @RequestParam("email") String email,
			@RequestParam("mobile") long mobile, @RequestParam("username") String username, @RequestParam("password") String password) {
		User user = new User();
		user.setfName(fName);
		user.setlName(lName);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setUsername(username);
		user.setPassword(password);
		userservice.adduser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userLogin");
		return mv;
	}		
	
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userLogin");
		return mv;
	}
	
//	@PostMapping("/checkuser")
//	public String auth1(@RequestParam("uname") String username,@RequestParam("pwd") String password,)
//	{
//	HttpSession session=request.getSession(); // creating session variable as same as servlet
//	//uname and pwd will have values given in form
//	// check login logic using HQL
//	session.setAttribute("uname", auser.getUsername());
//	// other code
//	}
}
