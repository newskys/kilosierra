package com.example.enumType;

import lombok.Getter;

@Getter
public enum RoleType {
    ROLE_ADMIN(1, "admin"),
    ROLE_MEMBER(2, "member"),
    ROLE_GUEST(3, "guest");

    private int roleType;
    private String name;

    RoleType(int type, String name) {
        this.roleType = type;
        this.name = name;
    }

    public static RoleType find(int roleType) {
        for (RoleType type : RoleType.values()) {
            if (type.roleType == roleType) {
                return type;
            }
        }

        return null;
    }
}
