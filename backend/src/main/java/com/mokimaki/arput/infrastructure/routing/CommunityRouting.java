package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/{userId}/community")
public interface CommunityRouting {
    @PostMapping("/")
    String createCommunity(String userId, @RequestBody CommunityCreateRequest requestBody);
}
