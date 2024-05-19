package org.example.store.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ALL,
    USER,
    MANAGER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
