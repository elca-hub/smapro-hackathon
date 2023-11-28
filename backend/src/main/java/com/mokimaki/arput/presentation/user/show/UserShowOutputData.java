package com.mokimaki.arput.presentation.user.show;

import com.mokimaki.arput.domain.model.user.User;

public class UserShowOutputData {
    private String userId;
    private String name;
    private String mailAddress;
    private String schoolName;
    private String bio;

    public UserShowOutputData(User user) {
        this.userId = user.getId().getId();
        this.name = user.getName();
        this.mailAddress = user.getMailAddress();
        this.schoolName = user.getSchoolName();
        this.bio = user.getBio();
    }
}
