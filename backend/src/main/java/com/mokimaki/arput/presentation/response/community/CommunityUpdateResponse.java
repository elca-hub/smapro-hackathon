package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.update.CommunityUpdateOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class CommunityUpdateResponse extends ArputResponse<CommunityUpdateOutputData> {
    @Override
    public CommunityUpdateResponse success(CommunityUpdateOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public CommunityUpdateResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
