package com.mokimaki.arput.domain.model.user;

import com.mokimaki.arput.infrastructure.exception.DomainException;
import com.mokimaki.arput.infrastructure.security.utils.CryptPasswordEncoder;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class Password {
    private final int MIN_LENGTH = 8;
    private final int MAX_LENGTH = 20;

    private final String password;

    private final BCryptPasswordEncoder encoder = CryptPasswordEncoder.fetch();

    public Password(String password) {
        if (password.startsWith("$2a$")) {
            this.password = password;
            return;
        }

        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            throw new DomainException("パスワードは8文字以上20文字以下である必要があります");
        }
        this.password = encoder.encode(password);
    }
}
