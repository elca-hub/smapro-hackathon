package com.mokimaki.arput.presentation.dto.community.show;

import java.util.List;

public record CommunityShowOutputData(
        String communityId,
        String name,
        String description,
        boolean isOwner,
        String entryCode,
        List<CommunityUserItem> members
) { }
