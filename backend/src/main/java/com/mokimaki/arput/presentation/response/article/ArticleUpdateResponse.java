package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class ArticleUpdateResponse extends ArputResponse<ArticleUpdateOutputData> {
    @Override
    public ArticleUpdateResponse success(ArticleUpdateOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public ArticleUpdateResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
