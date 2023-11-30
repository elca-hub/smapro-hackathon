package com.mokimaki.arput.presentation.dto.community.update;

public class CommunityUpdateInputData {
    public String userId;
    public String communityId;
    public String communityName;
    public String communityDescription;

    public CommunityUpdateInputData(String userId, String communityId, String communityName, String communityDescription) {
        this.userId = userId;
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityDescription = communityDescription;
    }
}
