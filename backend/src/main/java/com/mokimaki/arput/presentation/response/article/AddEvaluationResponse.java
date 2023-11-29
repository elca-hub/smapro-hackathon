package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class AddEvaluationResponse extends ArputResponse<AddEvaluationOutputData> {
    @Override
    public AddEvaluationResponse success(AddEvaluationOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public AddEvaluationResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
