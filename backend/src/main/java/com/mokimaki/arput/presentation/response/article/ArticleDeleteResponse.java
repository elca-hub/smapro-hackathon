package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class ArticleDeleteResponse extends ArputResponse<ArticleDeleteOutputData> {
    @Override
    public ArticleDeleteResponse success(ArticleDeleteOutputData outputData) {
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public ArticleDeleteResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
