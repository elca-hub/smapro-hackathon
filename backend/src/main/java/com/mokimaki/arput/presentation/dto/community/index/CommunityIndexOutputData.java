package com.mokimaki.arput.presentation.dto.community.index;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityIndexOutputData {
    public String name;
    public String description;

    public CommunityIndexOutputData(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
