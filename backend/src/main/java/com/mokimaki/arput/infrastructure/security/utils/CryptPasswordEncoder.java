package com.mokimaki.arput.infrastructure.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptPasswordEncoder {
    public static BCryptPasswordEncoder fetch() {
        return new BCryptPasswordEncoder(8);
    }
}
