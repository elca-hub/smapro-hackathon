package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.removeEvaluation.RemoveEvaluationOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class RemoveEvaluationResponse extends ArputResponse<RemoveEvaluationOutputData> {
    @Override
    public RemoveEvaluationResponse success(RemoveEvaluationOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public RemoveEvaluationResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
