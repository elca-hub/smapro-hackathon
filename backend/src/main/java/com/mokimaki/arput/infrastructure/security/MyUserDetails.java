package com.mokimaki.arput.infrastructure.security;

import com.mokimaki.arput.infrastructure.security.utils.UserSecurity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Getter
public class MyUserDetails extends User {
    private final UserSecurity user;

    public MyUserDetails(UserSecurity user) {
        super(user.getMailAddress(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        this.user = user;
    }
}
