package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.db.context.ArticleContext;
import com.mokimaki.arput.infrastructure.db.context.UserContext;
import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArticleRepository implements IArticleRepository {
    private final ArticleContext articleContext;
    private final UserContext userContext;

    public ArticleRepository(ArticleContext articleContext, UserContext userContext) {
        this.articleContext = articleContext;
        this.userContext = userContext;
    }

    @Override
    public void create(Article article) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        articleContext.save(articleEntity);
    }

    @Override
    public Optional<Article> findById(ArticleId id) {
        return articleContext.findById(id.getId()).map(ArticleEntity::convert);
    }

    public Optional<Article> findByArticleIdAndUserId(ArticleId articleId, UserId userId) {
        UserEntity writer = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザが存在しません"));

        return articleContext.findByIdAndWriter(articleId.getId(), writer).map(ArticleEntity::convert);
    }
}
