package com.mokimaki.arput.domain.model.user;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class User {
    @NonNull
    private final UserId id;
    @NonNull
    private final String mailAddress;
    @NonNull
    private final String name;
    @NonNull
    private final String password;
    @NonNull
    private final String schoolName;

    private final String bio;

    public User(
            @NonNull UserId id,
            @NonNull String mailAddress,
            @NonNull String name,
            @NonNull String password,
            @NonNull String schoolName,
            String bio
    ) {
        this.id = id;
        this.mailAddress = mailAddress;
        this.name = name;
        this.password = password;
        this.schoolName = schoolName;
        this.bio = bio;
    }

    public User(
            @NonNull String mailAddress,
            @NonNull String name,
            @NonNull String password,
            @NonNull String schoolName,
            String bio
    ) {
        this.id = new UserId();
        this.mailAddress = mailAddress;
        this.name = name;
        this.password = password;
        this.schoolName = schoolName;
        this.bio = bio;
    }
}
