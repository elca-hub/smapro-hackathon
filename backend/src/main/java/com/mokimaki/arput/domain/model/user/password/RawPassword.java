package com.mokimaki.arput.domain.model.user.password;

import com.mokimaki.arput.infrastructure.security.utils.CryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RawPassword extends Password {

    public RawPassword(String password) {
        BCryptPasswordEncoder encoder = CryptPasswordEncoder.fetch();
        this.password = encoder.encode(password);
    }
}
