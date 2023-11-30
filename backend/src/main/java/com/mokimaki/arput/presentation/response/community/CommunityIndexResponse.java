package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

import java.util.List;

public class CommunityIndexResponse extends ArputResponse<List<CommunityIndexOutputData>> {
    public List<CommunityIndexOutputData> data;

    @Override
    public CommunityIndexResponse success(List<CommunityIndexOutputData> outputData) {
        status = ResponseStatus.SUCCESS;
        data = outputData;

        return this;
    }

    @Override
    public CommunityIndexResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
