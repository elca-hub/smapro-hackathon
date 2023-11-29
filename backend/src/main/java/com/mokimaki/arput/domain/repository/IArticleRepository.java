package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.UserId;

import java.util.Optional;

public interface IArticleRepository {
    void create(Article article);

    Optional<Article> findById(ArticleId id);

    Optional<Article> findByArticleIdAndUserId(ArticleId articleId, UserId userId);
}
