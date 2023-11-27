package com.mokimaki.arput.infrastructure.security;

import com.mokimaki.arput.infrastructure.security.utils.UserSecurity;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class MyUserDetails extends User {
    private final UserSecurity user;

    public MyUserDetails(UserSecurity user) {
        super(user.getMailAddress(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }
}
