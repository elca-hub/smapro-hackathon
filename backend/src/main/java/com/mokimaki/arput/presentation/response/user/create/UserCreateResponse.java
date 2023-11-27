package com.mokimaki.arput.presentation.response.user.create;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.ResponseStatus;
import com.mokimaki.arput.presentation.user.create.OutputData;
import lombok.NonNull;

public class UserCreateResponse {
    public String userId = null;

    @NonNull
    public ResponseStatus status;
    public String message = null;

    public UserCreateResponse(OutputData outputData) {
        this.userId = outputData.userId();
        this.status = ResponseStatus.SUCCESS;
    }

    public UserCreateResponse(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();
    }
}
