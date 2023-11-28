package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

import java.util.List;

public class CommunityDashboardResponse extends ArputResponse<List<CommunityDashboardOutputData>> {
    public List<CommunityDashboardOutputData> data;
    @Override
    public CommunityDashboardResponse success(List<CommunityDashboardOutputData> outputData) {
        this.data = outputData;
        this.status = ResponseStatus.SUCCESS;
        return this;
    }

    @Override
    public CommunityDashboardResponse error(UseCaseException e) {
        this.message = e.getMessage();
        this.status = ResponseStatus.ERROR;

        return this;
    }
}
