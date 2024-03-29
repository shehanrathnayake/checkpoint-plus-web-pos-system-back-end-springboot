package com.shehanrathnayake.util;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    MANAGER("manager"),
    TELLER("teller");
    private final String role;
    UserRole(String role) {
        this.role = role;
    }
    @JsonValue
    public String getRole() {
        return role;
    }
}
