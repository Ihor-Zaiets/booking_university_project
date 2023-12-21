package com.university.booking_university_project.modules.security;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private UserService userService;

    public String getLoggedUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    public User getloggedUser() {
        return userService.findByLogin(getLoggedUserName());
    }
}
