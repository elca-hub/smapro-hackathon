package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.routing.UserRouting;
import com.mokimaki.arput.presentation.response.user.create.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.logout.UserLogoutResponse;
import com.mokimaki.arput.presentation.user.create.InputData;
import com.mokimaki.arput.presentation.user.create.OutputData;
import com.mokimaki.arput.usecase.user.CreateUserUseCase;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserRouting {
    private final CreateUserUseCase createUserUseCase;

    public UserController(@NonNull CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }
    @Override
    public UserCreateResponse createUser(@RequestBody InputData inputData) {
        OutputData output = createUserUseCase.execute(inputData);

        return new UserCreateResponse(output.userId());
    }

    @Override
    public String secret() {
        return "secret";
    }

    @Override
    public UserLogoutResponse logout() {
        return new UserLogoutResponse("logout");
    }
}
