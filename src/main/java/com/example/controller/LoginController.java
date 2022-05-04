package com.example.controller;

import com.example.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@Slf4j
public class LoginController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/login")
    @ResponseBody
    String login(HttpServletRequest req) {
//        String referer = req.getHeader("Referer");
//        req.getSession().setAttribute("prevPage", referer);
        return "test";
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

    @GetMapping(value = "/login/register")
    ModelAndView register() {
        return new ModelAndView("register");
    }

//    @PostMapping(value = "/register")
//    ModelAndView register(String username, String password, String email) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        Member memberDO = new Member();
//        memberDO.setPassword(passwordEncoder.encode(password));
//        memberDO.setEmail(email);
//        memberDO.setRoleType(RoleType.ROLE_ADMIN.getRoleType());
//        memberDO.setUserId(username);
//
//        try {
//            memberRepository.createMember(memberDO);
//        } catch (Exception e) {
//            log.error("{}", e, e);
//        }
//
//        return new ModelAndView(new RedirectView("/login/index"));
//    }

    @GetMapping(value = "/login/unregister")
    ModelAndView unregister(String id, String password) {
        memberService.deleteMember(id);
        return new ModelAndView(new RedirectView("/login"));
    }
}
