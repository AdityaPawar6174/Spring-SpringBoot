package com.infosys.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleApplication {
    @GetMapping("/")
    public String Home(HttpServletRequest request)
    {
        return "Welcome to Spring Security"+ request.getSession().getId();
    }
}