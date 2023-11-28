package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.CommunityRouting;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateInputData;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateOutputData;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardInputData;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardOutputData;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexInputData;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexOutputData;
import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import com.mokimaki.arput.presentation.response.community.CommunityCreateResponse;
import com.mokimaki.arput.presentation.response.community.CommunityDashboardResponse;
import com.mokimaki.arput.presentation.response.community.CommunityIndexResponse;
import com.mokimaki.arput.usecase.community.CommunityDashboardUseCase;
import com.mokimaki.arput.usecase.community.CommunityIndexUseCase;
import com.mokimaki.arput.usecase.community.CreateCommunityUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityController implements CommunityRouting {
    private final CreateCommunityUseCase createCommunityUseCase;
    private final CommunityDashboardUseCase communityDashboardUseCase;
    private final CommunityIndexUseCase communityIndexUseCase;

    public CommunityController(
            CreateCommunityUseCase createCommunityUseCase,
            CommunityDashboardUseCase communityDashboardUseCase,
            CommunityIndexUseCase communityIndexUseCase
    ) {
        this.createCommunityUseCase = createCommunityUseCase;
        this.communityDashboardUseCase = communityDashboardUseCase;
        this.communityIndexUseCase = communityIndexUseCase;
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

    @Override
    public CommunityDashboardResponse dashboard(@PathVariable("userId") String userId) {
        var input = new CommunityDashboardInputData(userId);
        var communityDashboardResponse = new CommunityDashboardResponse();
        try {
            List<CommunityDashboardOutputData> output = communityDashboardUseCase.execute(input);

            return communityDashboardResponse.success(output);
        } catch (UseCaseException e) {
            return communityDashboardResponse.error(e);
        }
    }

    @Override
    public CommunityIndexResponse index(@PathVariable String userId) {
        var input = new CommunityIndexInputData(userId);
        var response = new CommunityIndexResponse();
        try {
            List<CommunityIndexOutputData> output = communityIndexUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
