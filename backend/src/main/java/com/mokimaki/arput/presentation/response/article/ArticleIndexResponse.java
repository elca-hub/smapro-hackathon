package com.mokimaki.arput.presentation.response.article;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexOutputData;
import com.mokimaki.arput.presentation.response.ArputResponse;
import com.mokimaki.arput.presentation.response.ResponseStatus;

import java.util.List;

public class ArticleIndexResponse extends ArputResponse<List<ArticleIndexOutputData>> {
    public List<ArticleIndexOutputData> data = null;

    @Override
    public ArticleIndexResponse success(List<ArticleIndexOutputData> outputData) {
        data = outputData;
        status = ResponseStatus.SUCCESS;

        return this;
    }

    @Override
    public ArticleIndexResponse error(UseCaseException e) {
        status = ResponseStatus.ERROR;
        message = e.getMessage();

        return this;
    }
}
