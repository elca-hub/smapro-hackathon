package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.routing.CommunityRouting;
import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController implements CommunityRouting {
    @Override
    public String createCommunity(@PathVariable String userId, @RequestBody CommunityCreateRequest requestBody) {
        return userId + " " + requestBody.name();
    }
}
