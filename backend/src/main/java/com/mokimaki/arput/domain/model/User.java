package com.mokimaki.arput.domain.model;

import lombok.Setter;

import java.util.UUID;

@Setter
public class User {
    private String id;
    private String mailAddress;
    private String name;
    private String schoolName;

    public User(String id, String mailAddress, String name, String schoolName) {
        this.id = id;
        this.mailAddress = mailAddress;
        this.name = name;
        this.schoolName = schoolName;
    }

    public User(String mailAddress, String name, String schoolName) {
        this.id = UUID.randomUUID().toString();
        this.mailAddress = mailAddress;
        this.name = name;
        this.schoolName = schoolName;
    }
}
