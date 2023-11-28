package com.mokimaki.arput.presentation.dto.community.delete;

public class CommunityDeleteInputData {
    public String userId;
    public String communityId;

    public CommunityDeleteInputData(String userId, String communityId) {
        this.userId = userId;
        this.communityId = communityId;
    }
}
