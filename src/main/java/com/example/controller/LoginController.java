package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/index")
    ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    ModelAndView submit(HttpServletRequest request, String id, String password) {
        ModelAndView mav = new ModelAndView();
        boolean success = true;

        if (success) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", true);
            mav.setViewName("home");
        } else {
            mav.setViewName("login");
        }

        return mav;
    }
}
