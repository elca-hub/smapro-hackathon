package com.mokimaki.arput.domain.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class User {
    private UserId id;
    private String mailAddress;
    private String name;
    private String password;
    private String schoolName;

    public User(UserId id, String mailAddress, String name, String password, String schoolName) {
        this.id = id;
        this.mailAddress = mailAddress;
        this.name = name;
        this.password = password;
        this.schoolName = schoolName;
    }

    public User(String mailAddress, String name, String password, String schoolName) {
        this.id = new UserId();
        this.mailAddress = mailAddress;
        this.name = name;
        this.password = password;
        this.schoolName = schoolName;
    }
}
