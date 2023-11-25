package com.mokimaki.arput.infrastructure.security;

import com.mokimaki.arput.domain.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class MyLogoutService {
    private final IUserRepository userRepository;

    public MyLogoutService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void logout(String mailAddress) {
        userRepository.resetToken(mailAddress);
    }
}
