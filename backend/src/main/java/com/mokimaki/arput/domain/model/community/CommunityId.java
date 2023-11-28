package com.mokimaki.arput.domain.model.community;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class CommunityId {
    @NonNull
    private final String id;

    public CommunityId(
            @NonNull String id
    ) {
        this.id = id;
    }
}
