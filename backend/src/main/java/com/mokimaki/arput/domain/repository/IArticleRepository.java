package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import com.mokimaki.arput.domain.model.community.CommunityId;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;

import java.util.List;
import java.util.Optional;

public interface IArticleRepository {
    void create(Article article);

    Optional<Article> findById(ArticleId id);

    Optional<Article> findByArticleIdAndUserId(ArticleId articleId, UserId userId);

    List<Article> findByUserId(UserId userId);
    void update(Article article);
    void delete(Article article);
    void addEvaluation(User user, Article article, Evaluation evaluation);
    void removeEvaluation(User user, Article article, Evaluation evaluation);
    boolean isAlreadyEvaluated(User user, Article article, Evaluation evaluation);
    List<Article> findByCommunityId(CommunityId communityId);
}
