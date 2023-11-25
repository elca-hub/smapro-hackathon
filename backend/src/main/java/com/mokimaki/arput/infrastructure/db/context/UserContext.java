package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserContext extends CrudRepository<UserEntity, String> {
    Optional<UserEntity> findByMailAddress(String mailAddress);
    Optional<UserEntity> findByToken(String token);
}
