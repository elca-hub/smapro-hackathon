package com.mokimaki.arput.presentation.dto.community.index;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityIndexOutputData {
    public String name;
    public String description;
    public String communityId;

    public CommunityIndexOutputData(String communityId, String name, String description) {
        this.communityId = communityId;
        this.name = name;
        this.description = description;
    }
}
