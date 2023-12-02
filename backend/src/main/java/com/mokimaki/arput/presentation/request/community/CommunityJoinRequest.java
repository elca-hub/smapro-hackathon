package com.mokimaki.arput.presentation.request.community;

public record CommunityJoinRequest(
        String communityId,
        String entryCode
) { }
