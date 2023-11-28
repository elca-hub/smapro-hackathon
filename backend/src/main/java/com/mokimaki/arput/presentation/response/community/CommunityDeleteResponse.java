package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.delete.CommunityDeleteOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class CommunityDeleteResponse extends ArputResponse<CommunityDeleteOutputData> {
    @Override
    public CommunityDeleteResponse success(CommunityDeleteOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public CommunityDeleteResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
