package com.example.controller;

import com.example.enumType.RoleType;
import com.example.member.MemberDO;
import com.example.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/index")
    ModelAndView login(HttpServletRequest req) {
//        String referer = req.getHeader("Referer");
//        req.getSession().setAttribute("prevPage", referer);
        return new ModelAndView("login");
    }

//    @RequestMapping(value = "/submit", method = RequestMethod.POST)
//    ModelAndView submit(String userId, String password) {
//        ModelAndView mav = new ModelAndView();
//        boolean isMember = memberRepository.isMember(userId);
//
//        mav.setViewName(isMember ? "home" : "login");
//
//        // TODO redirect
//        return mav;
//    }

//    @GetMapping("/submit")
//    public String loginForm(HttpServletRequest req) {
//        String referer = req.getHeader("Referer");
//        req.getSession().setAttribute("prevPage", referer);
//        return "login";
//    }

    @GetMapping(value = "/register")
    ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping(value = "/register")
    ModelAndView register(String username, String password, String email) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        MemberDO memberDO = new MemberDO();
        memberDO.setPassword(passwordEncoder.encode(password));
        memberDO.setEmail(email);
        memberDO.setRoleType(RoleType.ROLE_ADMIN.getRoleType());
        memberDO.setUserId(username);

        memberRepository.createMember(memberDO);
        return new ModelAndView(new RedirectView("/login/index"));
    }

    @GetMapping(value = "/unregister")
    ModelAndView unregister(String id, String password) {
        memberRepository.deleteMember(id);
        return new ModelAndView(new RedirectView("/login/index"));
    }
}