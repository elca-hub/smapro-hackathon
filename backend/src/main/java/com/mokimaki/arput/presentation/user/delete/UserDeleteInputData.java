package com.mokimaki.arput.presentation.user.delete;

import lombok.Getter;

@Getter
public class UserDeleteInputData {
    private final String userId;

    public UserDeleteInputData(String userId) {
        this.userId = userId;
    }
}
