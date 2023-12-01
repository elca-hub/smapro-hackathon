package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.ArticleRouting;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateInputData;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateOutputData;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteInputData;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteOutputData;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexInputData;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexOutputData;
import com.mokimaki.arput.presentation.dto.article.search.ArticleSearchInputData;
import com.mokimaki.arput.presentation.dto.article.search.ArticleSearchOutputData;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowInputData;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowOutputData;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateInputData;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateOutputData;
import com.mokimaki.arput.presentation.request.article.ArticleCreateRequest;
import com.mokimaki.arput.presentation.request.article.ArticleUpdateRequest;
import com.mokimaki.arput.presentation.response.article.*;
import com.mokimaki.arput.usecase.article.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController implements ArticleRouting {
    private final CreateArticleUseCase createArticleUseCase;
    private final ShowArticleUseCase showArticleUseCase;
    private final IndexArticleUseCase indexArticleUseCase;
    private final UpdateArticleUseCase updateArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;
    private final SearchArticleUseCase searchArticleUseCase;

    public ArticleController(
            CreateArticleUseCase createArticleUseCase,
            ShowArticleUseCase showArticleUseCase,
            IndexArticleUseCase indexArticleUseCase,
            UpdateArticleUseCase updateArticleUseCase,
            DeleteArticleUseCase deleteArticleUseCase,
            SearchArticleUseCase searchArticleUseCase
    ) {
        this.createArticleUseCase = createArticleUseCase;
        this.showArticleUseCase = showArticleUseCase;
        this.indexArticleUseCase = indexArticleUseCase;
        this.updateArticleUseCase = updateArticleUseCase;
        this.deleteArticleUseCase = deleteArticleUseCase;
        this.searchArticleUseCase = searchArticleUseCase;
    }


    @Override
    public ArticleCreateResponse createArticle(@RequestAttribute String userId, @RequestBody ArticleCreateRequest articleCreateRequest) {
        var input = new ArticleCreateInputData(userId, articleCreateRequest.title(), articleCreateRequest.content(), articleCreateRequest.communityId());
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

    @Override
    public ArticleUpdateResponse updateArticle(@RequestAttribute String userId, @PathVariable String articleId, @RequestBody ArticleUpdateRequest articleUpdateRequest) {
        var input = new ArticleUpdateInputData(userId, articleId, articleUpdateRequest.title(), articleUpdateRequest.content(), articleUpdateRequest.communityId());
        var response = new ArticleUpdateResponse();

        try {
            ArticleUpdateOutputData output = updateArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public ArticleDeleteResponse deleteArticle(@RequestAttribute String userId, @PathVariable String articleId) {
        var input = new ArticleDeleteInputData(userId, articleId);

        var response = new ArticleDeleteResponse();
        try {
            ArticleDeleteOutputData output = deleteArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public SearchArticleResponse searchArticle(
            @RequestParam(value = "communityId", required = false) String communityId,
            @RequestParam(value = "q", required = false) String query
            ) {
        var input = new ArticleSearchInputData(communityId, query);
        var response = new SearchArticleResponse();

        try {
            ArticleSearchOutputData output = searchArticleUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
