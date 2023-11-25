package com.mokimaki.arput.infrastructure.security.utils;

import com.mokimaki.arput.domain.model.user.User;
import lombok.Getter;

@Getter
public class UserSecurity {
    private String mailAddress;
    private String password;

    public UserSecurity(String mailAddress, String password) {
        this.mailAddress = mailAddress;
        this.password = password;
    }

    public UserSecurity(User user) {
        this.mailAddress = user.getMailAddress();
        this.password = user.getPassword();
    }
}
