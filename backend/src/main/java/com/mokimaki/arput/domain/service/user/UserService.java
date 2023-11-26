package com.mokimaki.arput.domain.service.user;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.IUserRepository;

import java.util.Optional;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isExistMailAddress(String mailAddress) {
        Optional<User> user = userRepository.findByMailAddress(mailAddress);
        return user.isPresent();
    }
}