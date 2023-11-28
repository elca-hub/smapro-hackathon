package com.mokimaki.arput.domain.model.user;

import com.mokimaki.arput.infrastructure.exception.DomainException;
import com.mokimaki.arput.infrastructure.security.utils.CryptPasswordEncoder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Slf4j
public class Password {
    private final int MIN_LENGTH = 8;
    private final int MAX_LENGTH = 20;

    private final String password;

    private final BCryptPasswordEncoder encoder = CryptPasswordEncoder.fetch();

    public Password(String password, boolean isEncrypted) {
        if (isEncrypted) {
            if (password.startsWith("$2a$")) {
                this.password = password;
                return;
            } else {
                throw new DomainException("パスワードがエンコードされていません");
            }
        }

        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            if (password.length() > MAX_LENGTH && password.startsWith("$2a$")) {
                log.warn("パスワードがエンコードされている可能性があります");
            }

            throw new DomainException("パスワードは8文字以上20文字以下である必要があります");
        }
        this.password = encoder.encode(password);
    }
}
