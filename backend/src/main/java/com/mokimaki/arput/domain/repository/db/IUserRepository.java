package com.mokimaki.arput.domain.repository.db;

import com.mokimaki.arput.domain.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository {
    void create(User user);
    Optional<User> findById(String id);
    Optional<User> findByMailAddress(String mailAddress);
    Optional<User> findByToken(String token);
    void updateToken(String mailAddress, String token);
    void resetToken(String mailAddress);
    void update(User user);
    void delete(String id);
}
