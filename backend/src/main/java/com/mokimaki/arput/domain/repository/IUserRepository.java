package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;

public interface IUserRepository {
    UserId create(User user);
}
