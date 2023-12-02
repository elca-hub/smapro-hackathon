package com.mokimaki.arput.presentation.dto.community.index;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityIndexOutputData {
    public String name;
    public String description;
    public String communityId;
    public int memberCount;

    public CommunityIndexOutputData(String communityId, String name, String description, int memberCount) {
        this.communityId = communityId;
        this.name = name;
        this.description = description;
        this.memberCount = memberCount;
    }
}
