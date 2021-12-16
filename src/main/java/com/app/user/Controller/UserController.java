package com.app.user.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
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
			@RequestParam("mobile") long mobile, @RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		ModelAndView mv = new ModelAndView();
		if(user != null) {
			mv.setViewName("userHome");
		}
		else {
			mv.setViewName("userLogin");
		}
		User user = new User();
		user.setfName(fName);
		user.setlName(lName);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setUsername(username);
		user.setPassword(password);
		boolean added = userservice.adduser(user);
		ModelAndView mv = new ModelAndView();
		if(added) {
			mv.setViewName("userLogin");
			return mv;
		}
		mv.setViewName("userRegister");
		return mv;
	}		
	
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		ModelAndView mv = new ModelAndView();
		if(user != null) {
			mv.setViewName("userHome");
		}
		else {
			mv.setViewName("userLogin");
		}
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		if(user != null) {
			mv.setViewName("userHome");
		}
		else {
			mv.setViewName("userLogin");
		}
		return mv;
	}
	
	
	@PostMapping("/checkuser")
	public ModelAndView checkuser(@RequestParam("username") String username,@RequestParam("password") String password, HttpServletRequest request)
	{
	    boolean found = userservice.checkuser(username, password, request);
    	ModelAndView mv = new ModelAndView();
	    if(found) {
			mv.setViewName("userHome");
			return mv;
	    }
		mv.setViewName("userLogin");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)
	{	
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userLogin");
		return mv;
	}
	
	@GetMapping("/users/all")
	public List<User> getAllUserRecords() {
		return userservice.getAllUsers();
	}

	@GetMapping("/user/details")
	public List<User> getUserRecord(@RequestParam("username") String username) {
		return userservice.getUserByUsername(username);
	}
	
}
