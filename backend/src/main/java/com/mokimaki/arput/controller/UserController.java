package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.UserRouting;
import com.mokimaki.arput.presentation.response.user.create.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.logout.UserLogoutResponse;
import com.mokimaki.arput.presentation.response.user.update.UserUpdateResponse;
import com.mokimaki.arput.presentation.user.create.UserCreateInputData;
import com.mokimaki.arput.presentation.user.create.UserCreateOutputData;
import com.mokimaki.arput.presentation.user.update.UserUpdateInputData;
import com.mokimaki.arput.usecase.user.CreateUserUseCase;
import com.mokimaki.arput.usecase.user.UpdateUserUseCase;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserRouting {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(
            @NonNull CreateUserUseCase createUserUseCase,
            @NonNull UpdateUserUseCase updateUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }
    @Override
    public UserCreateResponse createUser(@RequestBody UserCreateInputData inputData) {
        try {
            UserCreateOutputData output = createUserUseCase.execute(inputData);
            return new UserCreateResponse(output);
        } catch (UseCaseException e) {
            return new UserCreateResponse(e);
        }
    }

    @Override
    public String secret() {
        return "secret";
    }

    @Override
    public UserLogoutResponse logout() {
        return new UserLogoutResponse("logout");
    }

    @Override
    public String getUser(@PathVariable String userId) {
        return "user";
    }

    @Override
    public UserUpdateResponse updateUser(@RequestBody UserUpdateInputData inputData) {
        try {
            updateUserUseCase.execute(inputData);
            return new UserUpdateResponse();
        } catch (UseCaseException e) {
            return new UserUpdateResponse(e);
        }
    }
}
