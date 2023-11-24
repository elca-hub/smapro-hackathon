package com.mokimaki.arput.infrastructure.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    private String mailAddress;
    private String password;
}
