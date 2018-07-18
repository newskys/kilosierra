package com.example.controller;

import com.example.enumType.RoleType;
import com.example.member.Member;
import com.example.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginApiController {
    @Autowired
    MemberService memberService;

    @PostMapping(value = "/login/register")
    ResponseEntity register(String username, String password, String email) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Member member = new Member();
        member.setPassword(passwordEncoder.encode(password));
        member.setEmail(email);
        member.setRoleType(RoleType.ROLE_ADMIN.getRoleType());
        member.setUserId(username);

        try {
            memberService.createMember(member);
        } catch (Exception e) {
            log.error("{}", e, e);
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
