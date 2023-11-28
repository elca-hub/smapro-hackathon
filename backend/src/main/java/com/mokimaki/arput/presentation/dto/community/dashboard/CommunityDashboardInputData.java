package com.mokimaki.arput.presentation.dto.community.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityDashboardInputData {
    public String userId;

    public CommunityDashboardInputData(String userId) {
        this.userId = userId;
    }
}
