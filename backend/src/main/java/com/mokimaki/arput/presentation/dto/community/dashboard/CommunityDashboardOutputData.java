package com.mokimaki.arput.presentation.dto.community.dashboard;

public class CommunityDashboardOutputData {
    public String id;
    public String name;
    public String description;
    public String entryCode;

    public CommunityDashboardOutputData(String id, String name, String description, String entryCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entryCode = entryCode;
    }
}
