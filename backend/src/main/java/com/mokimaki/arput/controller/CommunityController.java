package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.CommunityRouting;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateInputData;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateOutputData;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardInputData;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardOutputData;
import com.mokimaki.arput.presentation.dto.community.delete.CommunityDeleteInputData;
import com.mokimaki.arput.presentation.dto.community.delete.CommunityDeleteOutputData;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexInputData;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexOutputData;
import com.mokimaki.arput.presentation.dto.community.update.CommunityUpdateInputData;
import com.mokimaki.arput.presentation.dto.community.update.CommunityUpdateOutputData;
import com.mokimaki.arput.presentation.request.community.CommunityCreateRequest;
import com.mokimaki.arput.presentation.request.community.CommunityUpdateRequest;
import com.mokimaki.arput.presentation.response.community.*;
import com.mokimaki.arput.usecase.community.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityController implements CommunityRouting {
    private final CreateCommunityUseCase createCommunityUseCase;
    private final CommunityDashboardUseCase communityDashboardUseCase;
    private final CommunityIndexUseCase communityIndexUseCase;
    private final CommunityUpdateUseCase communityUpdateUseCase;
    private final DeleteCommunityUseCase communityDeleteUseCase;

    public CommunityController(
            CreateCommunityUseCase createCommunityUseCase,
            CommunityDashboardUseCase communityDashboardUseCase,
            CommunityIndexUseCase communityIndexUseCase,
            CommunityUpdateUseCase communityUpdateUseCase,
            DeleteCommunityUseCase communityDeleteUseCase
    ) {
        this.createCommunityUseCase = createCommunityUseCase;
        this.communityDashboardUseCase = communityDashboardUseCase;
        this.communityIndexUseCase = communityIndexUseCase;
        this.communityUpdateUseCase = communityUpdateUseCase;
        this.communityDeleteUseCase = communityDeleteUseCase;
    }

    @Override
    public CommunityCreateResponse createCommunity(@RequestAttribute String userId, @RequestBody CommunityCreateRequest requestBody) {
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
    public CommunityDashboardResponse dashboard(@RequestAttribute String userId) {
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
    public CommunityIndexResponse index(@RequestAttribute String userId) {
        var input = new CommunityIndexInputData(userId);
        var response = new CommunityIndexResponse();
        try {
            List<CommunityIndexOutputData> output = communityIndexUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public CommunityUpdateResponse updateCommunity(@RequestAttribute String userId, @PathVariable("communityId") String communityId, @RequestBody CommunityUpdateRequest requestBody) {
        var input = new CommunityUpdateInputData(userId, communityId, requestBody.name(), requestBody.description());
        var response = new CommunityUpdateResponse();
        try {
            CommunityUpdateOutputData output = communityUpdateUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public CommunityDeleteResponse deleteCommunity(@RequestAttribute String userId, @PathVariable String communityId) {
        var input = new CommunityDeleteInputData(userId, communityId);
        var response = new CommunityDeleteResponse();

        try {
            CommunityDeleteOutputData output = communityDeleteUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
