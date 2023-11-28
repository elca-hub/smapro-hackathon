package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import com.mokimaki.arput.presentation.response.community.CommunityCreateResponse;
import com.mokimaki.arput.presentation.response.community.CommunityDashboardResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/{userId}/community")
public interface CommunityRouting {
    @PostMapping("/")
    CommunityCreateResponse createCommunity(String userId, @RequestBody CommunityCreateRequest requestBody);

    @GetMapping("/dashboard")
    CommunityDashboardResponse dashboard(String userId);
}
