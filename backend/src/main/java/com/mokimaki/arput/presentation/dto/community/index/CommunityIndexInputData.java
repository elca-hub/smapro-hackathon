package com.mokimaki.arput.presentation.dto.community.index;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityIndexInputData {
    public String userId;

    public CommunityIndexInputData(String userId) {
        this.userId = userId;
    }
}
