package com.mokimaki.arput.domain.model.community;

import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
public class CommunityId {
    @NonNull
    private final String id;

    public CommunityId(
            @NonNull String id
    ) {
        this.id = id;
    }

    public CommunityId() {
        this.id = UUID.randomUUID().toString();
    }
}
