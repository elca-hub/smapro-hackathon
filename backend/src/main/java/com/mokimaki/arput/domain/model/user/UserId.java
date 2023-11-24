package com.mokimaki.arput.domain.model.user;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserId {
    private String id;

    public UserId() {
        this.id = UUID.randomUUID().toString();
    }

    public UserId(String id) {
        this.id = id;
    }
}
