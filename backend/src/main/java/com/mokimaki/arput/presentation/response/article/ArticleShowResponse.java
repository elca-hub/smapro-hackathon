package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class ArticleShowResponse extends ArputResponse<ArticleShowOutputData> {
    public ArticleShowOutputData data = null;

    @Override
    public ArticleShowResponse success(ArticleShowOutputData outputData) {
        data = outputData;
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public ArticleShowResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
