package com.mokimaki.arput.presentation.dto.community.join;

public record CommunityJoinInputData (
        String userId,
        String communityId,
        String entryCode
) { }
