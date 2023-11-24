package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {
    UserId create(User user);
}
