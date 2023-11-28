package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.UserRouting;
import com.mokimaki.arput.presentation.request.user.UserUpdateRequest;
import com.mokimaki.arput.presentation.response.user.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.UserLogoutResponse;
import com.mokimaki.arput.presentation.response.user.UserShowResponse;
import com.mokimaki.arput.presentation.response.user.UserUpdateResponse;
import com.mokimaki.arput.presentation.user.create.UserCreateInputData;
import com.mokimaki.arput.presentation.user.create.UserCreateOutputData;
import com.mokimaki.arput.presentation.user.show.UserShowInputData;
import com.mokimaki.arput.presentation.user.show.UserShowOutputData;
import com.mokimaki.arput.presentation.user.update.UserUpdateInputData;
import com.mokimaki.arput.presentation.user.update.UserUpdateOutputData;
import com.mokimaki.arput.usecase.user.CreateUserUseCase;
import com.mokimaki.arput.usecase.user.ShowUserUseCase;
import com.mokimaki.arput.usecase.user.UpdateUserUseCase;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserRouting {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final ShowUserUseCase showUserUseCase;

    public UserController(
            @NonNull CreateUserUseCase createUserUseCase,
            @NonNull UpdateUserUseCase updateUserUseCase,
            @NonNull ShowUserUseCase showUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.showUserUseCase = showUserUseCase;
    }
    @Override
    public UserCreateResponse createUser(@RequestBody UserCreateInputData inputData) {
        var response = new UserCreateResponse();
        try {
            UserCreateOutputData output = createUserUseCase.execute(inputData);
            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public String secret() {
        return "secret";
    }

    @Override
    public UserLogoutResponse logout() {
        return new UserLogoutResponse().success("logout");
    }

    @Override
    public UserShowResponse getUser(@PathVariable String userId) {
        var input = new UserShowInputData(userId);
        var response = new UserShowResponse();
        try {
            UserShowOutputData output = showUserUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public UserUpdateResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest inputData) {
        var input = new UserUpdateInputData(userId, inputData);
        var response = new UserUpdateResponse();
        try {
            UserUpdateOutputData outputData = updateUserUseCase.execute(input);
            return response.success(outputData);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
