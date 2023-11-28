package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;
import com.mokimaki.arput.presentation.user.create.UserCreateOutputData;

public class UserCreateResponse extends ArputResponse<UserCreateOutputData> {
    public String userId;

    @Override
    public UserCreateResponse success(UserCreateOutputData outputData) {
        this.userId = outputData.userId();
        this.status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public UserCreateResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
