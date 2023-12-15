package com.example.chatserver.entity.enums;

import com.example.chatserver.exception.custom.EnumStateNotFoundException;
import java.util.Arrays;

public enum UserRole {
    ADMIN,
    NORMAL;

    public static UserRole toConverter(final String name) {
        return Arrays.stream(UserRole.values())
            .filter(userRole -> userRole.name().equals(name))
            .findFirst()
            .orElseThrow(
                () -> EnumStateNotFoundException.ofUserRole(name)
            );
    }
}
