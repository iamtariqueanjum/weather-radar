package com.app.Controller;

import com.app.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public ModelAndView adminhome(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        if(adminService.adminsessionExists(session)) {
            mv.setViewName("adminhome");
        }
        else {
            mv.setViewName("adminLogin");
        }
        return mv;
    }

    @GetMapping("/admin/login")
    public ModelAndView adminlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        if(adminService.adminsessionExists(session)) {
            mv.setViewName("adminhome");
        }
        else {
            mv.setViewName("adminLogin");
        }
        return mv;
    }

    @PostMapping("/checkadminuser")
    public ModelAndView checkadminuser(@RequestParam("adminusername") String adminusername, @RequestParam("adminpassword") String adminpassword, HttpServletRequest request)
    {
        boolean found = adminService.checkadmin(adminusername, adminpassword, request);
        ModelAndView mv = new ModelAndView();
        if(found) {
            mv.setViewName("redirect:/admin/");
            return mv;
        }
        mv.setViewName("adminLogin");
        mv.addObject("errorMsg","Username or password is Incorrect");
        return mv;
    }

    @GetMapping("/admin/logout")
    public ModelAndView adminlogout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if(adminService.adminsessionExists(session)) {
            adminService.destroyAdminSession(session);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/admin/");
        return mv;
    }

}
