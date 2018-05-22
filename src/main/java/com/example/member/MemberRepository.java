package com.example.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class MemberRepository {
    @Autowired
    MemberDAO memberDAO;

    public void createMember(MemberDO memberDO) {
        memberDAO.save(memberDO);
    }

    public void deleteMember(String userId) {
        memberDAO.deleteByUserId(userId);
    }

    public MemberDO selectMemberByUserId(String userId) {
        return memberDAO.selectByUserId(userId);
    }

    public boolean isMember(String id) {
        return !ObjectUtils.isEmpty(memberDAO.selectByUserId(id));
    }
}
