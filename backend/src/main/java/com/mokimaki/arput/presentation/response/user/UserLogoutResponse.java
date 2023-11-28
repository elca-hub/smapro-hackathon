package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class UserLogoutResponse extends ArputResponse<String> {
    @Override
    public UserLogoutResponse success(String message) {
        this.status = ResponseStatus.SUCCESS;
        this.message = message;
        return this;
    }

    @Override
    public UserLogoutResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
