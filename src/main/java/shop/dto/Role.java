package shop.dto;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, GENERAL_USER;

    public String getAuthority() {
        return name();
    }

}
