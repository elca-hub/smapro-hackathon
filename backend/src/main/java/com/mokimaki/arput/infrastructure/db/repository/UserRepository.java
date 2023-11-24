package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.db.context.UserContext;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRepository {
    @NonNull
    private UserContext userContext;

    @Override
    public void create(User user) {
        var userEntity = new UserEntity();
        userEntity.convert(user);

        userContext.save(userEntity);
    }

    @Override
    public Optional<User> findByMailAddress(String mailAddress) {
        return userContext.findByMailAddress(mailAddress).map(entity -> new User(
               new UserId(entity.id),
               entity.mailAddress,
               entity.userName,
               entity.password,
               entity.schoolName
       ));
    }
}
