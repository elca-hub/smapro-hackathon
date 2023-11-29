package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.article.ArticleCreateRequest;
import com.mokimaki.arput.presentation.request.article.ArticleUpdateRequest;
import com.mokimaki.arput.presentation.response.article.ArticleCreateResponse;
import com.mokimaki.arput.presentation.response.article.ArticleIndexResponse;
import com.mokimaki.arput.presentation.response.article.ArticleShowResponse;
import com.mokimaki.arput.presentation.response.article.ArticleUpdateResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/article")
public interface ArticleRouting {
    @PostMapping("/")
    ArticleCreateResponse createArticle(String userId, @RequestBody ArticleCreateRequest articleCreateRequest);

    @GetMapping("/")
    ArticleIndexResponse indexArticle(String userId);

    @GetMapping("/{articleId}")
    ArticleShowResponse showArticle(String userId, String articleId);

    @PutMapping("/{articleId}")
    ArticleUpdateResponse updateArticle(String userId, String articleId, @RequestBody ArticleUpdateRequest articleUpdateRequest);
}
