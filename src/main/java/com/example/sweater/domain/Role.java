package com.example.sweater.domain;

import org.springframework.security.core.GrantedAuthority;

/** A class that cares about user's roles. */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
