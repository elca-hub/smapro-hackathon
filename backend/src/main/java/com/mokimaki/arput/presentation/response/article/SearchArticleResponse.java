package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.search.ArticleSearchOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

public class SearchArticleResponse extends ArputResponse<ArticleSearchOutputData> {
    public ArticleSearchOutputData data = null;

    @Override
    public SearchArticleResponse success(ArticleSearchOutputData outputData) {
        this.data = outputData;
        this.status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public SearchArticleResponse error(UseCaseException e) {
        this.status = ResponseStatus.ERROR;
        this.message = e.getMessage();

        return this;
    }
}
