package com.mokimaki.arput.presentation.response.user;

import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class UserLogoutResponse extends ArputResponse {
    public String message;

    public UserLogoutResponse(String message) {
        this.status = ResponseStatus.SUCCESS;
        this.message = message;
    }
}
