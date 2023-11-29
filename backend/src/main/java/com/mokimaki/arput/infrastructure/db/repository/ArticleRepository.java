package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.db.context.ArticleContext;
import com.mokimaki.arput.infrastructure.db.context.EvaluatedArticleContext;
import com.mokimaki.arput.infrastructure.db.context.EvaluationContext;
import com.mokimaki.arput.infrastructure.db.context.UserContext;
import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.EvaluatedArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.EvaluationEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepository implements IArticleRepository {
    private final ArticleContext articleContext;
    private final UserContext userContext;
    private final EvaluationContext evaluationContext;
    private final EvaluatedArticleContext evaluatedArticleContext;

    public ArticleRepository(
            ArticleContext articleContext,
            UserContext userContext,
            EvaluationContext evaluationContext,
            EvaluatedArticleContext evaluatedArticleContext
    ) {
        this.articleContext = articleContext;
        this.userContext = userContext;
        this.evaluationContext = evaluationContext;
        this.evaluatedArticleContext = evaluatedArticleContext;
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

    @Override
    public List<Article> findByUserId(UserId userId) {
        UserEntity writer = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザが存在しません"));

        return articleContext.findByWriter(writer).stream().map(ArticleEntity::convert).toList();
    }

    @Override
    public void update(Article article) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        articleContext.save(articleEntity);
    }

    @Override
    public void delete(Article article) {
        articleContext.deleteById(article.getId().getId());
    }

    public void addEvaluation(Article article, Evaluation evaluation) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        var evaluationEntity = new EvaluationEntity();
        evaluationEntity.convert(evaluation);

        var evaluatedArticleEntity = new EvaluatedArticleEntity();
        evaluatedArticleEntity.setEvaluation(evaluationEntity);
        evaluatedArticleEntity.setArticle(articleEntity);

        evaluatedArticleContext.save(evaluatedArticleEntity);
    }
}
