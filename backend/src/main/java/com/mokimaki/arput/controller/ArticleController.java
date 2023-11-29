package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.ArticleRouting;
import com.mokimaki.arput.presentation.dto.article.ArticleCreateInputData;
import com.mokimaki.arput.presentation.dto.article.ArticleCreateOutputData;
import com.mokimaki.arput.presentation.request.article.ArticleCreateRequest;
import com.mokimaki.arput.presentation.response.article.ArticleCreateResponse;
import com.mokimaki.arput.usecase.article.CreateArticleUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController implements ArticleRouting {
    private final CreateArticleUseCase createArticleUseCase;

    public ArticleController(CreateArticleUseCase createArticleUseCase) {
        this.createArticleUseCase = createArticleUseCase;
    }


    @Override
    public ArticleCreateResponse createArticle(@PathVariable String userId, @RequestBody ArticleCreateRequest articleCreateRequest) {
        var input = new ArticleCreateInputData(userId, articleCreateRequest.title(), articleCreateRequest.content());
        var response = new ArticleCreateResponse();

        try {
            ArticleCreateOutputData output = createArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
