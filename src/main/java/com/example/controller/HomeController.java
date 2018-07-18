package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {
    @RequestMapping("/home/list")
    ModelAndView list() {
        return new ModelAndView("home");
    }

    @RequestMapping("/")
    RedirectView home(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            return new RedirectView("/home/list");
        } else {
            return new RedirectView("/login");
        }
    }
}
