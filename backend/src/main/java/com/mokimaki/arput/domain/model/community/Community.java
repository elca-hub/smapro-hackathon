package com.mokimaki.arput.domain.model.community;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Community {
    @NonNull
    private final CommunityId id;
    @NonNull
    private final String name;
    @NonNull
    private final String description;
    @NonNull
    private final EntryCode entryCode;

    public Community(
            @NonNull CommunityId id,
            @NonNull String name,
            @NonNull String description,
            @NonNull EntryCode entryCode
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entryCode = entryCode;
    }
}
