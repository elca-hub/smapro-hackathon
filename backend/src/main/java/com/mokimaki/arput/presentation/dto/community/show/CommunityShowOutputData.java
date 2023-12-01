package com.mokimaki.arput.presentation.dto.community.show;

import java.util.List;

public record CommunityShowOutputData(
        String communityId,
        String name,
        String description,
        boolean isOwner,
        List<CommunityUserItem> members
) { }
