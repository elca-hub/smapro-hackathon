package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class UserUpdateResponse extends ArputResponse {
    public UserUpdateResponse() {
        this.status = ResponseStatus.SUCCESS;
    }

    public UserUpdateResponse(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();
    }
}
