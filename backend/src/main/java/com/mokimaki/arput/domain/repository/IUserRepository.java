package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository {
    void create(User user);

    Optional<User> findByMailAddress(String mailAddress);
}
