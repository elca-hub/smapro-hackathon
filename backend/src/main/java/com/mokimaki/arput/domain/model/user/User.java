package com.mokimaki.arput.domain.model.user;

import com.mokimaki.arput.domain.model.user.password.Password;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class User {
    @NonNull
    private final UserId id;
    @NonNull
    private String mailAddress;
    @NonNull
    private String name;
    @NonNull
    private Password password;
    @NonNull
    private String schoolName;

    private String bio;

    public User(
            @NonNull UserId id,
            @NonNull String mailAddress,
            @NonNull String name,
            @NonNull Password password,
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
            @NonNull Password password,
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
