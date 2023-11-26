package com.mokimaki.arput.domain.model.user;

import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
public class UserId {
    @NonNull
    private final String id;

    public UserId() {
        this.id = UUID.randomUUID().toString();
    }

    public UserId(@NonNull String id) {
        this.id = id;
    }
}
