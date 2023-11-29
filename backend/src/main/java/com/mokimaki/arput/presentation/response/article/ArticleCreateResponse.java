package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class ArticleCreateResponse extends ArputResponse<ArticleCreateOutputData> {
    @Override
    public ArticleCreateResponse success(ArticleCreateOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public ArticleCreateResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
