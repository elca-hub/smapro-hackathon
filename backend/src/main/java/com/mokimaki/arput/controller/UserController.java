package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.routing.UserRouting;
import com.mokimaki.arput.presentation.user.create.InputData;
import com.mokimaki.arput.presentation.user.create.OutputData;
import com.mokimaki.arput.usecase.user.CreateUserUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserRouting {
    @NonNull
    private final CreateUserUseCase createUserUseCase;
    @Override
    public String createUser(InputData inputData) {
        OutputData output = createUserUseCase.execute(inputData);

        return output.userId();
    }
}
