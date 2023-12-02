package com.mokimaki.arput.presentation.dto.community.entry;

import com.mokimaki.arput.domain.model.community.Community;
import lombok.Getter;

@Getter
public class CommunityEntryOutputData {
    private final String id;
    private final String name;

    public CommunityEntryOutputData(Community community) {
        this.id = community.getId().getId();
        this.name = community.getName();
    }
}
