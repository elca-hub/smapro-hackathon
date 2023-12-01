package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import com.mokimaki.arput.presentation.request.community.CommunityUpdateRequest;
import com.mokimaki.arput.presentation.response.community.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/community")
public interface CommunityRouting {
    @PostMapping("/")
    CommunityCreateResponse createCommunity(String userId, @RequestBody CommunityCreateRequest requestBody);

    @GetMapping("/dashboard")
    CommunityDashboardResponse dashboard(String userId);

    @GetMapping("/")
    CommunityIndexResponse index(String userId);

    @PutMapping("/{communityId}")
    CommunityUpdateResponse updateCommunity(String userId, String communityId, @RequestBody CommunityUpdateRequest requestBody);

    @DeleteMapping("/{communityId}")
    CommunityDeleteResponse deleteCommunity(String userId, String communityId);

    @GetMapping("/{communityId}")
    CommunityShowResponse showCommunity(String userId, String communityId);
}
