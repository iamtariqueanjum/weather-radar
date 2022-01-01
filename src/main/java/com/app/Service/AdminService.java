package com.app.Service;

import com.app.Model.Admin;
import com.app.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public boolean checkadmin(String adminusername, String adminpassword, HttpServletRequest request)
    {
        List<Admin> adminuser = adminRepository.findByUsernameAndPassword(adminusername, adminpassword);
        if(adminuser.isEmpty()) {
            return false;
        }
        HttpSession session = request.getSession();
        session.setAttribute("adminusername", adminuser.get(0).getUsername());
        return true;
    }

    public boolean adminsessionExists(HttpSession session) {
        String adminuser = (String) session.getAttribute("adminusername");
        if(adminuser != null) {
            return true;
        }
        return false;
    }

    public void destroyAdminSession(HttpSession session) {
        session.removeAttribute("adminusername");
        session.invalidate();
    }

}
