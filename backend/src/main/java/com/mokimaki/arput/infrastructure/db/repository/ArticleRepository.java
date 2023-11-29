package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.db.context.ArticleContext;
import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository implements IArticleRepository {
    private final ArticleContext articleContext;

    public ArticleRepository(ArticleContext articleContext) {
        this.articleContext = articleContext;
    }

    @Override
    public void create(Article article) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        articleContext.save(articleEntity);
    }
}
