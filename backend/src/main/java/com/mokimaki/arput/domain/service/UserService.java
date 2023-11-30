package com.mokimaki.arput.domain.service;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isExistMailAddress(String mailAddress) {
        Optional<User> user = userRepository.findByMailAddress(mailAddress);
        return user.isPresent();
    }

    public boolean isExist(UserId userId) {
        Optional<User> user = userRepository.findById(userId.getId());
        return user.isPresent();
    }
}
