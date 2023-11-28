package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class CommunityCreateResponse extends ArputResponse<CommunityCreateOutputData> {
    @Override
    public CommunityCreateResponse success(CommunityCreateOutputData outputData) {
        this.status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public CommunityCreateResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
