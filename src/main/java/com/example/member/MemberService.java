package com.example.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(String userId) {
        memberRepository.deleteByUserId(userId);
    }

    public Member selectMemberByUserId(String userId) {
        return memberRepository.selectByUserId(userId);
    }

    public boolean isMember(String id) {
        return !ObjectUtils.isEmpty(memberRepository.selectByUserId(id));
    }
}
