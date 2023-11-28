package com.mokimaki.arput.presentation.dto.community.create;

public class CommunityCreateInputData {
    public String userId;
    public String name;
    public String description;

    public CommunityCreateInputData(String userId, String name, String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
    }
}
