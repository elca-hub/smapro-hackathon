package com.mokimaki.arput.presentation.response.user.update;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.ResponseStatus;
import lombok.NonNull;

public class UserUpdateResponse {
    @NonNull
    public ResponseStatus status;
    public String message = null;

    public UserUpdateResponse() {
        this.status = ResponseStatus.SUCCESS;
    }

    public UserUpdateResponse(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();
    }
}
