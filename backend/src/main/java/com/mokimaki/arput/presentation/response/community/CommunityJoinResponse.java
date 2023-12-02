package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.join.CommunityJoinOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class CommunityJoinResponse extends ArputResponse<CommunityJoinOutputData> {
    @Override
    public CommunityJoinResponse success(CommunityJoinOutputData outputData) {
        this.status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public CommunityJoinResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
