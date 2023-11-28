package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;
import com.mokimaki.arput.presentation.dto.user.update.UserUpdateOutputData;

public class UserUpdateResponse extends ArputResponse<UserUpdateOutputData> {
    @Override
    public UserUpdateResponse success(UserUpdateOutputData outputData) {
        this.status = ResponseStatus.SUCCESS;
        return this;
    }

    @Override
    public UserUpdateResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
