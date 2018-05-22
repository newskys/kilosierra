package com.example.member;

import com.example.enumType.RoleType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class SecurityMember extends User {
    private static final long serialVersionUID = 3382944892218208166L;

    public SecurityMember(MemberDO memberDO) {
        super(memberDO.getUserId(), memberDO.getPassword(), makeGrantedAuthority(memberDO.getRoleType()));
    }

    private static Collection<? extends GrantedAuthority> makeGrantedAuthority(int roleType) {
        List<GrantedAuthority> list = Arrays.asList(new SimpleGrantedAuthority(RoleType.find(roleType).getName()));
//        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
        return list;
    }
}
