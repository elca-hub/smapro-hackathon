package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.article.ArticleCreateRequest;
import com.mokimaki.arput.presentation.response.article.ArticleCreateResponse;
import com.mokimaki.arput.presentation.response.article.ArticleShowResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/{userId}/article")
public interface ArticleRouting {
    @PostMapping("/")
    ArticleCreateResponse createArticle(String userId, @RequestBody ArticleCreateRequest articleCreateRequest);

    @GetMapping("/{articleId}")
    ArticleShowResponse showArticle(String userId, String articleId);
}
