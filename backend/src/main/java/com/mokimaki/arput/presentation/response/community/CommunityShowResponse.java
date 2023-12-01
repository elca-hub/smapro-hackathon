package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.show.CommunityShowOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class CommunityShowResponse extends ArputResponse<CommunityShowOutputData> {
    public CommunityShowOutputData data = null;

    @Override
    public CommunityShowResponse success(CommunityShowOutputData outputData) {
        this.data = outputData;
        this.status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public CommunityShowResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
