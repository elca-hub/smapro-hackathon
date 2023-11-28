package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.CommunityRouting;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateInputData;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateOutputData;
import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import com.mokimaki.arput.presentation.response.community.CommunityCreateResponse;
import com.mokimaki.arput.usecase.community.CreateCommunityUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController implements CommunityRouting {
    private CreateCommunityUseCase createCommunityUseCase;

    public CommunityController(CreateCommunityUseCase createCommunityUseCase) {
        this.createCommunityUseCase = createCommunityUseCase;
    }

    @Override
    public CommunityCreateResponse createCommunity(@PathVariable("userId") String userId, @RequestBody CommunityCreateRequest requestBody) {
        var input = new CommunityCreateInputData(userId, requestBody.name(), requestBody.description());
        var communityCreateResponse = new CommunityCreateResponse();

        try {
            CommunityCreateOutputData output = createCommunityUseCase.execute(input);

            return communityCreateResponse.success(output);
        } catch (UseCaseException e) {
            return communityCreateResponse.error(e);
        }
    }
}
