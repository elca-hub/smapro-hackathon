package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.ArticleRouting;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateInputData;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateOutputData;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexInputData;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexOutputData;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowInputData;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowOutputData;
import com.mokimaki.arput.presentation.request.article.ArticleCreateRequest;
import com.mokimaki.arput.presentation.response.article.ArticleCreateResponse;
import com.mokimaki.arput.presentation.response.article.ArticleIndexResponse;
import com.mokimaki.arput.presentation.response.article.ArticleShowResponse;
import com.mokimaki.arput.usecase.article.CreateArticleUseCase;
import com.mokimaki.arput.usecase.article.IndexArticleUseCase;
import com.mokimaki.arput.usecase.article.ShowArticleUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleRouting {
    private final CreateArticleUseCase createArticleUseCase;
    private final ShowArticleUseCase showArticleUseCase;
    private final IndexArticleUseCase indexArticleUseCase;

    public ArticleController(
            CreateArticleUseCase createArticleUseCase,
            ShowArticleUseCase showArticleUseCase,
            IndexArticleUseCase indexArticleUseCase
    ) {
        this.createArticleUseCase = createArticleUseCase;
        this.showArticleUseCase = showArticleUseCase;
        this.indexArticleUseCase = indexArticleUseCase;
    }


    @Override
    public ArticleCreateResponse createArticle(@RequestAttribute String userId, @RequestBody ArticleCreateRequest articleCreateRequest) {
        var input = new ArticleCreateInputData(userId, articleCreateRequest.title(), articleCreateRequest.content());
        var response = new ArticleCreateResponse();

        try {
            ArticleCreateOutputData output = createArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public ArticleShowResponse showArticle(@RequestAttribute String userId, @PathVariable String articleId) {
        var input = new ArticleShowInputData(userId, articleId);
        var response = new ArticleShowResponse();

        try {
            ArticleShowOutputData output = showArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public ArticleIndexResponse indexArticle(@RequestAttribute String userId) {
        var input = new ArticleIndexInputData(userId);
        var response = new ArticleIndexResponse();

        try {
            List<ArticleIndexOutputData> output = indexArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
