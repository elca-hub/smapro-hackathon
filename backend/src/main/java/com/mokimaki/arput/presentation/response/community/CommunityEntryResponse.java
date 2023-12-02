package com.mokimaki.arput.presentation.response.community;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.entry.CommunityEntryOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class CommunityEntryResponse extends ArputResponse<CommunityEntryOutputData> {
    public CommunityEntryOutputData data = null;

    @Override
    public CommunityEntryResponse success(CommunityEntryOutputData outputData) {
        this.data = outputData;
        this.status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public CommunityEntryResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
