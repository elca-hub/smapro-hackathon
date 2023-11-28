package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;
import com.mokimaki.arput.presentation.user.create.UserCreateOutputData;

public class UserCreateResponse extends ArputResponse {
    public String userId = null;

    public UserCreateResponse(UserCreateOutputData userCreateOutputData) {
        this.userId = userCreateOutputData.userId();
        this.status = ResponseStatus.SUCCESS;
    }

    public UserCreateResponse(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();
    }
}
