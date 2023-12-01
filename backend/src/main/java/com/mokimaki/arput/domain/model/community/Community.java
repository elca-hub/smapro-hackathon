package com.mokimaki.arput.domain.model.community;


import com.mokimaki.arput.domain.model.user.User;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Community {
    @NonNull
    private final CommunityId id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private final EntryCode entryCode;
    private final User owner;
    private final List<User> members;

    public Community(
            @NonNull CommunityId id,
            @NonNull String name,
            @NonNull String description,
            @NonNull EntryCode entryCode,
            User owner,
            List<User> members
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entryCode = entryCode;
        this.owner = owner;
        this.members = members;
    }

    public boolean isOwner(User user) {
        return this.owner.getId().getId().equals(user.getId().getId());
    }
}
