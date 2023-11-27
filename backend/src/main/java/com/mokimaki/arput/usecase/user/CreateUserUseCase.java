package com.mokimaki.arput.usecase.user;

import com.mokimaki.arput.domain.model.user.Password;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.domain.service.user.UserService;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.user.create.UserCreateInputData;
import com.mokimaki.arput.presentation.user.create.UserCreateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements IUseCase<UserCreateInputData, UserCreateOutputData> {
    private final IUserRepository userRepository;

    private final UserService userService;
    public CreateUserUseCase(IUserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    public UserCreateOutputData execute(UserCreateInputData input) throws UseCaseException {
        var user = new User(
                input.mailAddress(),
                input.name(),
                new Password(input.password()),
                input.schoolName(),
                input.bio()
        );

        if (!input.password().equals(input.passwordConfirmation())) {
            throw new UseCaseException("パスワードが一致しません");
        }

        if (userService.isExistMailAddress(input.mailAddress())) {
            throw new UseCaseException("メールアドレスが既に登録されています");
        }

        userRepository.create(user);

        UserId id = user.getId();

        return new UserCreateOutputData(id.getId());
    }
}
