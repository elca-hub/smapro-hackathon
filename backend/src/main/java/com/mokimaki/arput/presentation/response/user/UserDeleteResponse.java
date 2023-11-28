package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;
import com.mokimaki.arput.presentation.dto.user.delete.UserDeleteOutputData;

public class UserDeleteResponse extends ArputResponse<UserDeleteOutputData> {
    @Override
    public UserDeleteResponse success(UserDeleteOutputData data) {
        this.status = ResponseStatus.SUCCESS;
        return this;
    }

    @Override
    public UserDeleteResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
