package com.mokimaki.arput.infrastructure.security;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class MyUserDetails extends User {
    private final com.mokimaki.arput.domain.model.user.User user;

    public MyUserDetails(com.mokimaki.arput.domain.model.user.User user) {
        super(user.getMailAddress(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }
}
