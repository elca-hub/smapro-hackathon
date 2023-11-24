package com.mokimaki.arput.usecase.user;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.presentation.user.create.InputData;
import com.mokimaki.arput.presentation.user.create.OutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements IUseCase<InputData, OutputData> {
    private final IUserRepository userRepository;
    public CreateUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public OutputData execute(InputData input) {
        var user = new User(
                input.mailAddress(),
                input.name(),
                input.password(),
                input.schoolName()
        );

        userRepository.create(user);

        UserId id = user.getId();

        return new OutputData(id.getId());
    }
}
