package com.example.config;

import com.example.member.MemberRepository;
import com.example.member.SecurityMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return
                Optional.ofNullable(memberRepository.selectMemberByUserId(userId))
                        .filter(Objects::nonNull)
                        .map(SecurityMember::new).get();
    }
}
