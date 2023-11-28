package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import com.mokimaki.arput.presentation.response.community.CommunityCreateResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/{userId}/community")
public interface CommunityRouting {
    @PostMapping("/")
    CommunityCreateResponse createCommunity(String userId, @RequestBody CommunityCreateRequest requestBody);
}
