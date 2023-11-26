package com.mokimaki.arput.usecase.user;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.domain.service.user.UserService;
import com.mokimaki.arput.presentation.user.create.InputData;
import com.mokimaki.arput.presentation.user.create.OutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements IUseCase<InputData, OutputData> {
    private final IUserRepository userRepository;

    private final UserService userService;
    public CreateUserUseCase(IUserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    public OutputData execute(InputData input) {
        var user = new User(
                input.mailAddress(),
                input.name(),
                input.password(),
                input.schoolName(),
                input.bio()
        );

        if (!input.password().equals(input.passwordConfirmation())) {
            throw new RuntimeException("パスワードが一致しません");
        }

        if (userService.isExistMailAddress(input.mailAddress())) {
            throw new RuntimeException("メールアドレスが既に登録されています");
        }

        userRepository.create(user);

        UserId id = user.getId();

        return new OutputData(id.getId());
    }
}
