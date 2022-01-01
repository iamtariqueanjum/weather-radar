package com.app.Controller;

import com.app.Model.User;
import com.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		boolean loggedIn = userservice.sessionExists(session);
		if(loggedIn) {
			mv.setViewName("userHome");
		}
		else {
			mv.setViewName("index");
		}
		return mv;
	}

	@GetMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}

	@GetMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}

	@GetMapping("/register")
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		boolean loggedIn = userservice.sessionExists(session);
		if(loggedIn) {
			mv.setViewName("redirect:/");
		}
		else {
			mv.setViewName("userRegister");
		}
		return mv;
	}

	@PostMapping("/adduser")
	public ModelAndView adduser(@RequestParam("firstname") String fName, @RequestParam("lastname") String lName, @RequestParam("email") String email,
								@RequestParam("mobile") long mobile, @RequestParam("username") String username, @RequestParam("password") String password,
								HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setfName(fName);
		user.setlName(lName);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setUsername(username);
		user.setPassword(password);
		boolean added = userservice.adduser(user);
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
		boolean loggedIn = userservice.sessionExists(session);
		ModelAndView mv = new ModelAndView();
		if(loggedIn) {
			mv.setViewName("redirect:/");
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
			mv.setViewName("redirect:/");
			return mv;
	    }
		mv.setViewName("userLogin");
		mv.addObject("errorMsg","Username or password is Incorrect");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		boolean loggedIn = userservice.sessionExists(session);
		if(loggedIn) {
			userservice.destroySession(session);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
