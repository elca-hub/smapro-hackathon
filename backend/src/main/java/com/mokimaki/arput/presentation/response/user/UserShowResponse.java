package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;
import com.mokimaki.arput.presentation.user.show.UserShowOutputData;

public class UserShowResponse extends ArputResponse<UserShowOutputData> {
    public UserShowOutputData data = null;
    @Override
    public UserShowResponse success(UserShowOutputData outputData) {
        this.status = ResponseStatus.SUCCESS;
        this.data = outputData;

        return this;
    }

    @Override
    public UserShowResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
