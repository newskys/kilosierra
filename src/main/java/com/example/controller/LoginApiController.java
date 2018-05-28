package com.example.controller;

import com.example.enumType.RoleType;
import com.example.member.MemberDO;
import com.example.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginApiController {
    @Autowired
    MemberRepository memberRepository;

    @PostMapping(value = "/register")
    ResponseEntity register(String username, String password, String email) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        MemberDO memberDO = new MemberDO();
        memberDO.setPassword(passwordEncoder.encode(password));
        memberDO.setEmail(email);
        memberDO.setRoleType(RoleType.ROLE_ADMIN.getRoleType());
        memberDO.setUserId(username);

        try {
            memberRepository.createMember(memberDO);
        } catch (Exception e) {
            log.error("{}", e, e);
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
